package com.drc.zfgc.contant;

import java.io.InputStream;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/26
 */
public class PropertiesConstant {

    /*
    服务配置
     */
    /*
    flink配置
     */
    public static int FLINK_PARALLELISM = 10;
    public static String CONFIG_PATH = "/opt/flink-1.11.2/jars/config";

    /*
    hive配置
     */
    public static String HIVE_DATABASE = "drcnet_ods";
    public static String HIVE_TABLE = "ods_zfcg";
 //   public static String HIVE_TABLE = "ods_zfcg_content";
    public static String QUERY_FIELD = "url_id, category, category_url, purchaser, notice, pubtime, region, title, agency, url, content, hashcode";


    /*
    hbase 配置
     */
    public static String HBASE_NAME_SPACE = "ns_zfcg";
    public static String HBASE_TABLE_NAME = "dwd_zfcg_data";
    public static String COLUMN_FAMILY = "zfcg";
    public static String HBASE_CONFIG_PATH = "xml/hbase-site.xml";
    //  public static String columnFamily2 = "htgg";


}
