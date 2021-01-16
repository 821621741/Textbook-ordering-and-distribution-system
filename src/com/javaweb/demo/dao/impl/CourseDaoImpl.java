package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Course;
import com.javaweb.demo.entity.Teacher;
import com.javaweb.demo.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private Course co;

    @Override
    public List<Course> getCourseAll() {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course ");
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
               // ResultSet rs1 = DBconn.selectSql("select * from teacher where Tno='" + rs.getString("CCtno") +"'");
                //course.setTeacher(new Teacher(rs.getString("CCtno"),rs1.getString("Tname"),"","","",""));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    删除课程
    @Override
    public boolean deleteCourse(String CCno) {
        System.out.print("删除课程：");
        boolean flag = false;
        DBconn.init();
        String sql = "delete from Course where CCno='" + CCno + "'";
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            System.out.println("成功！");
            flag = true;
        }else{
            System.out.println("失败！");
        }
        DBconn.closeConn();
        return flag;
    }


//    管理员增加课程
    @Override
    public boolean addCourse(Course co) {
        System.out.print("增加课程：");
        boolean flag = false;
        DBconn.init();
        System.out.println(co.getCno()+"+"+co.getCname()+"+"+co.getTno()+"+"+co.getMno()+"+"+co.getSet_flag()+"+"+co.getIssue_flag());
        int i = DBconn.addUpdDel("insert into course(CCno,CCname,CCtno,CCmno,CCset_flag,CCissue_flag) " +
                "values('" + co.getCno()+ "','" + co.getCname() + "','" +co.getTno() + "','" + co.getMno() + "','" + co.getSet_flag()+ "','" + co.getIssue_flag() +"')");
        if (i > 0) {
            System.out.println("成功！");
            flag = true;
        }else{
            System.out.println("失败！");
        }
        DBconn.closeConn();
        return flag;
    }

    //    处理订单后向course表中加入书号
    public boolean addCourseBno (String CCno, String bno){
        boolean flag = false;
        DBconn.init();
        String sql ="update course set "
                +"CCbno='"+ bno
                +"' , CCissue_flag='是' where CCno = '"+CCno + "'";
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }else{
            System.out.println("修改异常");
        }
        DBconn.closeConn();
        return flag;
    }

//    删除订单后修改course表的set_flag为'否'
    public boolean updateSet_flagNo (String CCno){
        System.out.println(CCno + "我傻了");
        boolean flag = false;
        DBconn.init();
        String sql ="update course set "
                +"CCset_flag='" + "未设置"
                + "' where CCno like '" + CCno + "'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }else{
            System.out.println("修改异常");
        }
        DBconn.closeConn();
        return flag;
    }

