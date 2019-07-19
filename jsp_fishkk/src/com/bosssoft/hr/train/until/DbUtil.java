package com.bosssoft.hr.train.until;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */

import java.sql.*;

public class DbUtil {
    /**
     *数据库服务器地址
     */
    static String IP = "47.94.200.0";

    /**
     *服务器连接端口号
     */
    static int PORT = 3306;

    /**
     *数据库名称
     */
    static String DATABASE = "jsp";

    /**
     *编码格式
     */
    static String ENCODING = "UTF-8";

    /**
     *登入用户名
     */
    static String LOGINNAME = "fishkk";

    /**
     *登入密码
     */
    static String PASSWORD = "Root.123";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", IP ,PORT, DATABASE, ENCODING );
        return DriverManager.getConnection(url, LOGINNAME, PASSWORD);
    }

    /** 关闭连接的方法 */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}