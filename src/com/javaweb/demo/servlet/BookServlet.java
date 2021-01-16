package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.ReserveDaoImpl;
import com.javaweb.demo.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    private BookDao book = new BookDaoimpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("addBook".equals(option)) {
            addBook(request, response);
        } else if ("showAllBooks".equals(option)) {
            showAllBooks(request, response);
        }else if("findBook".equals(option)){
            findBook(request,response);
        } else if("updateBookByManager".equals(option)){
            updateBookByManager(request,response);
        } else if("deleteBookByManager".equals(option)){
            deleteBookByManager(request,response);
        } else if("ShowAllBooks".equals(option)) {
            ShowAllBooks(request, response);
        } else if("FindAllBook".equals(option)){
            FindAllBook(request,response);
        } else if ("FindTeacherBook".equals(option)) {
            FindTeacherBook(request, response);
        } else if ("ShowAllBooksToTeacher".equals(option)) {
            ShowAllBooksToTeacher(request, response);
        }else if("DeleteBookByTeacher".equals(option)){
            DeleteBookByTeacher(request,response);
        }
    }

//    查找书籍
    private void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        传进来一个不知道是哪一列的数据
        String allMessage = request.getParameter("allMessage");
//        教师对象，用来存放教师信息

//        定义一堆及teacher对象列表，用来存放allMessage在每一列的情况所找出的符合条件的teacher
        List<Book> Book1 = book.FindBookByBno(allMessage);//tno
        List<Book> Book3 = book.FindBookByBname(allMessage);
        if (Book3.size() > 0) System.out.println("查到书名了");
        List<Book> Book4 = book.FindBookByBauthor(allMessage);
        List<Book> Book6 = book.FindBookByBsource(allMessage);
        List<Book> Book7 = book.FindBookByBedition(allMessage);
        List<Book> Book8 = book.FindBookByBprice(allMessage);
        List<Book> Book9 = book.FindBookByBnum(allMessage);

        Book1.addAll(Book3);
        Book1.addAll(Book4);
        Book1.addAll(Book6);
        Book1.addAll(Book7);
        Book1.addAll(Book8);
        Book1.addAll(Book9);

//        去重
        for (int i = 0; i < Book1.size() - 1; i++) {
            for (int j = i + 1; j < Book1.size(); j++) {
                if (Book1.get(j).getBno().equals(Book1.get(i).getBno())) {
                    Book1.remove(j);
                }
            }
        }

        for (int i = 0; i < Book1.size() - 1; i++) {
            for (int j = i + 1; j < Book1.size(); j++) {
                if (Book1.get(j).getBno().equals(Book1.get(i).getBno())) {
                    Book1.remove(j);
                }
            }
        }
//        搜出的列表传回前端
        request.setAttribute("books", Book1);
        request.getRequestDispatcher("manager_book_management.jsp").forward(request, response);
    }
//    重写doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

//    增加库存书籍
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("Bno");
        String Bname = request.getParameter("Bname");
        String Bauthor = request.getParameter("Bauthor");
        String Bsource = request.getParameter("Bsource");
        String Bedition = request.getParameter("Bedition");
        String Bprice = request.getParameter("Bprice");
        String Bnum = request.getParameter("Bnum");

        double bprice = Double.valueOf(Bprice);
        Book book1 = new Book();
        book1.setBno(Bno);
        book1.setBname(Bname);
        book1.setBauthor(Bauthor);
        book1.setBsource(Bsource);
        book1.setBedition(Bedition);
        book1.setBprice(bprice);
        book1.setBnum(Bnum);
        book.addBook(book1);
        showAllBooks(request,response);
    }

//    删除库存书籍
    private void deleteBookByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("Bno");
        System.out.println(Bno);
        book.deleteBook(Bno);
        showAllBooks(request, response);
    }

//    展示所有书籍
    private void showAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = book.getBookkall();
        request.setAttribute("books", books);
        //页面
        request.getRequestDispatcher("manager_book_management.jsp?").forward(request, response);
    }

