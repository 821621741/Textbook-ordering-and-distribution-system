package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Monitor;
import java.util.List;

public interface MonitorDao {
    public boolean login(String name,String pwd);//登录
    public List<Monitor> getMonitorAll();//返回用户信息集合
    public boolean delete(String id) ;//根据id删除用户
    public boolean update(String id, String garde, String dept, String major, String num) ;//更新用户信息
    public boolean update(Monitor mo) ;//更新用户信息
    public boolean addMonitor(Monitor mo);
    public List<Monitor> FindMonitorByCno(String id);
    public List<Monitor> FindMonitorByCdept(String dept);
    public List<Monitor> FindMonitorByCgrade(String grade);
    public List<Monitor> FindMonitorBynum(String num);
    public List<Monitor> FindMonitorByCmajor(String major);
    public boolean update(String cno, String num);//更改班级人数
    public Monitor findMonitorByCno1(String cno);
    public boolean modifyPwd(String cno,String pwd);//修改班长密码
}
