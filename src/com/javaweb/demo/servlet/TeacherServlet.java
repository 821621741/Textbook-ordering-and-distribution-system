package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.dao.impl.TeacherDaoImpl;
import com.javaweb.demo.entity.Teacher;
import com.javaweb.demo.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    TeacherDao teacher = new TeacherDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if ("deleteTeacher".equals(option)) {
            deleteTeacher(request, response);
        } else if ("showAllTeachers".equals(option)) {
            showAllTeachers(request, response);
        } else if ("addTeacher".equals(option)) {
            addTeacher(request, response);
        } else if ("updateTeacherByManager".equals(option)) {
            updateTeacherByManager(request, response);
        } else if ("FindTeacher".equals(option)) {
         FindTeacher(request, response);
    }
    }

//    重写doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

//    管理员展示所有老师信息
    private void showAllTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers =teacher.getTeacherAll();
        request.setAttribute("teachers",teachers );
        request.getRequestDispatcher("manager_teacher_management.jsp").forward(request, response);
    }

//    管理员删除老师
    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        teacher.deleteTeacher(id);
        showAllTeachers(request, response);
    }

//    管理员修改老师信息
    private void updateTeacherByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tno = request.getParameter("tno");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        //String password = request.getParameter("password");
        Teacher te= new Teacher();
        te.setTno(tno);
        te.setTname(name);
        te.setTdept(dept);
        //te.setPassword(password);
        te.setTtel(tel);
        te.setTemail(email);
        teacher.updateTeacher(te);
        showAllTeachers(request, response);
    }

//    管理员查询教师信息
    private void FindTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
//        教师对象，用来存放教师信息

//        定义一堆及teacher对象列表，用来存放allMessage在每一列的情况所找出的符合条件的teacher
        List<Teacher> teachers1 = teacher.FindTeacherBytno(allMessage);//tno
        List<Teacher> teachers3 = teacher.FindTeacherBydept(allMessage);
        List<Teacher> teachers4 = teacher.FindTeacherByname(allMessage);
        List<Teacher> teachers6 = teacher.FindTeacherByTtel(allMessage);
        List<Teacher> teachers7 = teacher.FindTeacherByTemail(allMessage);

        teachers1.addAll(teachers3);
        teachers1.addAll(teachers4);
        teachers1.addAll(teachers6);
        teachers1.addAll(teachers7);

//        去重
        for  ( int i = 0; i < teachers1.size()-1;i++)  {
            for  (int j = i+1;j < teachers1.size();j++)  {
                if  (teachers1.get(j).getTno() == teachers1.get(i).getTno())  {
                    teachers1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < teachers1.size()-1;i++)  {
            for  (int j = i+1;j < teachers1.size();j++)  {
                if  (teachers1.get(j).getTno() == teachers1.get(i).getTno())  {
                    teachers1.remove(j);
                }
            }
        }
        if (teachers1.size() >= 1) System.out.println("查到教师了已经");
//        搜出的列表传回前端
        request.setAttribute("teachers",teachers1 );
        request.getRequestDispatcher("manager_teacher_management.jsp").forward(request, response);
    }

//    管理员增加老师
    private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("Tno");
        String name = request.getParameter("Tname");
        String dept = request.getParameter("Tdept");
        String tel = request.getParameter("Ttel");
        String email = request.getParameter("Temail");
        String pwd = request.getParameter("password");
        Teacher td = new Teacher();
        td.setTno(id);
        td.setTname(name);
        td.setTdept(dept);
        td.setTemail(email);
        td.setPassword(pwd);
        td.setTtel(tel);
        teacher.addTeacher(td);
        showAllTeachers(request, response);
    }

}