//    管理员更新库存书籍
    private void updateBookByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("bno");
        String Bname =request.getParameter("name");
        String Bauthor =request.getParameter("author");
        String Bsource =request.getParameter("source");
        String Bedition =request.getParameter("edition");
        String Bprice =request.getParameter("price");
        String Bnum =request.getParameter("number");

        System.out.println(Bno+"+"+Bname+"+"+Bauthor+"+"+Bsource+"+"+Bedition+"+"+Bprice+"+"+Bnum);

        Book book1 = new Book();
        book1.setBno(Bno);
        book1.setBnum(Bname);
        book1.setBname(Bauthor);
        book1.setBauthor(Bsource);
        book1.setBsource(Bedition);
        book1.setBedition(Bprice);
        book.updateBook(Bno,Bname,Bauthor,Bsource,Bedition,Bprice,Bnum);
        showAllBooks(request, response);
    }

    //查询库存书信息
    private void FindAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("info");
        List<Book> books1=book.getBookByBno(info);
        List<Book> books2=book.getBookBybname(info);
        List<Book> books3=book.getBookBybauthor(info);
        List<Book> books4=book.getBookBybsource(info);
        books1.addAll(books2);
        books1.addAll(books3);
        books1.addAll(books4);
        for  ( int i = 0; i < books1.size()-1;i++)  {
            for  (int j = i+1;j < books1.size();j++)  {
                if  (books1.get(j).getBno().equals(books1.get(i).getBno()))  {
                    books1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < books1.size()-1;i++)  {
            if (books1.get(books1.size()-1).getBno().equals(books1.get(i).getBno())){
                books1.remove(books1.size()-1);
            }
        }
        request.setAttribute("books",books1);
        request.getRequestDispatcher("teacher_look_kucunbook_info.jsp").forward(request, response);
    }

    //可视化库存书信息
    private void ShowAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Book> books = book.getBookAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/teacher_look_kucunbook_info.jsp").forward(request, response);
    }

    //可视化该老师教材信息
    private void ShowAllBooksToTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        String tno = teacher.getTno();
        List<Book> books = book.getTeacherBookAll(tno);
        request.setAttribute("books", books);
        for(Book b1:books){
            System.out.println(b1.toString());
        }
        request.getRequestDispatcher("/teacher_look_mybook_info.jsp").forward(request, response);
    }

    //查询老师教材信息
    //查询老师教材信息
    private void FindTeacherBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Teacher teacher=(Teacher)session.getAttribute("user");
        String tno=teacher.getTno();
        String info = request.getParameter("info");
        List<Book> books1=book.getTeacherBookBybno(info,tno);
        List<Book> books2=book.getTeacherBookBybname(info,tno);
        List<Book> books3=book.getTeacherBookBybauthor(info,tno);
        List<Book> books4=book.getTeacherBookBybsource(info,tno);
        books1.addAll(books2);
        books1.addAll(books3);
        books1.addAll(books4);
        for  ( int i = 0; i < books1.size()-1;i++)  {
            for  (int j = i+1;j < books1.size();j++)  {
                if  (books1.get(j).getBno().equals(books1.get(i).getBno()))  {
                    books1.remove(j);
                }
            }
        }
        for  ( int i = 0; i < books1.size()-1;i++)  {
            if (books1.get(books1.size()-1).getBno().equals(books1.get(i).getBno())){
                books1.remove(books1.size()-1);
            }
        }
        request.setAttribute("books",books1);
        request.getRequestDispatcher("/teacher_look_mybook_info.jsp").forward(request, response);
    }

    //老师删除教材
    private void DeleteBookByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String Bno=request.getParameter("Bno");
        String CCno=request.getParameter("CCno");
        boolean flag=book.DeleteBookByTeacher(Bno,CCno);
        if(flag){
            request.setAttribute("msg","删除成功！！！");
            request.getRequestDispatcher("/BookServlet?option=ShowAllBooksToTeacher").forward(request,response);
        }
        else {
            request.setAttribute("msg1","教材已发放，删除失败！！！");
            request.getRequestDispatcher("/BookServlet?option=ShowAllBooksToTeacher").forward(request,response);
        }
    }


}
