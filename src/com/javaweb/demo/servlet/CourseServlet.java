package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.CourseDaoImpl;
import com.javaweb.demo.dao.impl.ReserveDaoImpl;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Course;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    private CourseDao course = new CourseDaoImpl();
    private BookDao book = new BookDaoimpl();
    private ReserveDao re = new ReserveDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
       if ("showAllCourses".equals(option)) {
            showAllCourses(request, response);
        }else if("updateCourseByManager".equals(option)){
           updateCourseByManager(request,response);
       }else if("deleteCourseByManager".equals(option)){
           deleteCourseByManager(request,response);
       }else if("addCourse".equals(option)){
           addCourse(request,response);
       }else if("findCourseByManager".equals(option)){
           findCourseByManager(request,response);
       }else if ("showMonitorCourses".equals(option)) {
           showMonitorCourses(request, response);
       }else if("showAllCourse".equals(option)){
           showAllCourse(request,response);
       }else if("ShowAllCoursesByTeacher".equals(option)) {
           ShowAllCoursesByTeacher(request, response);
       } else if("FindCourse".equals(option)){
           FindCourse(request,response);
       }else if("UpdateCourseAndReserve".equals(option)){
           UpdateCourseAndReserve(request,response);
       }
    }

    private void findCourseByManager (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        //        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
//        教师对象，用来存放教师信息

        System.out.println("allMessage:" + allMessage);
//        定义一堆及teacher对象列表，用来存放allMessage在每一列的情况所找出的符合条件的teacher
        List<Course> course1 = course.FindCourseBycno(allMessage);//tno
        List<Course> course3 = course.FindCourseBycname(allMessage);
        List<Course> course4 = course.FindCourseBytno(allMessage);
        List<Course> course6 = course.FindCourseBymno(allMessage);
        List<Course> course7 = course.FindCourseBySetflag(allMessage);
        List<Course> course8 = course.FindCourseByIssueflag(allMessage);

        course1.addAll(course3);
        course1.addAll(course4);
        course1.addAll(course6);
        course1.addAll(course7);
        course1.addAll(course8);

        if(course1.size() > 0) System.out.println("找到课程了");
        else System.out.println("没找到课程啊小王");

//        去重
        for  ( int i = 0; i < course1.size()-1;i++)  {
            for  (int j = i+1;j < course1.size();j++)  {
                if  (course1.get(j).getCno().equals(course1.get(i).getCno()))  {
                    course1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < course1.size()-1;i++)  {
            for  (int j = i+1;j < course1.size();j++)  {
                if  (course1.get(j).getCno().equals(course1.get(i).getCno()))  {
                    course1.remove(j);
                }
            }
        }
        if (course1.size() >= 1) System.out.println("查到订单了已经");
//        搜出的列表传回前端
        request.setAttribute("courses",course1 );
        request.getRequestDispatcher("/manager_course_manage.jsp").forward(request, response);
    }

    //    重写doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

//    管理员增加课程
    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CCno = request.getParameter("ccno");
        String CCname = request.getParameter("cname");
        String CCtno = request.getParameter("cctno");
        String  CCmno = request.getParameter("ccmno");
        System.out.println(CCno+"+"+CCname+"+"+CCtno+"+"+CCmno);
        Course co = new Course();
        co.setCno(CCno);
        co.setCname(CCname);
        co.setMno(CCmno);
        co.setTno(CCtno);
        course.addCourse(co);
        showAllCourses(request, response);
    }

//    管理员展示所有课程
    private void showAllCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = course.getCourseAll();
        if(courses.size() > 0) System.out.println("输出所有课程");
        request.setAttribute("courses", courses);
        //页面
        request.getRequestDispatcher("/manager_course_manage.jsp").forward(request, response);

    }

