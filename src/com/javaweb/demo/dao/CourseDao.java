package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Course;
import com.javaweb.demo.entity.Teacher;

import java.util.List;

public interface CourseDao {
    public List<Course> getCourseAll();//返回所有课程集合
    public boolean deleteCourse(String CCno) ;// 据课程号删除老师
    public boolean addCourse(Course co);
    public boolean updateCourse(String CCno, String CCname, String CCtno, String CCmno,String CCset_flag,String CCissue_flag);
    //管理员根据各种条件查找老师
    public List<Course> FindCourseBycno(String ccno);
    public List<Course> FindCourseBycname(String  ccname);
    public List<Course> FindCourseBytno(String  cctno);
    public List<Course> FindCourseBymno(String ccmno);
    public List<Course> FindCourseBySetflag(String setflag);
    public List<Course> FindCourseByIssueflag(String issueflag);
    boolean addCourseBno (String CCno, String bno);
    boolean updateSet_flagNo (String CCno);
    public List<Course> getCourseAllByMonitor(String cno);//班长得到该班的课程信息
    public boolean UpdateCourse(String CCno,String Bno);//通过课程号，更改课程教材
    public Course FindCourse(String cno);//通过课程号找到课程信息
    public List<Course> getCourseall();//得到所有的课程信息
    public Course getCourseByBno(String Bno); //通过书名找课程信息
    public List<Course> getCourseAllByTeacher(String tno);//教师得到与自己相关的课程信息
    public List<Course> getCourseByCCno(String CCno,String tno); //通过课程号找满足条件的所有课程信息
    public List<Course> getCourseByCCname(String CCname,String tno);//通过课程名找满足条件的所有课程信息
    public List<Course> getCourseByCCbno(String CCbno,String tno);//通过书号找满足条件的所有课程信息
    public List<Course> getCourseByCCmno(String CCmno,String tno);//通过班号找满足条件的所有课程信息
    public List<Course> getCourseByCCset_flag(String CCset_flag,String tno);//通过是否设置教材找满足条件的所有课程信息
    public List<Course> getCourseByCCissue_flag(String CCissue_flag,String tno);//通过是否发放教材找满足条件的所有课程信息

}
