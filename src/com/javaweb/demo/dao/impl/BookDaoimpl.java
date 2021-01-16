package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.entity.Book;

import com.javaweb.demo.entity.Course;
import com.javaweb.demo.entity.Reserve;
import com.javaweb.demo.util.DBconn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoimpl implements BookDao {


    //管理员增加库存教材
    @Override
    public boolean addBook(Book book) {
        boolean flag = false;
        DBconn.init();
        System.out.println(book.getBauthor());

        int i = DBconn.addUpdDel("insert into book(Bno, Bname, Bauthor, Bsource,Bedition, Bprice, Bnum) " +
                "values('"+book.getBno()+"','"+book.getBname()+"','"+book.getBauthor()+"','"+book.getBsource()+"','"+book.getBedition()+"','"+book.getBprice()+"','"+book.getBnum() + "')");
        if(i > 0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }


    //管理员删除库存教材
    @Override
    public boolean deleteBook(String bno) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from book where Bno = " + bno;
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }


    @Override
    public boolean updateBook(String bno, String bname, String bauthor, String bsource, String bedition, String bprice, String bnum) {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set Bname ='" + bname
                +"' , Bauthor ='" + bauthor
                +"' , Bsource ='" + bsource
                +"' , Bedition ='" + bedition
                +"' , Bprice=" + bprice
                +" , Bnum ='" + bnum
                +"' where Bno = '" + bno + "'";
        int i = DBconn.addUpdDel(sql);
        if(i > 0){
            System.out.println("更新书籍成功！");
            flag = true;
        }else {
            System.out.println("更新书籍失败！");
        }
        DBconn.closeConn();
        return flag;
    }

    //展示库存所有书
    @Override
    public List<Book> getBookkall() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookBybno(String bno) {
        Book book = new Book();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno='"+bno+"'");
            while(rs.next()){
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
            }
            DBconn.closeConn();
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getPrice(String bno) {
        double price = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno=" + bno);
            while (rs.next()) {
                price = Double.parseDouble(rs.getString("Bprice"));
            }
            DBconn.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public int book_total_num(){
        int num = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book");
            while(rs.next()){
                num += rs.getInt("Bnum");
            }
            DBconn.closeConn();
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //    根据教师号查询书
    @Override
    public List<Book> FindBookByBno (String Bno){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bno like '%"+Bno+"%'");
            while(rs.next()){
                System.out.println("成功根据书号:" + Bno + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    根据教师名查询书
    @Override
    public List<Book> FindBookByBname (String Bname){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bname like '%" + Bname + "%'");
            while(rs.next()){
                System.out.println("成功根据书名:" + Bname + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    根据作者查询老师
    @Override
    public List<Book> FindBookByBauthor (String Bauthor){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bauthor like '%"+Bauthor+"%'");
            while(rs.next()){
                System.out.println("成功根据作者:" + Bauthor + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    根据出版社查询书
    @Override
    public List<Book> FindBookByBsource (String Bsource){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bsource like '%"+Bsource+"%'");
            while(rs.next()){
                System.out.println("成功根据出版社:" + Bsource + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    根据版次查询书
    @Override
    public List<Book> FindBookByBedition (String Bedition){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bedition like '%"+Bedition+"%'");
            while(rs.next()){
                System.out.println("成功根据版次:" + Bedition + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> FindBookByBprice (String Bprice){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bprice like '%"+Bprice+"%'");
            while(rs.next()){
                System.out.println("成功根据价格:" + Bprice + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> FindBookByBnum(String Bnum){
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Book where Bnum like '%"+Bnum+"%'");
            while(rs.next()){
                System.out.println("成功根据数量:" + Bnum + " 查找出符合条件的信息");
                Book book =  new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //处理订单后，更新库存书的数量
    @Override
    public boolean updateBnum (String Bno, String Bnum) {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set Bnum ='" + Bnum
                +"' where Bno = " + Bno;
        int i = DBconn.addUpdDel(sql);
        if(i > 0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    //教师删除教材
    public boolean DeleteBookByTeacher(String bno,String CCno) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("update course set CCbno=null where CCissue_flag='否' and CCno="+CCno);
        if(i>0){
            flag = true;
            int k =DBconn.addUpdDel("update course set CCset_flag='未设置' where CCno="+CCno);
            int p =DBconn.addUpdDel("delete from reserve where Bno= '"+bno+"'and CCno= "+CCno);
        }
        DBconn.closeConn();
        return flag;
    }

    //教师可视化自己的教材信息
    public List<Book> getTeacherBookAll(String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book,Teacher,Course,reserve where teacher.Tno=Course.CCtno  and course.CCno=reserve.CCno  and reserve.Cno=course.CCmno and course.CCbno=reserve.Bno and course.CCbno=book.Bno and teacher.Tno =" + tno);
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                ReserveDao reserve=new ReserveDaoImpl();
                Reserve reserve1=new Reserve();
                reserve1.setId(rs.getString("Rno"));
                String Rno=reserve1.getId();
                reserve1=reserve.findReserveByrno(Rno,tno);
                CourseDao course1=new CourseDaoImpl();
                Course course=new Course();
                course =course1.FindCourse(reserve1.getCno());
                book.setCourse(course);
                book.setReserve(reserve1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //得到所以的库存教材信息
    public List<Book> getBookAll() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书名找一本书
    public Book getBookBybnoByTeacher(String bno) {
        Book book = new Book();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno="+bno);
            while(rs.next()){
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
            }
            DBconn.closeConn();
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书号找库存书信息
    public List<Book> getBookByBno(String bno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno like '%"+bno +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书名找库存书信息
    public List<Book> getBookBybname(String bname) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bname like '%"+bname +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过作者找库存书信息
    public List<Book> getBookBybauthor(String bauthor) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bauthor like '%"+bauthor +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过出版社找库存书信息
    public List<Book> getBookBybsource(String bsource) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bsource like '%"+ bsource +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书号找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybno(String bno, String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book,teacher,course where teacher.Tno=course.CCtno and course.CCbno=book.Bno and teacher.Tno='"+tno+"' and book.Bno like '%"+bno +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书名找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybname(String bname, String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book,teacher,course where teacher.Tno=course.CCtno and course.CCbno=book.Bno and teacher.Tno='"+tno+"' and book.Bname like '%"+bname +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过作者找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybauthor(String bauthor, String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book,teacher,course where teacher.Tno=course.CCtno and course.CCbno=book.Bno and teacher.Tno='"+tno+"' and book.Bauthor like '%"+bauthor +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过出版社找与该老师相关的教材书信息
    public List<Book> getTeacherBookBybsource(String bsource, String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book,teacher,course where teacher.Tno=course.CCtno and course.CCbno=book.Bno and teacher.Tno='"+tno+"' and book.Bsource like '%"+ bsource +"%'");
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getDouble("Bprice"));
                String CCbno=rs.getString("Bno");
                CourseDao course = new CourseDaoImpl();
                Course course1 = course.getCourseByBno(CCbno);
                book.setCourse(course1);
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
