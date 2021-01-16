package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.CourseDaoImpl;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.dao.impl.ReserveDaoImpl;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Reserve;
import com.javaweb.demo.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

    ReserveDaoImpl re = new ReserveDaoImpl();
    BookDao bo =  new BookDaoimpl();
    MonitorDao mo= new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if ("findReserve".equals(option)) {
            findReserve(request, response);
        } else if ("showReserveManagernotissue".equals(option)) {
            showReserveManagernotissue(request, response);
        } else if ("show".equals(option)){
            show(request, response);
        }else if("dealwithReserve".equals(option)){
            dealwithReserve(request, response);
        }else if("deleteReserveByManager".equals(option)){
            deleteReserveByManager(request, response);
        }else if("showReserveManagerissued".equals(option)){
            showReserveManagerissued(request, response);
        }else if("findReserveIssued".equals(option)){
            findReserveIssued(request, response);
        }else if ("ShowReserveMonitor".equals(option)) {
            ShowReserveMonitor(request, response);
        }else if("UpdateReserveByMonitor".equals(option)){
            UpdateReserveByMonitor(request,response);
        } else if ("AddReserve".equals(option)) {
            AddReserve(request, response);
        } else if("ShowAllReserveByTeacher".equals(option)){
            ShowAllReserveByTeacher(request,response);
        } else if("ShowAllNoReserveByTeacher".equals(option)){
            ShowAllNoReserveByTeacher(request,response);
        } else if("ShowAllYesReserveByTeacher".equals(option)){
            ShowAllYesReserveByTeacher(request,response);
        }else if("FindreserveByTeacher".equals(option)){
            FindreserveByTeacher(request,response);
        }else if ("DeleteReserve".equals(option)) {
            DeleteReserve(request, response);
        }else if("UpdateYesReserve".equals(option)){
            UpdateYesReserve(request,response);
        }else if("UpdateNoReserve".equals(option)){
            UpdateNoReserve(request,response);
        }else if("FindreserveByMonitor".equals(option)){
            FindreserveByMonitor(request,response);
        }
    }




    //    查找订单
    private void findReserve (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
        List<Reserve> reserve1 = re.FindReserveByRno(allMessage);
        List<Reserve> reserve3 = re.FindReserveByCCno(allMessage);
        List<Reserve> reserve4 = re.FindReserveByBno(allMessage);
        List<Reserve> reserve6 = re.FindReserveByRnum(allMessage);
        List<Reserve> reserve7 = re.FindReserveByPlace(allMessage);
        List<Reserve> reserve8 = re.FindReserveByR_year(allMessage);
        reserve1.addAll(reserve3);
        reserve1.addAll(reserve4);
        reserve1.addAll(reserve6);
        reserve1.addAll(reserve7);
        reserve1.addAll(reserve8);
//        去重
        for  ( int i = 0; i < reserve1.size()-1;i++)  {
            for  (int j = i+1;j < reserve1.size();j++)  {
                if  (reserve1.get(j).getId().equals(reserve1.get(i).getId()))  {
                    reserve1.remove(j);
                }
            }
        }
        if (reserve1.size() >= 1) System.out.println("查到订单了已经");
//        搜出的列表传回前端
        request.setAttribute("Reserves",reserve1 );
        request.getRequestDispatcher("manager_dealwith_reserve.jsp").forward(request, response);
    }
    //    查找订单
    private void findReserveIssued (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
//        教师对象，用来存放教师信息

//        定义一堆及teacher对象列表，用来存放allMessage在每一列的情况所找出的符合条件的teacher
        List<Reserve> reserve1 = re.FindReserveByRno(allMessage,1);//tno
        List<Reserve> reserve3 = re.FindReserveByCCno(allMessage,1);
        List<Reserve> reserve4 = re.FindReserveByBno(allMessage,1);
        List<Reserve> reserve6 = re.FindReserveByRnum(allMessage,1);
        List<Reserve> reserve7 = re.FindReserveByPlace(allMessage,1);
        List<Reserve> reserve8 = re.FindReserveByR_year(allMessage,1);

        reserve1.addAll(reserve3);
        reserve1.addAll(reserve4);
        reserve1.addAll(reserve6);
        reserve1.addAll(reserve7);
        reserve1.addAll(reserve8);

//        去重
        for  ( int i = 0; i < reserve1.size()-1;i++)  {
            for  (int j = i+1;j < reserve1.size();j++)  {
                if  (reserve1.get(j).getId().equals(reserve1.get(i).getId()))  {
                    reserve1.remove(j);
                }
            }
        }

        if (reserve1.size() >= 1) System.out.println("查到订单了已经");
//        搜出的列表传回前端
        request.setAttribute("Reserves",reserve1 );
        request.getRequestDispatcher("manager_compeleted_reserve.jsp").forward(request, response);
    }




