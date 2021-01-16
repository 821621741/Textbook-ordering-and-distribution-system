package com.javaweb.demo.entity;

public class Course {
    private String cno;
    private String cname;
    private Teacher teacher;
    private Book book;
    private Monitor monitor;
    private String tno;
    private String bno;
    private String mno;
    private String set_flag = "未设置";
    private String issue_flag = "否";

    public String getCCtno() {
        return CCtno;
    }

    public void setCCtno(String CCtno) {
        this.CCtno = CCtno;
    }

    public String getCCbno() {
        return CCbno;
    }

    public void setCCbno(String CCbno) {
        this.CCbno = CCbno;
    }

    public String getCCmno() {
        return CCmno;
    }

    public void setCCmno(String CCmno) {
        this.CCmno = CCmno;
    }

    public String getCCset_flag() {
        return CCset_flag;
    }

    public void setCCset_flag(String CCset_flag) {
        this.CCset_flag = CCset_flag;
    }

    public String getCCissue_flag() {
        return CCissue_flag;
    }

    public void setCCissue_flag(String CCissue_flag) {
        this.CCissue_flag = CCissue_flag;
    }

    private String CCtno;
    private String CCbno;
    private String CCmno;
    private String CCset_flag;
    private String CCissue_flag;
    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", teacher=" + teacher +
                ", book=" + book +
                ", monitor=" + monitor +
                ", tno='" + tno + '\'' +
                ", bno='" + bno + '\'' +
                ", mno='" + mno + '\'' +
                ", set_flag='" + set_flag + '\'' +
                ", issue_flag='" + issue_flag + '\'' +
                ", CCtno='" + CCtno + '\'' +
                ", CCbno='" + CCbno + '\'' +
                ", CCmno='" + CCmno + '\'' +
                ", CCset_flag='" + CCset_flag + '\'' +
                ", CCissue_flag='" + CCissue_flag + '\'' +
                '}';
    }




    public Course() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getSet_flag() {
        return set_flag;
    }

    public void setSet_flag(String set_flag) {
        this.set_flag = set_flag;
    }

    public String getIssue_flag() {
        return issue_flag;
    }

    public void setIssue_flag(String issue_flag) {
        this.issue_flag = issue_flag;
    }

    public Course(String cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Course(String ccno, String ccname, Teacher teacher) {
        this.cno = ccno;
        this.cname = ccname;
        this.teacher = teacher;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
