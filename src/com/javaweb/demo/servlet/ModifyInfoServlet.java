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

@WebServlet("/ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet {
    AdminDao ad = new AdiminDaoImpl();
    TeacherDao te = new TeacherDaoImpl();
    MonitorDao mo = new MonitorDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("updateManagerInfo".equals(option)) {
            updateManagerInfo(request, response);
        } else if ("updateTeacherInfo".equals(option)) {
            updateTeacherInfo(request, response);
        }else if ("updateMonitorInfo".equals(option)) {
            updateMonitorInfo(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void updateManagerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Mno = request.getParameter("mno");
        String Mname = request.getParameter("mname");
        String Mtel = request.getParameter("mtel");
        String Memail = request.getParameter("memail");
        boolean flag=ad.updateInfo(Mno, Mname, Mtel,Memail);
        HttpSession session=request.getSession();
        Admin admin=ad.FindAdmin(Mno);
        session.removeAttribute("user");
        session.setAttribute("user",admin);
        if(flag){
            request.setAttribute("msg","修改成功" );
            request.getRequestDispatcher("/manager_modify_info.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改失败" );
            response.sendRedirect(getServletContext().getContextPath()+"/manager_modify_info.jsp");
        }
    }

    private void updateTeacherInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Teacher teacher=(Teacher)session.getAttribute("user");
        String Tno = teacher.getTno();
        String name = request.getParameter("tname");
        String tel = request.getParameter("ttel");
        String email = request.getParameter("temail");
        System.out.println(name+" "+tel+" "+email);
        boolean flag=te.updateTeacher(Tno,name,tel,email);
        Teacher teacher1 = te.FindTeacher(Tno);
        session.removeAttribute("user");
        session.setAttribute("user",teacher1);
        if(flag){
            request.setAttribute("msg","修改成功！" );
            request.getRequestDispatcher("teacher_modify_info.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改失败！");
            request.getRequestDispatcher("teacher_update_info.jsp").forward(request, response);
        }
    }

    private void updateMonitorInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        HttpSession session =request.getSession();
        Monitor monitor1=(Monitor)session.getAttribute("user");
//        String Cno = request.getParameter("cno");
        String cnum = request.getParameter("cnum");
        flag=mo.update(monitor1.getCno(),cnum);
        Monitor monitor = mo.findMonitorByCno1(monitor1.getCno());
        session.removeAttribute("user");
        session.setAttribute("user",monitor);
        if(flag){
            request.setAttribute("msg","修改成功!" );
            request.getRequestDispatcher("/monitor_personnal.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg1","修改失败" );
            request.getRequestDispatcher("/monitor_modify_info.jsp").forward(request, response);
        }
    }

}
