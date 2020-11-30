import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.pool.IConnectionPool;
import com.drc.zfgc.pool.impl.HBaseConnectionPool;
import com.drc.zfgc.pool.impl.HiveConnectionPool;
import com.drc.zfgc.pool.impl.MysqlConnectionPool;
import com.drc.zfgc.thread.CNGovHtggDataCleanTask;
import com.drc.zfgc.thread.bigdata.BigDataCleanTask;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import com.drc.zfgc.utils.HiveJdbcConUtil;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/5
 */
public class PoolTest {

    private static int threadNum = 10;
    static final String tableName = "test_hbase";
    static final String namespace = "ns_zfcg";
    static final String columnFamily1 = "zfcg";
    static final String columnFamily2 = "zbgg";
    public static void main(String[] args) throws InterruptedException {
     //   mysqlPoolTest();
    //    hbasePoolTest();

        cleanTest();
    }

    private static void mysqlPoolTest() {
        String sql = "select * from test_region where region_id = 110000";
        CountDownLatch cdl = new CountDownLatch(1);
        IConnectionPool pool = new MysqlConnectionPool(10, 20, 15, 2000L);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                Connection conn = null;
                try {
                    cdl.await();  //阻塞在这，等待所有线程准备好，发令枪响，一起执行
                    conn = (Connection) pool.getConnection();
                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();
                    while (result.next()) {
                        String email = result.getString(1);
                        System.out.println("【email】:" + email);
                    }
                    //Thread.currentThread().sleep(1000L*new Random().nextInt(5));//模拟线程占用连接的时间
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                } finally {

                    pool.recycle(conn);

                }
            }).start();

        }
        cdl.countDown();  //发令枪，唤醒所有线程
        sleep(3000);//等待所有线程执行完毕
        System.out.println("已建立连接数：" + ((MysqlConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((MysqlConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((MysqlConnectionPool) pool).busy.size());
        pool.destory();
        System.out.println("detroy MysqlConnectionPool!!");
        System.out.println("已建立连接数：" + ((MysqlConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((MysqlConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((MysqlConnectionPool) pool).busy.size());
    }


    private static Integer MAX_THREAD_NUM = 1;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_THREAD_NUM);

    private static void  cleanTest() throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(1);
        HiveConnectionPool pool = new HiveConnectionPool(10, 20, 15, 200000L);
        HBaseConnectionPool hbasePool = new HBaseConnectionPool(10, 20, 15, 200000L);




        int beginIndex = 0;
        int minUrlId = 0;
        int maxUrlId = 1;
        int QUERY_SIZE = 100000;

        int times = maxUrlId / QUERY_SIZE;

        if ((maxUrlId - minUrlId) % QUERY_SIZE != 0) {
            times = times + 1;
        }

        System.out.println("总需要执行次数:    " + times + "   次");
        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));

        ConfigParam config = new ConfigParam();
        config.setInsertMax(5000);
        AtomicInteger at = new AtomicInteger();
        config.setFinishNum(at);
        config.setLatch(latch);


        for (int i = 0; i < times; i++) {

            String hivesql = "select * from ods_zfcg";

            int endIndex = beginIndex + QUERY_SIZE;
            Runnable task = new BigDataCleanTask(beginIndex, endIndex,hivesql,config,pool,hbasePool);
            beginIndex += QUERY_SIZE;
            EXECUTOR.execute(task);
        }
        latch.await();
    //    Thread.sleep(1000000);
 //     HiveJdbcConUtil.prepare(hiveConnection,);

//        for (int i = 0; i < threadNum; i++) {
//            new Thread(() -> {
//                org.apache.hadoop.hbase.client.Connection conn = null;
//                try {
//                    cdl.await();  //阻塞在这，等待所有线程准备好，发令枪响，一起执行
//                    conn = (org.apache.hadoop.hbase.client.Connection) pool.getConnection();
//                    //    Object connection = pool.getConnection();
//                    HBaseJdbcConUtil.scanData(conn,tableName);
//
//                    //Thread.currentThread().sleep(1000L*new Random().nextInt(5));//模拟线程占用连接的时间
//                } catch (InterruptedException | IOException e) {
//                    e.printStackTrace();
//                } finally {
//
//                    pool.recycle(conn);
//
//                }
//            }).start();
//
//        }
//        cdl.countDown();  //发令枪，唤醒所有线程
//        sleep(3000);//等待所有线程执行完毕
       /* System.out.println("已建立连接数：" + ((HBaseConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((HBaseConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((HBaseConnectionPool) pool).busy.size());*/
        pool.destory();
      /*  System.out.println("detroy MysqlConnectionPool!!");
        System.out.println("已建立连接数：" + ((HBaseConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((HBaseConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((HBaseConnectionPool) pool).busy.size());*/

        System.out.println("----------------------------------任务执行完成----------------------------------------");
        System.exit(0);
    }




    private static void hbasePoolTest() {

        CountDownLatch cdl = new CountDownLatch(1);
        IConnectionPool pool = new HBaseConnectionPool(10, 20, 15, 200000L);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                org.apache.hadoop.hbase.client.Connection conn = null;
                try {
                    cdl.await();  //阻塞在这，等待所有线程准备好，发令枪响，一起执行
                    conn = (org.apache.hadoop.hbase.client.Connection) pool.getConnection();
                //    Object connection = pool.getConnection();
                    HBaseJdbcConUtil.scanData(conn,tableName);

                    //Thread.currentThread().sleep(1000L*new Random().nextInt(5));//模拟线程占用连接的时间
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                } finally {

                    pool.recycle(conn);

                }
            }).start();

        }
        cdl.countDown();  //发令枪，唤醒所有线程
        sleep(3000);//等待所有线程执行完毕
        System.out.println("已建立连接数：" + ((HBaseConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((HBaseConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((HBaseConnectionPool) pool).busy.size());
        pool.destory();
        System.out.println("detroy MysqlConnectionPool!!");
        System.out.println("已建立连接数：" + ((HBaseConnectionPool) pool).activeSize.get() +
                "，空闲连接数：" + ((HBaseConnectionPool) pool).idle.size() +
                "，正在使用连接数：" + ((HBaseConnectionPool) pool).busy.size());
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
