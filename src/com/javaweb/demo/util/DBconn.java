
package com.javaweb.demo.util;

import java.sql.*;

//用于连接数据库
public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/ywyz?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"; // 数据库连接url
    static String username = "root"; // 数据库用户名
    static String password = "123456"; // 用户密码
    static Connection conn = null; // 初始化一个数据连接 conn
    static ResultSet rs = null; // 初始化一个结果集 rs
    static PreparedStatement ps =null; // 初始化一个PreparedStatement对象 ps

    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//             DriverManager.getConnection  获取数据库连接,返回一个Connection对象
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }


//    数据库修改
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);
            //返回修改影响的行数
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }



    //数据库查找
    public static ResultSet selectSql(String sql){
        try {
            ps =  conn.prepareStatement(sql);
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }



    //断开数据库连接
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}
