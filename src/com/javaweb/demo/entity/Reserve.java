package com.javaweb.demo.entity;

public class Reserve {
    private String id;

    @Override
    public String toString() {
        return "Reserve{" +
                "id='" + id + '\'' +
                ", cno='" + cno + '\'' +
                ", bno='" + bno + '\'' +
                ", num=" + num +
                ", year='" + year + '\'' +
                ", issue_flag='" + issue_flag + '\'' +
                ", place='" + place + '\'' +
                ", Rbook=" + Rbook +
                ", time='" + time + '\'' +
                ", totalprice=" + totalprice +
                ", ccno='" + ccno + '\'' +
                ", rno='" + rno + '\'' +
                ", r_year='" + r_year + '\'' +
                ", rissue_flag='" + rissue_flag + '\'' +
                ", rnum=" + rnum +
                ", course=" + course +
                ", book=" + book +
                ", Bnum='" + Bnum + '\'' +
                '}';
    }

    private String cno;
    private String bno;
    private int num;
    private String year;
    private String issue_flag;
    private String place;
    public Book Rbook;
    private String time;
    private double totalprice;
    private String ccno;
    private String rno;
    private String r_year;
    private String rissue_flag;
    private int rnum;
    private Course course;
    private Book book;
    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getR_year() {
        return r_year;
    }

    public void setR_year(String r_year) {
        this.r_year = r_year;
    }

    public String getRissue_flag() {
        return rissue_flag;
    }

    public void setRissue_flag(String rissue_flag) {
        this.rissue_flag = rissue_flag;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public double getTotalprice ( ) {
        return totalprice;
    }

    public void setTotalprice (double totalprice) {
        this.totalprice = totalprice;
    }

    public Book getRbook ( ) {
        return Rbook;
    }

    public void setRbook (Book rbook) {
        Rbook = rbook;
    }

    public String getTime ( ) {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    private String Bnum = "0";

    public String getBnum () {
        return Bnum;
    }

    public void setBnum (String Bnum) {
        this.Bnum = Bnum;
    }


    public String getYear ( ) {
        return year;
    }

    public void setYear (String year) {
        this.year = year;
    }

    public String getIssue_flag ( ) {
        return issue_flag;
    }

    public void setIssue_flag (String issue_flag) {
        this.issue_flag = issue_flag;
    }

    public Reserve() {
    }

    public Reserve(String id, String cno, String bno, int num, String year,  String issue_flag, String place, Book book) {
        this.id = id;
        this.cno = cno;
        this.bno = bno;
        this.num = num;
        this.year = year;
        this.issue_flag = issue_flag;
        this.place = place;
        this.Rbook = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Book getBook() {
        return Rbook;
    }

    public void setBook(Book book) {
        this.Rbook = book;
        System.out.println(book.getBnum() + "aaaaaaaa");
    }
}
