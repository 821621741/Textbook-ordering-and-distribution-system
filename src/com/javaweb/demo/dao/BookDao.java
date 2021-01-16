package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Book;


import java.util.List;

public interface BookDao {
    public boolean addBook(Book book);//增加教材
    public boolean deleteBook(String bno) ;//根据书号删除教材
    public boolean updateBook(String bno, String bname, String bauthor, String bsource, String bedition, String bprice, String bnum) ;//更新教材信息
    public List<Book> getBookkall();//查询全部教材的信息
    public Book getBookBybno(String bno);//通过课程号查询
    public Book getBookBybnoByTeacher(String bno);
    double getPrice (String bno);
    //管理员根据各种信息查询老师
    List<Book> FindBookByBno (String Bno);
    List<Book> FindBookByBname (String Bname);
    List<Book> FindBookByBauthor (String Bauthor);
    List<Book> FindBookByBsource (String Bsource);
    List<Book> FindBookByBedition (String Bedition);
    List<Book> FindBookByBprice (String Bprice);
    List<Book> FindBookByBnum (String Bnum);
    public boolean updateBnum (String Bno,String Bnum);//管理员处理订单后更新库存数目
    public int book_total_num ();//管理员计算书的库存总数目
    public boolean DeleteBookByTeacher(String bno,String CCno) ;//教师删除教材
    public List<Book> getTeacherBookAll(String tno);//教师可视化自己的教材信息
    public List<Book> getBookByBno(String bno);//通过书号找库存书信息
    public List<Book> getBookBybname(String bname); //通过书名找库存书信息
    public List<Book> getBookBybauthor(String bauthor); //通过作者找库存书信息
    public List<Book> getBookBybsource(String bsource);//通过出版社找库存书信息
    public List<Book> getBookAll(); //得到所有的库存教材信息
    public List<Book> getTeacherBookBybno(String bno,String tno);//通过书号找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybname(String bno,String tno);//通过书名找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybauthor(String bno,String tno);//通过作者找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybsource(String bno,String tno);//通过出版社找与该老师相关的教材书信息
}
