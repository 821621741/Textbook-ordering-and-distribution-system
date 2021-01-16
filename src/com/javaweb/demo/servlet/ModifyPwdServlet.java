package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.AdminDao;

import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.dao.impl.AdiminDaoImpl;

import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.dao.impl.TeacherDaoImpl;
import com.javaweb.demo.entity.Admin;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Teacher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ModifyPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
    AdminDao ad = new AdiminDaoImpl();
    TeacherDao te = new TeacherDaoImpl();
    MonitorDao mo = new MonitorDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("updateManagerPwd".equals(option)) {
            updateManagerPwd(request, response);
        } else if ("updateTeacherPwd".equals(option)) {
            updateTeacherPwd(request, response);
        }else if ("updateMonitorPwd".equals(option)) {
            updateMonitorPwd(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    private void updateManagerPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        HttpSession session1 = request.getSession();
        Admin admin = (Admin) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpassword");
        String newPwd=request.getParameter("newpassword");
        String rnewPwd=request.getParameter("renewpassword");
        if(!(newPwd.equals(rnewPwd))){
            request.setAttribute("msg1","您两次输入的新密码不一致，请重新输入!!!");
            request.getRequestDispatcher("/manager-modify-pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(admin.getPassword()))){
            request.setAttribute("msg1","您输入的原密码不正确，请重新输入!!!");
            request.getRequestDispatcher("/manager-modify-pwd.jsp").forward(request, response);
            return;
        }
        String id =admin.getMno();
        flag=ad.modifyPwd(id,newPwd);
        if(flag){
            request.setAttribute("msg","修改成功,请重新登录" );
            request.getRequestDispatcher("sign-in.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改密码失败!!" );
            request.getRequestDispatcher("/manager-modify-pwd.jsp").forward(request, response);
        }

    }

    private void updateTeacherPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        HttpSession session1 = request.getSession();
        Teacher teacher = (Teacher) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpassword");
        String newPwd=request.getParameter("newpassword");
        String rnewPwd=request.getParameter("renewpassword");
        if(!(newPwd.equals(rnewPwd))){
            request.setAttribute("msg1","您两次输入的新密码不一致，请重新输入!!!");
            request.getRequestDispatcher("teacher_update_pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(teacher.getPassword()))){
            request.setAttribute("msg1","您输入的原密码不正确，请重新输入!!!");
            request.getRequestDispatcher("teacher_update_pwd.jsp").forward(request, response);
            return;
        }
        String id =teacher.getTno();
        flag=te.modifyPwd(id,newPwd);
        if(flag){
            request.setAttribute("msg","修改成功,请重新登录" );
            request.getRequestDispatcher("sign-in.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改密码失败!!" );
            request.getRequestDispatcher("teacher_update_pwd.jsp").forward(request, response);
        }

    }

    private void updateMonitorPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        Monitor monitor  = (Monitor) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpassword");
        String newPwd=request.getParameter("newpassword");
        String rnewPwd=request.getParameter("renewpassword");
        System.out.println(oldPwd);
        System.out.println(newPwd);
        System.out.println(rnewPwd);
        boolean flag  =false;
        if(!(newPwd.equals(rnewPwd))){
            request.setAttribute("msg1","您两次输入的新密码不一致，请重新输入...");
            request.getRequestDispatcher("/monitor_modify_pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(monitor.getPassword()))){
            request.setAttribute("msg1","您输入的原密码不正确，请重新输入...");
            request.getRequestDispatcher("/monitor_modify_pwd.jsp").forward(request, response);
            return;
        }
        String id =monitor.getCno();
        flag=mo.modifyPwd(id,newPwd);
        if(flag==true){
            request.setAttribute("msg","修改成功,请重新登录!!!" );
            request.getRequestDispatcher("sign-in.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改失败" );
            request.getRequestDispatcher("/monitor_modify_pwd.jsp").forward(request, response);
        }
    }
}