//    管理员修改课程信息
    @Override
    public boolean updateCourse(String CCno, String CCname, String CCtno, String CCmno, String CCset_flag, String CCissue_flag){
        System.out.print("修改课程：");
        //System.out.println(CCno+"+"+CCname+"+"+CCtno+"+"+CCmno+"+"+CCset_flag+"+"+CCissue_flag);
        boolean flag = false;
        DBconn.init();
        String sql ="update course set "
                +"CCname='"+CCname
                +"' , CCtno= "+CCtno
                +" , CCmno= "+CCmno
                +" where CCno='"+ CCno +"'";
        //                +"' , CCset_flag ='" +  CCset_flag
//                +"' , CCissue_flag ='"+ CCissue_flag
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            System.out.println("成功！");
            flag = true;
        }else{
            System.out.println("失败！");
        }
        DBconn.closeConn();
        return flag;
    }

    public boolean updateCourseByManager(String CCno, String CCname, String CCtno, String CCmno, String CCset_flag, String CCissue_flag){
        boolean flag = false;
        DBconn.init();
        String sql ="update course set CCset_flag ='" + CCset_flag
                +"' , CCname ='" + CCname
                +"' , CCtno ='" + CCtno
                +"' , CCmno ='" + CCmno
                +"' , CCissue_flag ='" + CCissue_flag +"' where CCno = " + CCno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

//    public boolean updateCourse(Course co) {
//        this.co = co;
//        return false;
//    }
//
//
//    @Override
//    public boolean addCourse(Teacher te) {
//        return false;
//    }
//
//    @Override
//    public boolean updateCourse(Teacher te) {
//        return false;
//    }

    @Override
    public List<Course> FindCourseBycno(String ccno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCno like '%"+ccno+"%'");
            while(rs.next()){
                System.out.println("成功根据课程号:" + ccno + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> FindCourseBycname(String ccname) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCname like '%"+ccname+"%'");
            while(rs.next()){
                System.out.println("成功根据课程名:" + ccname + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> FindCourseBytno(String cctno) {

        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCtno like '%"+cctno+"%'");
            while(rs.next()){
                System.out.println("成功根据教师号:" + cctno + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> FindCourseBymno(String ccmno) {

        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCmno like '%"+ccmno+"%'");
            while(rs.next()){
                System.out.println("成功根据班级号:" + ccmno + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> FindCourseBySetflag(String setflag) {

        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCset_flag like '%"+setflag+"%'");
            while(rs.next()){
                System.out.println("成功根据是否设置教材:" + setflag + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> FindCourseByIssueflag(String issueflag) {

        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Course where CCissue_flag like '%"+issueflag+"%'");
            while(rs.next()){
                System.out.println("成功根据是否发放:" + issueflag + " 查找出符合条件的信息");
                Course course =  new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

        BookDao bookDao = new BookDaoimpl();

        CourseDao course = new CourseDaoImpl();
        List<Course> b2 = course.getCourseAll();

        for(Course s : b2){
            System.out.println(s.toString());
        }
    }

    //通过课程号，更改课程教材
    public boolean UpdateCourse(String CCno,String Bno) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql ="update course set CCbno ='"+Bno +"' where CCno = "+CCno;
            int i =DBconn.addUpdDel(sql);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //班长得到该班的课程信息
    public List<Course> getCourseAllByMonitor(String cno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCmno="+cno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //得到所有的课程信息
    public List<Course> getCourseall(){
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course");
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过课程号找到课程信息
    public Course FindCourse(String ccno) {
        Course course = new Course();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where Ccno = "+ccno);
            while(rs.next()){
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setBno(rs.getString("CCbno"));
                course.setMno(rs.getString("CCmno"));
                course.setSet_flag(rs.getString("CCset_flag"));
                course.setIssue_flag(rs.getString("CCissue_flag"));
                String Bno1 = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno1);
                course.setBook(book);
            }
            DBconn.closeConn();
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师得到与自己相关的课程信息
    public List<Course> getCourseAllByTeacher(String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书名找课程信息
    public Course getCourseByBno(String Bno) {
        Course course = new Course();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCbno="+Bno);
            while(rs.next()){
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setTno(rs.getString("CCtno"));
                course.setBno(rs.getString("CCbno"));
                course.setMno(rs.getString("CCmno"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                String Bno1 = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno1);
                course.setBook(book);
            }
            DBconn.closeConn();
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过课程号找满足条件的所有课程信息
    public List<Course> getCourseByCCno(String CCno,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCno like '%"+ CCno +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过课程名找满足条件的所有课程信息
    public List<Course> getCourseByCCname(String CCname,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCname like '%"+ CCname +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过书号找满足条件的所有课程信息
    public List<Course> getCourseByCCbno(String CCbno,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCbno like '%"+ CCbno +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过班号找满足条件的所有课程信息
    public List<Course> getCourseByCCmno(String CCmno,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCmno like '%"+ CCmno +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过是否设置教材找满足条件的所有课程信息
    public List<Course> getCourseByCCset_flag(String CCset_flag,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCset_flag like '%"+ CCset_flag +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过是否发放教材找满足条件的所有课程信息
    public List<Course> getCourseByCCissue_flag(String CCissue_flag,String tno) {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where CCissue_flag like '%"+ CCissue_flag +"%' and CCtno="+tno);
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                course.setCCtno(rs.getString("CCtno"));
                course.setCCbno(rs.getString("CCbno"));
                course.setCCmno(rs.getString("CCmno"));
                course.setCCset_flag(rs.getString("CCset_flag"));
                course.setCCissue_flag(rs.getString("CCissue_flag"));
                String Bno = (rs.getString("CCbno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(Bno);
                course.setBook(book);
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
