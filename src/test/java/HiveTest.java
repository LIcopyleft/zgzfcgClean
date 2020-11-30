import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import com.drc.zfgc.utils.HiveJdbcConUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;
import java.sql.*;

/**
 * @author tengchao.li
 * @description
 * @date 2020/10/30
 */
/*@SpringBootTest(value = "application.yml")
@RunWith(SpringJUnit4ClassRunner.class)*/
public class HiveTest {

    /*  @Autowired
      @Qualifier("hiveDruidDataSource")
      private DataSource druidDataSource;

      @Test*/
    public static void main(String[] args) throws IOException, InterruptedException {

        //  getData();

        org.apache.hadoop.hbase.client.Connection con = HBaseJdbcConUtil.getCon();


        Thread.sleep(1000*70);
        System.out.println("=====");
        if (con.isClosed()) {
            con = HBaseJdbcConUtil.getCon();
        }
        HBaseJdbcConUtil.closeConnection(con);
        if (con.isClosed()) {
            con = HBaseJdbcConUtil.getCon();
        }

        Table table = con.getTable(TableName.valueOf("zfcg"));
        System.out.println();

    }


    public static void getData() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        JSONObject result = null;
        try {

            conn = HiveJdbcConUtil.getConnnection();
            //   conn = druidDataSource.getConnection();

            statement = conn.createStatement();
            result = new JSONObject();
            result.put("state", "0");
            JSONArray array = new JSONArray();

            String sqlString = "select * from ods_zfcg";
            rs = statement.executeQuery(sqlString);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject();
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    //   jsonObj.put(columnName.replaceAll("ods_zfcg\\.",""), value);
                    jsonObj.put(columnName.split("\\.")[1], value);
                }
                array.add(jsonObj);
            }
            result.put("analysisMACResult", array.toString());

            System.out.println(result.toJSONString());
        } catch (SQLException e) {
            e.printStackTrace();
            //   return "{\"state\":\"1\"}";
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                //      return "{\"state\":\"1\"}";
            }
        }
        //    return result.toString();
    }

    //明天: 设置自动启动主类

    /*
     *  多线程处理
     *
     *  rowKey设计代码
     *
     * 测试通 hive 到 hbase
     *
     *
     */


}
