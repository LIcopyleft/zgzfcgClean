package com.drc.zfgc.pool;

import org.apache.hadoop.hbase.client.Connection;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

/**
 * @author DRC
 */
public interface IConnectionPool {

    /*初始化*/
    void init(int initSize,int maxSize,int idleCount,long waitTime);
    /*获取连接*/
    Object getConnection();
    /*回收*/
    void recycle(Object conn);
    /*销毁*/
    void destory();


}
