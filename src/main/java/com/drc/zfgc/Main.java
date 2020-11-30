package com.drc.zfgc;

import com.drc.zfgc.flink.FlinkHiveHbaseCleanDataMain;
import com.drc.zfgc.utils.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/5
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println(DateUtils.formatHhMmSsOfDate(new Date()) + "\t开始执行....");

        FlinkHiveHbaseCleanDataMain.cleanData(null);
    }


}
