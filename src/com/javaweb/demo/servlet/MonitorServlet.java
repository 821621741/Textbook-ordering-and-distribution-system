package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.entity.Monitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MonitorServlet")
public class MonitorServlet extends HttpServlet{

    private MonitorDao monitor = new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("addMonitor".equals(option)) {
            addMonitor(request, response);
        } else if ("showAllMonitor".equals(option)) {
            showAllMonitor(request, response);
        } else if ("deleteMonitor".equals(option)) {
            deleteMonitor(request, response);
        } else if ("updateMonitor".equals(option)) {
            updateMonitor(request, response);
        } else if("FindMonitorByAllMessage".equals(option)) {
            FindMonitorByAllMessage(request, response);
        }
    }

//    管理员查找班长
    private void FindMonitorByAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
//        班长对象，用来存放教师信息

//        定义一堆及monitor对象列表，用来存放allMessage在每一列的情况所找出的符合条件的monitor
        List<Monitor> Monitor1 = monitor.FindMonitorByCno(allMessage);//tno
        List<Monitor> Monitor2 = monitor.FindMonitorByCgrade(allMessage);//DC
        List<Monitor> Monitor3 = monitor.FindMonitorByCdept(allMessage);
        List<Monitor> Monitor4 = monitor.FindMonitorByCmajor(allMessage);
        List<Monitor> Monitor5 = monitor.FindMonitorBynum(allMessage);

        Monitor1.addAll(Monitor2);
        Monitor1.addAll(Monitor3);
        Monitor1.addAll(Monitor4);
        Monitor1.addAll(Monitor5);
        for(Monitor m1:Monitor1){
            System.out.println(m1.toString());
        }
//        去重
        for  ( int i = 0; i < Monitor1.size()-1;i++)  {
            for  (int j = i+1;j < Monitor1.size();j++)  {
                if  (Monitor1.get(j).getCno() == Monitor1.get(i).getCno())  {
                    Monitor1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < Monitor1.size()-1;i++)  {
            for  (int j = i+1;j < Monitor1.size();j++)  {
                if  (Monitor1.get(j).getCno() == Monitor1.get(i).getCno())  {
                    Monitor1.remove(j);
                }
            }
        }
//        搜出的列表传回前端
        request.setAttribute("monitors",Monitor1 );
        request.getRequestDispatcher("manager_monitor_management.jsp").forward(request, response);








//
//
//
//
//        String Cno = request.getParameter("Cno");
//        System.out.println(Cno);
//        String Cdept = request.getParameter("Cdept");
//        System.out.println(Cdept);
//        String Cgrade = request.getParameter("Cgrade");
//        System.out.println(Cgrade);
//        String Cmajor = request.getParameter("Cmajor");
//        System.out.println(Cmajor);
//        // String Cnum = request.getParameter("Cnum");
//
//        //System.out.println(Cnum);
//        Monitor monitor1 = new Monitor();
//        monitor1.setCno(Cno);
//        monitor1.setCdept(Cdept);
//        monitor1.setCgrade(Cgrade);
//        monitor1.setCmajor(Cmajor);
//        //monitor1.setCnum(Integer.parseInt(Cnum));
//
//        List<Monitor> monitors = monitor.topQuery(monitor1);
//
//        request.setAttribute("monitors", monitors);
//        //页面
//        request.getRequestDispatcher("/manager_monitor_find.jsp").forward(request, response);
//

    }

//    重写doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
        System.out.println( request.getParameter("cls.cno"));
    }

//    增加班级
    private void addMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("Cno");
        String Cgrade = request.getParameter("Cgrade");
        String Cdept = request.getParameter("Cdept");
        String Cmajor = request.getParameter("Cmajor");
        String  Cnum = request.getParameter("Cnum");
        String password = request.getParameter("password");
        Monitor monitor1 = new Monitor();
        monitor1.setCno(Cno);
        monitor1.setCgrade(Cgrade);
        monitor1.setCdept(Cdept);
        monitor1.setCmajor(Cmajor);
        monitor1.setCnum(Cnum);
        monitor1.setPassword(password);
        monitor.addMonitor(monitor1);
        showAllMonitor(request, response);
    }

//    删除班级
    private void deleteMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("id");
        System.out.println(Cno);
        monitor.delete(Cno);
        showAllMonitor(request, response);
    }

//    管理员展示所有班级信息
    private void showAllMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Monitor> monitors = monitor.getMonitorAll();

        request.setAttribute("monitors", monitors);
        //页面
        request.getRequestDispatcher("/manager_monitor_management.jsp").forward(request, response);
    }

//    更新班级信息
    private void updateMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("Cno");
        String Cgrade = request.getParameter("Cgrade");
        String Cdept = request.getParameter("Cdept");
        String Cmajor = request.getParameter("Cmajor");
        String Cnum = request.getParameter("Cnum");
        String password = request.getParameter("password");
        System.out.println(Cno);
        System.out.println(Cgrade);
        System.out.println(Cdept);
        System.out.println(Cmajor);
        System.out.println(Cnum);
        Monitor monitor1 = new Monitor();
        monitor1.setCno(Cno);
        monitor1.setCgrade(Cgrade);
        monitor1.setCdept(Cdept);
        monitor1.setCmajor(Cmajor);
        monitor1.setCnum(Cnum);
        monitor1.setPassword(password);
         monitor.update(monitor1);
        showAllMonitor(request, response);
    }

}