//    管理员修改课程
    private void updateCourseByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CCno = request.getParameter("ccno");
        String CCname =request.getParameter("ccname");
        String CCtno =request.getParameter("cctno");
        String CCmno =request.getParameter("ccmno");
        String CCset_flag = request.getParameter("ccset_flag");
        String CCissue_flag = request.getParameter("ccissue_flag");
        System.out.println(CCno+"+"+CCname+"+"+CCtno+"+"+CCmno+"+"+CCset_flag+"+"+CCissue_flag);
        course.updateCourse(CCno,CCname,CCtno,CCmno,CCset_flag,CCissue_flag);
        showAllCourses(request, response);
    }

//    删除课程
    private void deleteCourseByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CCno = request.getParameter("CCno");
        course.deleteCourse(CCno);
        showAllCourses(request, response);
    }

    //可视化班长课程信息
    private void showMonitorCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Monitor monitor=(Monitor)session.getAttribute("user");
        List<Course> courses = course.getCourseAllByMonitor(monitor.getCno());
        for(Course c1:courses){
            System.out.println(c1.toString());
        }
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/monitor_course.jsp").forward(request, response);
    }

    //可视化所有课程信息
    private void showAllCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = course.getCourseall();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/monitor_AllCourse.jsp").forward(request, response);
    }

    //可视化教师课程信息
    private void ShowAllCoursesByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Teacher teacher=(Teacher) session.getAttribute("user");
        List<Course> courses = course.getCourseAllByTeacher(teacher.getTno());
        for (Course c1:courses){
            System.out.println(c1.toString());
        }
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/teacher_course_info.jsp").forward(request, response);
    }

    //查询课程信息
    private void FindCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("info");
        HttpSession session=request.getSession();
        Teacher teacher=(Teacher)session.getAttribute("user");
        String tno=teacher.getTno();
        List<Course> courses1= course.getCourseByCCno(info,tno);
        List<Course> courses2= course.getCourseByCCname(info,tno);
        List<Course> courses4= course.getCourseByCCbno(info,tno);
        List<Course> courses5= course.getCourseByCCmno(info,tno);
        List<Course> courses6= course.getCourseByCCset_flag(info,tno);
        List<Course> courses7= course.getCourseByCCissue_flag(info,tno);
        courses1.addAll(courses2);
        courses1.addAll(courses4);
        courses1.addAll(courses5);
        courses1.addAll(courses6);
        courses1.addAll(courses7);
        for  ( int i = 0; i < courses1.size()-1;i++)  {
            for  (int j = i+1;j < courses1.size();j++)  {
                if  (courses1.get(j).getCno().equals(courses1.get(i).getCno()))  {
                    courses1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < courses1.size()-1;i++)  {
            for  (int j = i+1;j < courses1.size();j++)  {
                if  (courses1.get(j).getCno().equals(courses1.get(i).getCno()))  {
                    courses1.remove(j);
                }
            }
        }
        request.setAttribute("courses",courses1);
        request.getRequestDispatcher("/teacher_course_info.jsp").forward(request, response);
    }

    //更改教材以及订单信息
    private void UpdateCourseAndReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Date date=new Date();
        String Ccno = request.getParameter("Ccno");
        String Bno = request.getParameter("Bno");
        String mno =request.getParameter("CCmno");
        String R_year = request.getParameter("R_year");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String date1 = sdf.format(date);
        boolean flag1= course.UpdateCourse(Ccno,Bno);
        if(flag1==false){
            request.setAttribute("msg1","库存中没有该书号所对应的教材信息，更改教材失败！！");
            request.getRequestDispatcher("/CourseServlet?option=ShowAllCoursesByTeacher").forward(request,response);
        }
        else {
            boolean flag2 = re.UpdateReserve(Ccno, mno, date1, Bno);
            if (flag2) {
                request.setAttribute("msg", "更新教材及订单信息成功！！");
                request.getRequestDispatcher("/CourseServlet?option=ShowAllCoursesByTeacher").forward(request, response);
            }
        }
    }

}
