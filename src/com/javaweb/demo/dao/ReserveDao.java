package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Reserve;

import java.util.List;

public interface ReserveDao {
    public boolean deleteReserve(String id);//管理员删除订单
    int preserve_num ();//求订单总数量
    List<Reserve> findAllReserve_not_issue ( );//查找所有未处理的订单
    int reserve_book_num ( );//求订单书籍总数
    double total_price ( );//求订单总价格
    double complete_degree ( );//求订单完成度
    boolean updateIssue_flag (String rno);//处理完订单之后更新订单的Issue_flag
//    管理员通过各种条件查找订单
    public List<Reserve> FindReserveByR_year (String allMessage);
    public List<Reserve> FindReserveByRno (String allMessage);
    public List<Reserve> FindReserveByCCno (String allMessage);
    public List<Reserve> FindReserveByBno (String allMessage);
    public List<Reserve> FindReserveByRnum (String allMessage);
    public List<Reserve> FindReserveByPlace (String allMessage);
    public List<Reserve> findAllReserve_issued ( );

    public boolean UpdateReserveByMonitorById(String id,int rnum);//班长填写订单的订单人数
    public int findMaxId();//查找最大的订单号，进行订单号+1
    public List<Reserve> findReserveByCno(String Cno); //班长通过班号查找订单信息
    public Boolean AddReserve(Reserve re);//添加订单信息
    public List<Reserve> FindTeacherReserve(String tno);//查找与该教师相关的订单信息
    public List<Reserve> FindTeacherReserve(String tno,String Rissue);//查找与该教师相关的未发放或已发放订单信息
    public Reserve findReserveByrno(String Rno,String tno); //通过订单号查找该订单信息
    public boolean DeleteReserve(String Rno,String CCno);//删除该订单号所对应的订单信息
    public boolean UpdateReserve(String CCno,String cno,String date,String Bno);//更改教材引发的更改订单信息
    public boolean UpdateReserve(String Rno,String Bno,String CCno);//通过订单号更改订单信息
    public boolean UpdateReserve(String Rno,String Bno,String Place,String CCno,String Time);//更改订单信息
    public List<Reserve> findReserveByBnameByTeacher(String Bname,String tno);//教师通过书名查找所有的相关订单信息
    public List<Reserve> findReserveByRnoByTeacher(String Rno,String tno);//教师通过订单号查找所有的相关订单信息
    public List<Reserve> findReserveByBnoByTeacher(String Bno,String tno);//教师通过书号查找所有的相关订单信息
    public List<Reserve> findReserveByCCnoByTeacher(String Cno,String tno);//教师通过课程号查找所有的相关订单信息
    public List<Reserve> findReserveByR_yearByTeacher(String R_year,String tno);//教师通过时间查找所有的相关订单信息
    public List<Reserve> findReserveByRissue_flagByTeacher(String Rissue,String tno);//教师通过是否发放查找所有的相关订单信息
    public List<Reserve> findReserveByPlaceByTeacher(String Place,String tno);//教师通过领书地点查找所有的相关订单信息
    public List<Reserve> findReserveByBnameByMonitor(String Bname,String cno);//班长通过书名查找所有的相关订单信息
    public List<Reserve> findReserveByRnoByMonitor(String Rno,String cno);//班长通过订单号查找所有的相关订单信息
    public List<Reserve> findReserveByBnoByMonitor(String Bno,String cno);//班长通过书号查找所有的相关订单信息
    public List<Reserve> findReserveByCCnoByMonitor(String Cno,String cno);//班长通过课程号查找所有的相关订单信息
    public List<Reserve> findReserveByR_yearByMonitor(String R_year,String cno);//班长通过时间查找所有的相关订单信息
    public List<Reserve> findReserveByRissue_flagByMonitor(String Rissue,String cno);//班长通过是否发放查找所有的相关订单信息
    public List<Reserve> findReserveByPlaceByMonitor(String Place,String cno);//班长通过领书地点查找所有的相关订单信息
    public int[] Find_Reserve_All_year();

    int[] all_prices_num ( );
}
