package com.drc.zfgc.model;

import lombok.Data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description 必要配置参数
 * @date 2020/4/27
 */
@Data
public class ConfigParam {
    /**
     * 清洗类型, eg:采购公告  中标公告 ..
     */
    private String stage;
    private int beginIndex;
    private int endIndex;
    private CountDownLatch latch;
    private String insertTableName;
    private String cleanTableName;

    private int insertMax;
    private int querySize;
    private int tableNum = 0;
    private boolean isOpen = true;
    private boolean isUseUnionTable = false;
    private String unionTableName;
    private String columnFamily;
    private AtomicInteger finishNum;


    public String getColumnFamily() {
        return columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }
}