//    重写doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

//    展示订单动态数据
    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int reserve_num = re.preserve_num();
        if(reserve_num == 0) System.out.println("订单数查询异常");

        int reserve_book_num = re.reserve_book_num();

        double total_price = re.total_price();
        String t_p = String.format("%.2f", total_price);

        double complete_degree = re.complete_degree();
        System.out.println("完成度：" + complete_degree);
        double a = complete_degree*100;
        String c_d = String.format("%.2f", a);

        int book_total_num = bo.book_total_num();
        session.setAttribute("reserve_num", reserve_num);
        session.setAttribute("reserve_book_num", reserve_book_num);
        session.setAttribute("total_price", t_p);
        session.setAttribute("complete_degree", c_d);
        session.setAttribute("book_total_num",book_total_num);
        int any_year_num[] = re.Find_Reserve_All_year();//tno
        session.setAttribute("year0", any_year_num[0]);
        session.setAttribute("year1", any_year_num[1]);
        session.setAttribute("year2", any_year_num[2]);
        session.setAttribute("year3", any_year_num[3]);
        session.setAttribute("year4", any_year_num[4]);
        session.setAttribute("year5", any_year_num[5]);
        session.setAttribute("year6", any_year_num[6]);
        session.setAttribute("year7", any_year_num[7]);
        session.setAttribute("year8", any_year_num[8]);
        session.setAttribute("year9", any_year_num[9]);
        System.out.println(any_year_num[0]);
        System.out.println(any_year_num[1]);
        System.out.println(any_year_num[2]);
        System.out.println(any_year_num[3]);
        System.out.println(any_year_num[4]);
        System.out.println(any_year_num[5]);
        System.out.println(any_year_num[6]);
        System.out.println(any_year_num[7]);
        System.out.println(any_year_num[8]);
        System.out.println(any_year_num[9]);
        int all_price_num[] = re.all_prices_num();
        session.setAttribute("price30", all_price_num[0]);
        session.setAttribute("price3060", all_price_num[1]);
        session.setAttribute("price60", all_price_num[2]);
        request.getRequestDispatcher("manager_book_data.jsp").forward(request, response);
    }

//    处理订单
    private void dealwithReserve (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        扣除书的数量
        BookDao book = new BookDaoimpl();
        CourseDao course = new CourseDaoImpl();
        String Bno = request.getParameter("Bno");
        int Bnum = Integer.parseInt(request.getParameter("Bnum"));
        int Rnum = Integer.parseInt(request.getParameter("Rnum"));;
        String newBnum = Integer.toString(Bnum - Rnum);
        ReserveDao re  = new ReserveDaoImpl();
        book.updateBnum(Bno,newBnum);

//        修改reserve的issue_flag为'是'
        String Rno = request.getParameter("Rno");
        String CCno = request.getParameter("CCno");
        re.updateIssue_flag(Rno);

//        将书籍信息bno插入course表
        course.addCourseBno(CCno,Bno);

//        刷新展示未完成订单
        showReserveManagernotissue(request, response);
    }

//    删除订单并处理数据
    private void deleteReserveByManager (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Rno = request.getParameter("Rno");
        String CCno = request.getParameter("CCno");
        System.out.println("CCno:"+CCno);

//        修改course表的set_flag为'未设置'
        CourseDao co = new CourseDaoImpl();
        co.updateSet_flagNo(CCno);


//        删除订单
        re.deleteReserve(Rno);
////        刷新展示未处理订单
        showReserveManagernotissue(request, response);
    }

