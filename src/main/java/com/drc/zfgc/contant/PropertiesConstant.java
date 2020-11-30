package com.drc.zfgc.contant;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/26
 */
public class PropertiesConstant {

    /*
    hive配置
     */
    public static String HIVE_DATABASE = "drcnet_ods";
    public static String HIVE_TABLE = "ods_zfcg";
    public static String QUERY_FIELD = "url_id, category, category_url, purchaser, notice, pubtime, region, title, agency, url, content, hashcode";




    /*
    hbase 配置
     */
    public static String HBASE_NAME_SPACE = "ns_zfcg";
    public static String HBASE_TABLE_NAME = "dwd_zfcg_data";
    public static String COLUMN_FAMILY = "zfcg";
  //  public static String columnFamily2 = "htgg";


}
