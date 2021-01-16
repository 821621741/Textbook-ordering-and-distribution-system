package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Reserve;

import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveDaoImpl implements ReserveDao {

    @Override
    public boolean deleteReserve(String Rno) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from reserve where Rno=" + Rno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public int preserve_num (){
        int num = 0;
        try {
            DBconn.init();
            String sql = "select count(Rno) from reserve";
            ResultSet rs = DBconn.selectSql(sql);
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconn.closeConn();
        }
        return num;
    }

    public int reserve_book_num(){
        int num = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve");
            while(rs.next()){
                num += rs.getInt("Rnum");
            }
            DBconn.closeConn();
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double complete_degree(){
        double degree = 0;
        int num = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve");
            while(rs.next()){
                if(rs.getString("Rissue_flag").equals("是")){
                    num++;
                }
            }
            degree = Double.valueOf(num)/this.preserve_num ();
            DBconn.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degree;
    }

    public double total_price(){
        double total_p = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve");
            BookDao book = new BookDaoimpl();
            while(rs.next()){
                total_p += rs.getInt("Rnum") * book.getPrice(rs.getString("Bno"));
            }
            DBconn.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total_p;
    }
//
//    public List<Purchase> getAllReserve() {
//        {
//            List<Purchase> list = new ArrayList<Purchase>();
//            try {
//                DBconn.init();
//                ResultSet rs = DBconn.selectSql("select * from Purchase");
//                while(rs.next()){
//                    Purchase Purchase =  new Purchase();
//                    Purchase.setBno(rs.getString("Bno"));
//                    Purchase.setBname(rs.getString("Bname"));
//                    Purchase.setBauthor(rs.getString("Bauthor"));
//                    Purchase.setBsource(rs.getString("Bsource"));
//                    Purchase.setBedition(rs.getString("Bedition"));
//                    Purchase.setBprice(rs.getString("Bprice"));
//                    Purchase.setNumber(rs.getInt("BNumber"));
//                    list.add(Purchase);
//                    int num = preserve_num();
//                    if(num >= 1){
//                        System.out.println("9999999999999999");
//                    }
//
//                }
//                DBconn.closeConn();
//                return list;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }




//    @Override
//    public boolean updateReserve(Reserve re) {
//        boolean flag = false;
//        try {
//            DBconn.init();
//            String sql ="update reserve set  Cno='"+re.getCno()
//                    +"' , Bno ='"+re.getBno()
//                    +"' , RNum ='"+re.getNum()
//                    +"' , Place ='"+re.getPlace()
//                    +"' where Rno = "+re.getId();
//            int i =DBconn.addUpdDel(sql);
//            if(i>0){
//                flag = true;
//            }
//        } finally {
//            DBconn.closeConn();
//        }
//        return flag;
//    }
//    @Override
//    public boolean updateReserveById(String id,int rnum) {
//        boolean flag = false;
//        try {
//            DBconn.init();
//            String sql ="update reserve set  Rnum='"+rnum
//                    +"' where Rno = "+id;
//            int i =DBconn.addUpdDel(sql);
//            if(i>0){
//                flag = true;
//            }
//        } finally {
//            DBconn.closeConn();
//        }
//        return flag;
//    }

//    @Override
//    public int findMaxId() {
//        int result = -1;
//        try {
//            DBconn.init();
//            String sql="select max(Rno) from reserve";
//            ResultSet rs = DBconn.selectSql(sql);
//            if (rs.next()) {
//                result = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBconn.closeConn();
//        }
//        return result;
//    }

//    @Override
//    public List<Reserve> findReserveByBno(String Bno) {
//        List<Reserve> list = new ArrayList<Reserve>();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from reserve where Tno='"+Bno+"'");
//            while(rs.next()){
//                Reserve reserve =  new Reserve();
//                reserve.setId(rs.getString("Rno"));
//                reserve.setCno(rs.getString("Cno"));
//                reserve.setBno(rs.getString("Bno"));
//                reserve.setNum(rs.getInt("Rnum"));
//                reserve.setPlace(rs.getString("Place"));
//                String bno = rs.getString("Bno");
//
//                BookDao bo  =new BookDaoimpl();
//                reserve.setBook(bo.getBookBybno(bno));
//                list.add(reserve);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//    @Override
//    public List<Reserve> findReserveByCno(String Cno) {
//        List<Reserve> list = new ArrayList<Reserve>();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from reserve where Cno='"+Cno+"'");
//            while(rs.next()){
//                Reserve reserve =  new Reserve();
//                reserve.setId(rs.getString("Rno"));
//                reserve.setCno(rs.getString("Cno"));
//                reserve.setBno(rs.getString("Bno"));
//                reserve.setNum(rs.getInt("Rnum"));
//                reserve.setPlace(rs.getString("Place"));
//                String bno = rs.getString("Bno");
//                //System.out.println(bno);
//                BookDao bo  =new BookDaoimpl();
//                Book  book =  bo.getBookBybno(bno);
//                reserve.setBook(book);
//               // System.out.println(book.getBauthor());
//                list.add(reserve);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }




//    @Override
//    public List<Reserve> findReserveByStatus(String status) {
//        List<Reserve> list = new ArrayList<Reserve>();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from reserve where Bstatus='"+status+"'");
//            while(rs.next()){
//                Reserve reserve =  new Reserve();
//                reserve.setId(rs.getString("Rno"));
//                reserve.setCno(rs.getString("Cno"));
//                reserve.setBno(rs.getString("Bno"));
//                reserve.setNum(rs.getInt("Rnum"));
//                reserve.setPlace(rs.getString("Place"));
//                list.add(reserve);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<Reserve> findAllReserve_not_issue() {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                System.out.println(reserve.getBnum() + "8888888888888");
                //System.out.println("输出：" + reserve.Rbook.getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reserve> findAllReserve_issued ( ){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//    @Override
//    public List<Reserve> findUnDealReserve() {
//        List<Reserve> list = new ArrayList<Reserve>();
//        try {
//
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from reserve where Bstatus='"+"未发放"+"'");
//            while(rs.next()){
//                Reserve reserve =  new Reserve();
//                reserve.setId(rs.getString("Rno"));
//                reserve.setCno(rs.getString("Cno"));
//                reserve.setBno(rs.getString("Bno"));
//                reserve.setNum(rs.getInt("Rnum"));
//                reserve.setPlace(rs.getString("Place"));
//
//                String bno = rs.getString("Bno");
//                BookDao bo  =new BookDaoimpl();
//                reserve.setBook(bo.getBookBybno(bno));
//                list.add(reserve);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<Reserve> topQuery(Reserve reserve) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ylsm?useunicuee=true& characterEncoding=utf8","root","123456");
            /*
             * 1. 给出一个sql语句前半部
             */
            StringBuilder sql = new StringBuilder("select * from Reserve where 1=1");
            /*
             * 2. 判断条件，完成向sql中追加where子句
             */
            /*
             * 3. 创建一个ArrayList，用来装载参数值
             */
            List<Object> params = new ArrayList<Object>();

            String id = reserve.getId();

            if (id != null && !id.trim().isEmpty()) {
                sql.append(" and Rno like ?");
                params.add("%" + id + "%");
            }

            String cno=reserve.getCno();
            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Cno like ?");
                params.add("%" + cno + "%");
            }

            String bno=reserve.getBno();
            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Bno like ?");
                params.add("%" + bno + "%");
            }
