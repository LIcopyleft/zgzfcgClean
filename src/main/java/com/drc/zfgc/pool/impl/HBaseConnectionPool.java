package com.drc.zfgc.pool.impl;

import com.drc.zfgc.pool.IConnectionPool;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import org.apache.hadoop.hbase.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description mysql连接池
 * @date 2020/11/5
 */
public class HBaseConnectionPool implements IConnectionPool {


    //初始化连接数量
    public int initSize;
    //最大连接数量
    public int maxSize;
    //最大空闲连接数量
    public int idleCount;
    //最大等待时间
    public long waitTime;
    //活跃连接数
    public AtomicInteger activeSize;
    //空闲队列
    public BlockingQueue<Connection> idle;
    //已使用队列
    public BlockingQueue<Connection> busy;

    private static Logger logger = LoggerFactory.getLogger(HBaseConnectionPool.class);

    public HBaseConnectionPool(int initSize, int maxSize, int idleCount, long waitTime) {
        init(initSize, maxSize, idleCount, waitTime);
    }


    @Override
    public void init(int initSize, int maxSize, int idleCount, long waitTime) {

        this.initSize = initSize;
        this.maxSize = maxSize;
        this.idleCount = idleCount;
        this.waitTime = waitTime;
        this.activeSize = new AtomicInteger();
        this.idle = new LinkedBlockingQueue<Connection>();
        this.busy = new LinkedBlockingQueue<Connection>();
        //初始化连接
        initConnection(initSize);

    }

    private void initConnection(int initSize) {
        for (int i = 0; i < initSize; i++) {
            if (activeSize.get() < maxSize) {//两重判断是为了保证线程安全
                if (activeSize.incrementAndGet() <= maxSize) {
                    //创建连接
                    Connection conn = HBaseJdbcConUtil.getCon();
                    //加入空闲队列
                    idle.offer(conn);
                } else {
                    activeSize.decrementAndGet();
                }
            }
        }
    }

    @Override
    public Connection getConnection() {
        long startTime = System.currentTimeMillis();
        //1.从空闲队列里获取,return
        Connection conn = idle.poll();
        if (conn != null) {
            busy.offer(conn);
            logger.info("[" + Thread.currentThread().getName() + "]" + idle.size() + "个************从空闲队列获取连接************");
            return conn;
        }
        //2.空闲队列没有连接了，并且活跃连接数量不超过最大连接数量,创建一个新的连接return
        if (activeSize.get() < maxSize) {//两重判断是为了保证线程安全
            synchronized (this) {
                if (activeSize.incrementAndGet() <= maxSize) {
                    conn = HBaseJdbcConUtil.getCon();
                    logger.info("[" + Thread.currentThread().getName() + "]" + " ************创建一个新的连接************");
                    busy.offer(conn);
                    return conn;
                } else {
                    activeSize.decrementAndGet();
                }
            }

        }
        //3.连接全部正在使用，并且活跃连接数超过最大连接数量，则等待正在使用的连接被回收到空闲队列。
        //waitTime代表getConnection()方法的等待时间，poll方法阻塞时间其中一部分
        long timeout = waitTime - (System.currentTimeMillis() - startTime);
        try {
            //阻塞方法，等待从idle队列获取连接
            conn = idle.poll(timeout, TimeUnit.MILLISECONDS);

            if (conn == null) {
                conn = getConnection();
             //   throw new TimeoutException("[" + Thread.currentThread().getName() + "]" + " ************获取连接超时，等待时间为" + timeout + "ms************");
            }
            busy.offer(conn);
        } catch (InterruptedException /*| TimeoutException*/ e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void recycle(Object conn) {
        if (conn == null) {
            return;
        }
        //回收连接，就是将连接从使用队列移动到空闲队列
        if (busy.remove(conn)) {//第一步，移除
            //如果实际的空闲连接数量大于用户指定的最大空闲连接数量，则连接多余了，关闭连接
            if (idle.size() >= idleCount) {
                HBaseJdbcConUtil.closeConnection((Connection) conn);
                //关闭连接，则活跃连接减一
                activeSize.decrementAndGet();
                logger.info("[" + Thread.currentThread().getName() + "]" + " ++++空闲连接数量太多，关闭连接++++");
                return;
            }
            if (!idle.offer((Connection) conn)) {//第二步，放入，如果放入空闲队列失败，关闭连接
                HBaseJdbcConUtil.closeConnection((Connection) conn);
                activeSize.decrementAndGet();
            }
            logger.info("[" + Thread.currentThread().getName() + "]" + " ++++回收连接成功++++");
        } else {//从busy队列移除失败，可能因为该连接不在busy队列中
            HBaseJdbcConUtil.closeConnection((Connection) conn);
            activeSize.decrementAndGet();
            logger.info("[" + Thread.currentThread().getName() + "]" + " ++++未知连接，直接关闭，不予回收++++");
        }
    }

    @Override
    public void destory() {
        while (busy.size() != 0) {
            recycle(busy.poll());
        }
        while (idle.size() != 0) {
            HBaseJdbcConUtil.closeConnection(idle.poll());
            activeSize.decrementAndGet();
        }
    }
}
