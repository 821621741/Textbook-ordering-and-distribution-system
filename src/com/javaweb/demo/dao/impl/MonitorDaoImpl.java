package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MonitorDaoImpl implements MonitorDao {
    //增加班长，返回是否成功
    public boolean addMonitor(Monitor mo){
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into monitor(Cno,Cgrade,Cdept,Cmajor,Cnum,password) " +
                "values('" + mo.getCno()+ "','" + mo.getCgrade() + "','" +mo.getCdept()+ "','" + mo.getCmajor()+ "','" + mo.getCnum() + "','" + mo.getPassword()+ "')");

        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Monitor> FindMonitorByCno(String id) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno like '%" + id +"%'");
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> FindMonitorByCdept(String dept) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cdept like '%" + dept + "%'");
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> FindMonitorByCgrade(String grade) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cgrade like '%" + grade + "%'");
                while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> FindMonitorByCmajor(String major) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cmajor like '%" + major + "%'");
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Monitor> FindMonitorBynum(String num){
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cnum like '%" + num + "%'");
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

    public Monitor findMonitorByCno1(String id) {
        try {
            Monitor monitor =  new Monitor();
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno="+id);
            while(rs.next()){
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));

            }
            DBconn.closeConn();
            return monitor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno='"+id+"' and password='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("Cno").equals(id) && rs.getString("password").equals(pwd)){
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    //获得所有班长
    @Override
    public List<Monitor> getMonitorAll(){
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor");
            while(rs.next()){
                Monitor Monitor =  new Monitor();
                Monitor.setCno(rs.getString("Cno"));
                Monitor.setCdept(rs.getString("Cdept"));
                Monitor.setCgrade(rs.getString("Cgrade"));
                Monitor.setCmajor(rs.getString("Cmajor"));
                Monitor.setCnum(rs.getString("Cnum"));
                Monitor.setPassword(rs.getString("password"));
                list.add(Monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from Monitor where Cno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }

        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String garde, String dept, String major, String num) {
        boolean flag = false;
        DBconn.init();
        String sql ="update Monitor set Cgarde ='"+garde
                +"' , Cdept ='"+dept
                +"' , Cmajor ='"+major
                +"' , Cnum ='"+num+"' where Cno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String num) {
        boolean flag = false;
        DBconn.init();
        String sql ="update Monitor set Cnum ='"+num
                +"' where Cno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(Monitor mo) {
        boolean flag = false;
        DBconn.init();
        String sql ="update monitor set Cgrade ='"+mo.getCgrade()
                +"' , Cdept ='"+mo.getCdept()
                +"' , Cmajor ='"+mo.getCmajor()
                +"' , password ='"+mo.getPassword()
                +"' , Cnum ='"+mo.getCnum()+"' where Cno = "+mo.getCno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        else{
            Monitor m = new Monitor();
            m.setCno(mo.getCno());
            m.setCgrade(mo.getCgrade());
            m.setCdept(mo.getCdept());
            m.setCmajor(mo.getCmajor());
            m.setCnum(mo.getCnum());
            m.setPassword(mo.getPassword());
            System.out.println(m.getCno());
            addMonitor(m);

        }
        DBconn.closeConn();
        return flag;
    }

    //修改班长密码
    public boolean modifyPwd(String cno, String pwd) {
        boolean flag = false;
        DBconn.init();
        String sql = "update monitor  set password=" + pwd + " where Cno=" + cno;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}
