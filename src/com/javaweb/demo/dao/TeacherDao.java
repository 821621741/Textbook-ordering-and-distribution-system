package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Teacher;


import java.util.List;

public interface TeacherDao {
    public boolean login(String name,String pwd);//登录
//    public boolean findTeacher(String tno);
    public List<Teacher> getTeacherAll();//返回所有老师信息集合
    public boolean deleteTeacher(String id) ;//根据id删除老师
//    public boolean updateTeacher(String id, String name, String dept, String tel, String email,String cno);//更新用户信息
    public boolean addTeacher(Teacher te);
    public boolean updateTeacher(Teacher te);

    //    根据名字查找老师


    public Teacher FindTeacher(String Tno);//,String cno
//    public List<Teacher> FindTeacherByDC(String dept);//,String cno
//    public Teacher FindTeacherByAllMessage(String allMessage);

    public List<Teacher> FindTeacherBytno(String tno);
    public List<Teacher> FindTeacherByname(String  Tname);
    public List<Teacher> FindTeacherBydept(String Tdept);
    public List<Teacher> FindTeacherByTtel(String Ttel);
    public List<Teacher> FindTeacherByTemail(String Temail);


//    public List<Teacher> FindTeacherByDN(String dept,String tname);
    public boolean updateTeacher(String id, String name, String dept, String tel, String email);
    public boolean modifyPwd(String id,String pwd);
//    public List<Teacher> topQuery(Teacher teacher);





//    public boolean login(String name,String pwd);//判断教师登录信息
//    public Teacher FindTeacher(String tno);//通过教师号得到该教师的所有信息
    public boolean updateTeacher(String id, String name, String tel, String email);//教师更改自己的信息
//    public boolean modifyPwd(String id,String pwd);//更改教师登录密码

}
