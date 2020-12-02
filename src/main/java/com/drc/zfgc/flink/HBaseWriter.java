package com.drc.zfgc.flink;


import cn.hutool.core.bean.BeanUtil;
import com.drc.zfgc.contant.PropertiesConstant;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import com.drc.zfgc.utils.StringUtil;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.hbase.client.BufferedMutatorParams;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/25
 */
public class HBaseWriter extends RichSinkFunction<CNGovCleanData> {

    private static final Logger logger = LoggerFactory.getLogger(HBaseWriter.class);
  //  private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HBaseWriter.class);

    private static org.apache.hadoop.conf.Configuration configuration;
    private static Connection connection = null;
    private static BufferedMutator mutator;
    private static int count = 0;

    @Override
    public void open(Configuration parameters) throws Exception {


        //connection = ConnectionFactory.createConnection(configuration);
        connection = HBaseJdbcConUtil.getCon();

        BufferedMutatorParams params = new BufferedMutatorParams(TableName.valueOf(PropertiesConstant.HBASE_TABLE_NAME));
        params.writeBufferSize(5 * 1024 * 1024);
        mutator = connection.getBufferedMutator(params);
    }

    @Override
    public void close() throws IOException {

        //   logger.error("想要调用close方法 ------------------------------------------------------------------------------");
        mutator.flush();
        /*if (mutator != null) {
            mutator.close();
        }
        if (connection != null) {
            connection.close();
        }*/
    }

    @Override
    public void invoke(CNGovCleanData values, Context context) throws Exception {
        //Date 1970-01-06 11:45:55  to 445555000

        //    logger.info("开始写入hbase...................");
        //    long unixTimestamp= 0;
        /*try {
            String gatherTime = values.GatherTime;
            //毫秒和秒分开处理
            if (gatherTime.length() > 20) {
                long ms = Long.parseLong(gatherTime.substring(20, 23));
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(gatherTime);
                unixTimestamp = date.getTime() + ms;
            } else {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(gatherTime);
                unixTimestamp = date.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
     /*   String RowKey = values.getUrl_id() + String.valueOf(unixTimestamp);
        String Key = values.getCategory_url();
        String Value = values.getCategory_url();
        System.out.println("Column Family=f1,  RowKey=" + RowKey + ", Key=" + Key + " ,Value=" + Value);
        Put put = new Put(RowKey.getBytes());
        put.addColumn("f1".getBytes(), Key.getBytes(), Value.getBytes());
*/
        Integer urlId = values.getUrlId();

        Put put = new Put(Bytes.toBytes(StringUtil.getRowKey(urlId.toString())));
        //   put.addColumn(Bytes.toBytes("columnFamily"), Bytes.toBytes("next.getKey()"), Bytes.toBytes(next.getValue().toString()));
        Map<String, Object> map = BeanUtil.beanToMap(values);
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            if (next.getValue() != null) {
                put.addColumn(Bytes.toBytes(PropertiesConstant.COLUMN_FAMILY), Bytes.toBytes(next.getKey()), Bytes.toBytes(next.getValue().toString()));
            }
        }

        //   put.addColumn(Bytes.toBytes(HbaseProperties.columnFamily1), Bytes.toBytes("url_id"), Bytes.toBytes(values.getUrlId().toString()));

        mutator.mutate(put);
        //每满500条刷新一下数据
        if (count >= 3000) {

            System.out.println(mutator.getName()+"\tcount = 3000 开始刷入...................");
            logger.info("count = 3000 开始刷入...................");
            mutator.flush();
            count = 0;
        }
        count = count + 1;
    }

}
