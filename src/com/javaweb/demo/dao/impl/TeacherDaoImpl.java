package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.entity.*;
import com.javaweb.demo.entity.Teacher;
import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public boolean addTeacher(Teacher te){
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into teacher(Tno,Tname,Tdept,Ttel,Temail,password) " +
                "values('" + te.getTno()+ "','" + te.getTname() + "','" + te.getTdept() + "','" + te.getTtel()+ "','" + te.getTemail() +"','" +te.getPassword()+ "')");
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Teacher> getTeacherAll() {
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteTeacher(String tno) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from teacher where Tno="+tno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean updateTeacher(String id, String name, String dept, String tel, String email) {
        boolean flag = false;
        DBconn.init();
        String sql ="update teacher set Tname ='"+name
                +"' , Tdept ='"+dept
                +"' , Ttel ='"+tel
                +"' , Temail ='"+email
                 +"' where Tno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    @Override
    public boolean updateTeacher(Teacher te) {
        boolean flag = false;
        System.out.println(te.toString());

        DBconn.init();
        String sql ="update Teacher set Tname ='"+te.getTname()
                +"' , Tdept ='"+te.getTdept()
                +"' , Ttel ='"+te.getTtel()
                +"' , Temail ='"+te.getTemail()
                + "' where Tno = "+te.getTno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

//    根据教师号查询老师
    @Override
    public List<Teacher> FindTeacherBytno(String tno){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno like '%"+tno+"%'");
            while(rs.next()){
                System.out.println("成功根据教师号:" + tno + " 查找出符合条件的信息");
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    根据学院查找老师
    @Override
    public List<Teacher> FindTeacherBydept(String Tdept){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tdept like '%"+Tdept+"%'");
            while(rs.next()){
                System.out.println("成功根据学院名:" + Tdept + " 查找出符合条件的信息");
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


//    根据名字查找老师
    @Override
    public List<Teacher> FindTeacherByname(String Tname){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tname like '%"+Tname+"%'");
            while(rs.next()){
                System.out.println("成功根据教师名:" + Tname + " 查找出符合条件的信息");
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //    根据名字查找老师
    @Override
    public List<Teacher> FindTeacherByTtel(String Ttel){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Ttel like '%"+Ttel+"%'");
            while(rs.next()){
                System.out.println("成功根据教师电话:" + Ttel + " 查找出符合条件的信息");
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Teacher> FindTeacherByTemail(String Temail){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Temail like '%"+Temail+"%'");
            while(rs.next()){
                System.out.println("成功根据教师邮箱:" + Temail + " 查找出符合条件的信息");
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean modifyPwd(String id,String pwd){
        boolean flag = false;
        DBconn.init();
        String sql = "update teacher  set password="+pwd+" where Tno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    } //更改教师登录密码

    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+id+"' and password='"+pwd+"'");//查询id和password
            while(rs.next()){//依次读取查询到的rs
                if(rs.getString("Tno").equals(id) && rs.getString("password").equals(pwd)){//判断id和password是否相同，如果相同 逻辑为true，否则为false
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    } //判断教师登录信息

    public boolean updateTeacher(String tno, String name, String tel, String email) {
        boolean flag = false;
        DBconn.init();
        String sql ="update teacher set Tname ='"+name
                +"' , Ttel ='"+tel
                +"' , Temail ='"+email
                +"' where Tno = "+tno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    } //教师更改自己的信息

    public Teacher FindTeacher(String tno){
        Teacher teacher =  new Teacher();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+tno+"'");
            while(rs.next()){
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setPassword(rs.getString("password"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                CourseDao co = new CourseDaoImpl();
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    } //通过教师号得到该教师的所有信息

}