//            String rnum=reserve.getNum();
//            if (cno != null && !cno.trim().isEmpty()) {
//                sql.append(" and Rnum  = ?");
//                params.add("%" + rnum + "%");
//            }
            String place =reserve.getPlace();
            if (place != null && !place.trim().isEmpty()) {
                sql.append(" and Place like ?");
                params.add("%" + place + "%");
            }




            /*
             * 三、执行query
             */
            QueryRunner qr = new QueryRunner();

            return qr.query(conn,sql.toString(), new BeanListHandler<Reserve>(Reserve.class), params.toArray());

        } catch (SQLException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

//    @Override
//    public Reserve findOrderById(String id) {
//        Reserve reserve =  new Reserve();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from reserve where Rno='"+id+"'");
//            while(rs.next()){
//
//                reserve.setId(rs.getString("Rno"));
//                reserve.setCno(rs.getString("Cno"));
//                reserve.setBno(rs.getString("Bno"));
//                reserve.setNum(rs.getInt("Rnum"));
//                reserve.setPlace(rs.getString("Place"));
//                String bno = rs.getString("Bno");
//                BookDao bo  =new BookDaoimpl();
//                reserve.setBook(bo.getBookBybno(bno));
//            }
//            DBconn.closeConn();
//            return reserve;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }




    public List<Reserve> FindReserveByR_year (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and R_year like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByRno (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and Rno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByCCno (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and CCno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByBno (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and Bno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByRnum (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and Rnum like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByPlace (String allMessage,int a){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag='是' and Rnum!=0 and Place like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }








    public List<Reserve> FindReserveByR_year (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and R_year like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByRno (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and Rno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByCCno (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and CCno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByBno (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and Bno like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByRnum (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and Rnum like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserve> FindReserveByPlace (String allMessage){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rissue_flag!='是' and Rnum!=0 and Place like '%" + allMessage + "%'");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setBnum(bo.getBookBybno(bno).getBnum());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }








//    处理订单后更新issue_flag为'是'
public boolean updateIssue_flag (String Rno){
        boolean flag = false;
        try {
            DBconn.init();
            String sql ="update reserve set  Rissue_flag='" + '是'
                    +"' where Rno = " + Rno;
            int i =DBconn.addUpdDel(sql);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //更改教材引发的更改订单信息
    public boolean UpdateReserve(String CCno,String cno,String date,String Bno){
        boolean flag = false;
        try {
            DBconn.init();
            int i =DBconn.addUpdDel("update reserve set Bno ='"+ Bno +"' where CCno = '"+ CCno +"' and Cno="+cno);
            int k=DBconn.addUpdDel("update reserve set R_year='"+ date +"' where CCno = '"+ CCno +"' and Cno="+cno);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //班长填写订单的订单人数
    public boolean UpdateReserveByMonitorById(String id,int rnum) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql ="update reserve set  Rnum='"+rnum
                    +"' where Rno = "+id;
            int i =DBconn.addUpdDel(sql);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //班长通过班号查找订单信息
    public List<Reserve> findReserveByCno(String Cno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("Select * From Reserve,course,monitor " + "where " + " Reserve.CCno=Course.CCno and Course.CCmno=monitor.Cno and monitor.cno =" + Cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加订单信息
    public Boolean AddReserve(Reserve re) {
        boolean flag = false;
        try {
            DBconn.init();
            int i = DBconn.addUpdDel("insert into reserve(Rno,CCno,Bno,Cno,Rnum,R_year,Rissue_flag) " +
                    "values('" + re.getRno() + "','" + re.getCcno() + "','" + re.getBno() + "','" + re.getCno() + "','" + re.getRnum() + "','" + re.getR_year() + "','" + re.getRissue_flag() + "')");
            if (i > 0) {
                flag = true;
                int k=DBconn.addUpdDel("update course set CCbno='"+re.getBno() +"' where CCno='"+re.getCcno()+"'");
                int l=DBconn.addUpdDel("update course set CCset_flag='已设置' where CCno='"+re.getCcno()+"'");
                int p=DBconn.addUpdDel("update course set CCissue_flag='否' where CCno='"+re.getCcno()+"'");
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //查找最大的订单号，进行订单号+1
    public int findMaxId() {
        int result = -1;
        try {
            DBconn.init();
            String sql = "select max(Rno) from reserve";
            ResultSet rs = DBconn.selectSql(sql);
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconn.closeConn();
        }
        return result;
    }

    //通过订单号查找该订单信息
    public Reserve findReserveByrno(String Rno,String tno){
        Reserve reserve = new Reserve();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.Rno like '%" + Rno + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setYear(rs.getString("R_year"));
                reserve.setIssue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
            }
            DBconn.closeConn();
            return reserve;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查找与该教师相关的订单信息
    public List<Reserve> FindTeacherReserve(String tno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("Select * From Reserve,course,teacher " + "where " + " Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+ tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                String Rno=rs.getString("Rno");
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                reserve.setCno(rs.getString("Cno"));
                reserve.setRnum(rs.getInt("Rnum"));
                int Rnum=rs.getInt("Rnum");
                double Price=reserve.getBook().getBprice();
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setTime(rs.getString("Time"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setTotalprice(Rnum*Price);
                DBconn.init();
                DBconn.addUpdDel("update reserve set TotalPrice='"+reserve.getTotalprice()+"' where Rno="+Rno);
                DBconn.closeConn();
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查找与该教师相关的未发放或已发放订单信息
    public List<Reserve> FindTeacherReserve(String tno,String Rissue) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("Select * From Reserve,course,teacher " + "where " + " Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ='"+ tno+"' and Rissue_flag='"+Rissue+"'");
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                String Rno=rs.getString("Rno");
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                reserve.setCno(rs.getString("Cno"));
                reserve.setRnum(rs.getInt("Rnum"));
                int Rnum=rs.getInt("Rnum");
                double Price=reserve.getBook().getBprice();
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setTime(rs.getString("Time"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setTotalprice(Rnum*Price);
                DBconn.init();
                DBconn.addUpdDel("update reserve set TotalPrice='"+reserve.getTotalprice()+"' where Rno="+Rno);
                DBconn.closeConn();
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除该订单号所对应的订单信息
    public boolean DeleteReserve(String Rno,String CCno) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from reserve where Rno=" + Rno;
        int k =DBconn.addUpdDel("update course set CCbno=null where CCno="+CCno);
        int p=DBconn.addUpdDel("update course set CCset_flag='未设置' where CCno="+CCno);
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    //通过订单号更改订单信息
    public boolean UpdateReserve(String Rno,String Bno,String CCno) {
        boolean flag = false;
        try {
            DBconn.init();
            int i = DBconn.addUpdDel("update reserve set Bno='" + Bno +"' where Rno="+Rno);
            int k=DBconn.addUpdDel("update course set CCbno='"+Bno+"' where CCno="+CCno);
            if (i > 0) {
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //更改订单信息
    public boolean UpdateReserve(String Rno,String Bno, String Place,String CCno,String Time) {
        boolean flag = false;
        try {
            DBconn.init();
            int i = DBconn.addUpdDel("update reserve set Bno='" + Bno +"' where Rno="+Rno);
            int j=DBconn.addUpdDel("update reserve set Place='" + Place +"' where Rno="+Rno);
            int k=DBconn.addUpdDel("update course set CCbno='"+Bno+"' where CCno="+CCno);
            int p=DBconn.addUpdDel("update reserve set Time='"+Time+"' where Rno="+Rno);
            if (i > 0) {
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    //教师通过订单号查找所有的相关订单信息
    public List<Reserve> findReserveByRnoByTeacher(String Rno,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.Rno like '%" + Rno + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过书号查找所有的相关订单信息
    public List<Reserve> findReserveByBnoByTeacher(String Bno,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.Bno like '%" + Bno + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过课程号查找所有的相关订单信息
    public List<Reserve> findReserveByCCnoByTeacher(String CCno,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.CCno like '%" + CCno + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过时间查找所有的相关订单信息
    public List<Reserve> findReserveByR_yearByTeacher(String R_year,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.R_year like '%" + R_year  +"%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过是否发放查找所有的相关订单信息
    public List<Reserve> findReserveByRissue_flagByTeacher(String Rissue,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.Rissue_flag like '%" + Rissue + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过领书地点查找所有的相关订单信息
    public List<Reserve> findReserveByPlaceByTeacher(String Place,String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher where reserve.Place like '%" + Place + "%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //教师通过书名查找所有的相关订单信息
    public List<Reserve> findReserveByBnameByTeacher(String Bname, String tno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,teacher,book where book.Bname like '%" + Bname +"%' and Reserve.CCno=Course.CCno and Course.CCtno=Teacher.Tno and book.Bno=reserve.Bno and Teacher.Tno ="+tno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过书名查找所有的相关订单信息
    public List<Reserve> findReserveByBnameByMonitor(String Bname,String cno) {
        List<Reserve> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor,book where book.Bname like '%" + Bname +"%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and book.Bno=reserve.Bno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过订单号查找所有的相关订单信息
    public List<Reserve> findReserveByRnoByMonitor(String Rno,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.Rno like '%" + Rno + "%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过书号查找所有的相关订单信息
    public List<Reserve> findReserveByBnoByMonitor(String Bno,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.Bno like '%" + Bno + "%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过课程号查找所有的相关订单信息
    public List<Reserve> findReserveByCCnoByMonitor(String CCno,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.CCno like '%" + CCno + "%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过时间查找所有的相关订单信息
    public List<Reserve> findReserveByR_yearByMonitor(String R_year,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.R_year like '%" + R_year  +"%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过是否发放查找所有的相关订单信息
    public List<Reserve> findReserveByRissue_flagByMonitor(String Rissue,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.Rissue_flag like '%" + Rissue + "%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //班长通过领书地点查找所有的相关订单信息
    public List<Reserve> findReserveByPlaceByMonitor(String Place,String cno){
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve,course,monitor where reserve.Place like '%" + Place + "%' and Reserve.CCno=Course.CCno and Course.CCmno=Monitor.Cno and Monitor.Cno ="+cno);
            while (rs.next()) {
                Reserve reserve = new Reserve();
                reserve.setRno(rs.getString("Rno"));
                reserve.setCcno(rs.getString("CCno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setRnum(rs.getInt("Rnum"));
                reserve.setR_year(rs.getString("R_year"));
                reserve.setRissue_flag(rs.getString("Rissue_flag"));
                reserve.setPlace(rs.getString("Place"));
                String bno = (rs.getString("Bno"));
                BookDao bo = new BookDaoimpl();
                Book book = bo.getBookBybno(bno);
                reserve.setBook(book);
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int[] Find_Reserve_All_year(){
        String year[] = {"2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        int num[] = {0,0,0,0,0,0,0,0,0,0};
        for(int i = 0;i < 10;i++){
            try {
                DBconn.init();
                ResultSet rs = DBconn.selectSql("select * from reserve where R_year like '" + year[i] +"%'");
                while(rs.next()){
                    num[i]++;
                }
                DBconn.closeConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }


    public int[] all_prices_num() {
        int price_num[] = {0,0,0};
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book ");
            while (rs.next()) {
                if(rs.getDouble("Bprice") <= 30){
                    price_num[0]++;
                }else if(rs.getDouble("Bprice") > 60){
                    price_num[2]++;
                }else{
                    price_num[1]++;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price_num;
    }
}