//    展示没发放的订单
    private void showReserveManagernotissue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserve> Reserves = re.findAllReserve_not_issue();
        request.setAttribute("Reserves", Reserves);
        request.getRequestDispatcher("manager_dealwith_reserve.jsp").forward(request, response);
    }


    private void showReserveManagerissued (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserve> Reserves = re.findAllReserve_issued();
        request.setAttribute("Reserves", Reserves);
        request.getRequestDispatcher("manager_compeleted_reserve.jsp").forward(request, response);
    }


    //可视化班长所在班级订单信息
    private void ShowReserveMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Monitor monitor = (Monitor) session.getAttribute("user");
        ReserveDao re  = new ReserveDaoImpl();
        String cno = monitor.getCno();
        List<Reserve> reserves =  new ArrayList<Reserve>();
        reserves = re.findReserveByCno(cno) ;
        for(Reserve re1:reserves){
            System.out.println(re1.toString());
        }
        request.setAttribute("Reserves", reserves);
        request.getRequestDispatcher("/monitor_order.jsp").forward(request, response);
    }

    //班长修改订单人数
    private void UpdateReserveByMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String Rno=request.getParameter("Rno");
        String Rnum=request.getParameter("Rnum");
        boolean flag= re.UpdateReserveByMonitorById(Rno, Integer.parseInt(Rnum));
        if(flag) {
            request.setAttribute("msg","修改订单信息成功！");
            request.getRequestDispatcher("ReserveServlet?option=ShowReserveMonitor").forward(request, response);
        }
        else{
            request.setAttribute("msg1","修改订单信息失败！");
            request.getRequestDispatcher("ReserveServlet?option=ShowReserveMonitor").forward(request, response);
        }
    }

    //添加新的教材订单
    private void AddReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag1;
        Date date=new Date();
        String Ccno = request.getParameter("Ccno");
        String Bno = request.getParameter("Bno");
        String mno =request.getParameter("CCmno");
        String R_year = request.getParameter("R_year");
        Reserve Reserve = new Reserve();
        Reserve.setRno(Integer.toString(re.findMaxId() + 1));
        Reserve.setBno(Bno);
        Reserve.setCcno(Ccno);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String dateStringParse = sdf.format(date);
        Reserve.setR_year(dateStringParse);
        Reserve.setRissue_flag("否");
        Reserve.setCno(mno);
        flag1=re.AddReserve(Reserve);
        if(flag1){
            request.setAttribute("msg","添加订单信息成功！！！");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllReserveByTeacher").forward(request,response);
        }
        else{
            request.setAttribute("msg1","添加订单信息失败！！");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllReserveByTeacher").forward(request,response);
        }
    }

    //可视化与该教师相关的所有订单信息
    private void ShowAllReserveByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<Reserve> reserves =new ArrayList<>();
        reserves=re.FindTeacherReserve(teacher.getTno());
        request.setAttribute("Reserves",reserves);
        request.getRequestDispatcher("/teacher_AllReserve.jsp").forward(request,response);
    }

    //可视化与该教师相关的所有未处理订单信息
    private void ShowAllNoReserveByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<Reserve> reserves =new ArrayList<>();
        reserves=re.FindTeacherReserve(teacher.getTno(),"否");
        request.setAttribute("Reserves",reserves);
        request.getRequestDispatcher("/teacher_NoReserve.jsp").forward(request,response);
    }

    //可视化与该教师相关的所有已处理订单信息
    private void ShowAllYesReserveByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<Reserve> reserves =new ArrayList<>();
        reserves=re.FindTeacherReserve(teacher.getTno(),"是");
        request.setAttribute("Reserves",reserves);
        request.getRequestDispatcher("/teacher_YesReserve.jsp").forward(request,response);
    }

    //教师查询订单信息
    private void FindreserveByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = new ArrayList();
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        String tno = teacher.getTno();
        String info = request.getParameter("info");
        List<Reserve> reserves1 = re.findReserveByRnoByTeacher(info, tno);
        List<Reserve> reserves2 = re.findReserveByCCnoByTeacher(info, tno);
        List<Reserve> reserves3 = re.findReserveByBnoByTeacher(info, tno);
        List<Reserve> reserves4 = re.findReserveByR_yearByTeacher(info, tno);
        List<Reserve> reserves5 = re.findReserveByRissue_flagByTeacher(info, tno);
        List<Reserve> reserves6 = re.findReserveByPlaceByTeacher(info, tno);
        List<Reserve> reserves7 = re.findReserveByBnameByTeacher(info, tno);
        reserves1.addAll(reserves2);
        reserves1.addAll(reserves3);
        reserves1.addAll(reserves4);
        reserves1.addAll(reserves5);
        reserves1.addAll(reserves6);
        reserves1.addAll(reserves7);
        for (int i = 0; i < reserves1.size() - 1; i++) {
            for (int j = i + 1; j < reserves1.size(); j++) {
                if (reserves1.get(j).getRno().equals(reserves1.get(i).getRno())) {
                    reserves1.remove(j);
                }
            }
        }
        for (int i = 0; i < reserves1.size() - 1; i++) {
            for (int j = i + 1; j < reserves1.size(); j++) {
                if (reserves1.get(j).getRno().equals(reserves1.get(i).getRno())) {
                    reserves1.remove(j);
                }
            }
        }
        request.setAttribute("Reserves", reserves1);
        request.getRequestDispatcher("teacher_AllReserve.jsp").forward(request, response);
    }

    //班长查询订单信息
    private void FindreserveByMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        Monitor monitor=(Monitor) session.getAttribute("user");
        String cno=monitor.getCno();
        String info = request.getParameter("info");
        List<Reserve> reserves1=re.findReserveByRnoByMonitor(info,cno);
        List<Reserve> reserves2=re.findReserveByCCnoByMonitor(info,cno);
        List<Reserve> reserves3=re.findReserveByBnoByMonitor(info,cno);
        List<Reserve> reserves4=re.findReserveByR_yearByMonitor(info,cno);
        List<Reserve> reserves5=re.findReserveByRissue_flagByMonitor(info,cno);
        List<Reserve> reserves6=re.findReserveByPlaceByMonitor(info,cno);
        List<Reserve> reserves7=re.findReserveByBnameByMonitor(info,cno);
        reserves1.addAll(reserves2);
        reserves1.addAll(reserves3);
        reserves1.addAll(reserves4);
        reserves1.addAll(reserves5);
        reserves1.addAll(reserves6);
        reserves1.addAll(reserves7);
        for  ( int i = 0; i < reserves1.size()-1;i++)  {
            for  (int j = i+1;j < reserves1.size();j++)  {
                if  (reserves1.get(j).getRno().equals(reserves1.get(i).getRno()))  {
                    reserves1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < reserves1.size()-1;i++)  {
            for  (int j = i+1;j < reserves1.size();j++)  {
                if  (reserves1.get(j).getRno().equals(reserves1.get(i).getRno()))  {
                    reserves1.remove(j);
                }
            }
        }
        request.setAttribute("Reserves",reserves1);
        request.getRequestDispatcher("/monitor_order.jsp").forward(request, response);
    }

    //删除订单信息
    private void DeleteReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Rno = request.getParameter("Rno");
        String CCno=request.getParameter("CCno");
        Boolean flag = re.DeleteReserve(Rno,CCno);
        if(flag){
            request.setAttribute("msg","删除成功！" );
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllReserveByTeacher").forward(request,response);
        }
        else {
            request.setAttribute("msg1","删除失败！" );
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllReserveByTeacher").forward(request,response);
        }
    }

    //修改已处理订单信息（领书地点及领书时间）
    private void UpdateYesReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CCno = request.getParameter("CCno");
        String Rno = request.getParameter("Rno");
        String Bno = request.getParameter("Bno");
        String Place = request.getParameter("Place");
        String Time =request.getParameter("Time");
        boolean flag = re.UpdateReserve(Rno, Bno, Place, CCno,Time);
        if (flag) {
            request.setAttribute("msg","订单信息修改成功!!");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllYesReserveByTeacher").forward(request, response);
        }
        else {
            request.setAttribute("msg1","订单信息修改失败!!");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllYesReserveByTeacher").forward(request, response);
        }
    }

    //修改未处理订单信息（书号）
    private void UpdateNoReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CCno = request.getParameter("CCno");
        String Rno = request.getParameter("Rno");
        String Bno = request.getParameter("Bno");
        boolean flag = re.UpdateReserve(Rno, Bno, CCno);
        if (flag) {
            request.setAttribute("msg","订单信息修改成功!!");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllNoReserveByTeacher").forward(request, response);
        }
        else {
            request.setAttribute("msg1","订单信息修改失败!!");
            request.getRequestDispatcher("/ReserveServlet?option=ShowAllNoReserveByTeacher").forward(request, response);
        }
    }

}
