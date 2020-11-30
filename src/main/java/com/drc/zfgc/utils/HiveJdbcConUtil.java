package com.drc.zfgc.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class HiveJdbcConUtil {

    private static String DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";   // 此Class 位于 hive-jdbc的jar包下
    private static String URL = null;    //填写hive的IP，之前在配置文件中配置的IP 测试
    private static String USER = null;    //填写hive的IP，之前在配置文件中配置的IP 测试
    private static String PASSWD = null;    //填写hive的IP，之前在配置文件中配置的IP 测试
    private static String TYPE = null;    //填写hive的IP，之前在配置文件中配置的IP 测试

    static {
        try {
            Properties properties = PropertiesUtil.getResource("hive.properties");

            if (properties != null) {
                URL = properties.getProperty("url");
                USER = properties.getProperty("username");
                PASSWD = properties.getProperty("password");
                TYPE = properties.getProperty("type");
                DRIVER_NAME = properties.getProperty("driver-class-name");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //    private static String Url="jdbc:hive2://192.168.0.24:10000/";    //填写hive的IP，之前在配置文件中配置的IP 正式库
    private static Connection conn;

    public static Connection getConnnection() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWD);        //只是连接hive, 用户名可不传
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        //    System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public static void closeConnection(Connection conn) {

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
