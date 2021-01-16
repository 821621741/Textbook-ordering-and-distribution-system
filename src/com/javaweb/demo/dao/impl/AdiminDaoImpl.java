package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.AdminDao;
import com.javaweb.demo.entity.Admin;

import com.javaweb.demo.entity.Admin;
import com.javaweb.demo.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdiminDaoImpl implements AdminDao {

    //重写登录方法，传入管理员和id和密码，返回是否匹配（是否登录成功）
    @Override
    public boolean login(String id, String pwd) {
        boolean loginflag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from admin where Mno='" + id + "' and password='" + pwd + "'");
//          ResultSet.next()返回结果：true如果新的当前行是有效的； false如果没有更多的行（jdk1.8API）
            while (rs.next()) {     //从表中第一行一直找到最后一行
//                boolean getBoolean(String columnLabel)
//                      throws SQLException
//                检索指定的列在这 ResultSet对象的当前行的值作为java编程语言中的一个 boolean。
                if (rs.getString("Mno").equals(id) && rs.getString("password").equals(pwd)) {
//                    传进来的id和pwd如果和rs指定列的Mno和password相同，则flag为true
                    loginflag = true;
                }
            }
            DBconn.closeConn(); //关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginflag;
    }

    //重写修改密码方法,返回是否修改成功
    @Override
    public boolean modifyPwd(String id,String pwd){
        boolean modifyFlag = false;
        DBconn.init();
        String sql = "update admin set password=" + pwd + " where Mno=" + id;
        int i = DBconn.addUpdDel(sql);
        if(i > 0){ //i>0说明对数据库的修改影响了1行及以上，说明已经有东西被修改了，说明修改成功
            modifyFlag = true;
        }
        DBconn.closeConn();
        return modifyFlag;
    }

    //重写修改信息方法,返回是否修改成功
    @Override
    public boolean updateInfo(Admin admin) {
        boolean infoFlag = false;
        DBconn.init();
        String sql ="update admin set Mname ='"+admin.getMname()
                +"' , Mtel ='"+admin.getMtel()
                +"' , Meamil ='"+admin.getMeamil()
              +"' where Mno = "+admin.getMno();
        int i =DBconn.addUpdDel(sql);
        if(i > 0){
            infoFlag = true;
        }
        DBconn.closeConn();
        return infoFlag;

    }

    @Override
    public boolean updateInfo(String Mno, String Mname,  String Mtel, String Memail) {
        boolean flag = false;
        DBconn.init();
        String sql ="update admin set Mname ='"+Mname
                +"' , Mtel ='" + Mtel
                +"' , Memail ='"+Memail
            +"' where Mno = "+Mno;
        int i = DBconn.addUpdDel(sql);
        if(i > 0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    //查找班长
    @Override
    public Admin FindAdmin(String id) {
        Admin admin =new Admin();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from admin where Mno = '" + id + "'");
            while(rs.next()){
                admin.setMno(rs.getString("Mno"));
                admin.setMname(rs.getString("Mname"));
                admin.setMtel(rs.getString("Mtel"));
                admin.setMeamil(rs.getString("Memail"));
                admin.setPassword(rs.getString("password"));
            }
            DBconn.closeConn();
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
