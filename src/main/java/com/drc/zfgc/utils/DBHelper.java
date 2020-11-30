package com.drc.zfgc.utils;

/**
 * @author tengchao.li
 * @description
 * @date 2020/9/30
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public static final String url = "jdbc:mysql://20.0.0.100:3306/spider_2020?useSSL=FALSE&serverTimezone=UTC&allowPublicKeyRetrieval=true&useCursorFetch=TRUE";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "admin123";

    public static Connection conn = null;

    public static Connection getConn() {
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

