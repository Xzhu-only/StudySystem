package Dao.impl;

import Dao.BaseDao;
import Dao.DatabaseAccessObject;
import Dao.abst.TeacherDao;
import javaBean.TeacherBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public TeacherBean login(String Tname) throws Exception {
        String sql = "SELECT tid, tpassword, isdelete FROM teacher WHERE tname = ?";

        try (Connection conn = DatabaseAccessObject.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, Tname);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int Tid = rs.getInt("tid");  // 获取教师ID
                    String Tpassword = rs.getString("tpassword");
                    String isdelete = rs.getString("isdelete");

                    // 打印查询结果
                    System.out.println("DB teacherId: " + Tid);
                    System.out.println("DB Tpassword: " + Tpassword);
                    System.out.println("DB isdelete: " + isdelete);

                    // 返回包含teacherId的TeacherBean
                    return new TeacherBean(Tid, Tname, Tpassword, isdelete);
                } else {
                    System.out.println("No result found for Tname: " + Tname);
                }
            }
        }
        return null;
    }


    @Override
    public boolean register(String Tname, String Tpassword, String prone, String introduce) {
        String sql = "insert into teacher(Tname,Tpassword,prone,introduce) values(?,?,?,?)";
        Object[] obj = {Tname, Tpassword, prone, introduce};
        boolean temp = false;
        try (Connection conn = DatabaseAccessObject.getConn()) {
            int rt = this.insert(conn, sql, obj);
            if (rt != 0) {
                temp = true;
            }
        } catch (Exception a) {
            throw new RuntimeException(a);
        }
        return temp;
    }

    @Override
    public List<TeacherBean> getAll() throws Exception {
        String sql = "select * from teacher";  // 注意空格，确保 SQL 语句格式正确
        List<TeacherBean> list = new ArrayList<TeacherBean>();

        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql)) {

            while (rt.next()) {  // 使用 while 循环遍历所有结果行
                TeacherBean tb = new TeacherBean();
                tb.setTid(rt.getInt(1));        // 第一列是 tid
                tb.setTname(rt.getString(2));   // 第二列是 tname
                tb.setTpassword(rt.getString(3)); // 第三列是 tpassword
                tb.setProne(rt.getString(4));   // 第四列是 prone
                tb.setIntroduce(rt.getString(5)); // 第五列是 introduce
                tb.setIsdelete(rt.getString(6)); // 第六列是 isdelete
                list.add(tb);  // 将每一行的 TeacherBean 添加到 list 中
            }
        }
        return list;
    }


    @Override
    public TeacherBean getOne(String Tname) throws Exception {
        String sql = "SELECT * FROM teacher WHERE Tname=?";
        Object[] obj = {Tname};
        TeacherBean tb = new TeacherBean();
        System.out.println("Executing SQL: " + sql + " with Tname=" + Tname);


        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql, obj)) {

            // 检查连接是否成功
            System.out.println("数据库连接成功，正在执行查询...");

            if (rt.next()) {
                tb.setTid(rt.getInt(1));          // 假设 Tid 是第 1 列
                tb.setTname(rt.getString(2));     // Tname 是第 2 列
                tb.setTpassword(rt.getString(3)); // Tpassword 是第 3 列
                tb.setProne(rt.getString(4));     // prone 是第 4 列
                tb.setIntroduce(rt.getString(5)); // introduce 是第 5 列
                tb.setIsdelete(rt.getString(6));  // isdelete 是第 6 列
                System.out.println("Teacher data: " + tb);
            } else {
                // 如果查询没有结果，输出日志
                System.out.println("未查询到相关教师数据");
            }
        }

        if (tb.getTid() == 0) {
            throw new RuntimeException("教师信息未找到");
        }

        return tb;
    }



    @Override
    public boolean add(String Tname, String Tpassword, String prone, String introduce) {
        return false;
    }

    @Override
    public int delete(String Tname) throws Exception {
        String sql = "delete from teacher where Tname=?";
        Object[] obj = {Tname};
        int rt;
        try (Connection conn = DatabaseAccessObject.getConn()) {
            rt = this.modify(conn, sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public int update(TeacherBean tb) throws Exception {
        String sql = "update teacher set Tname=?,Tpassword=?,prone=?,introduce=?,isdelete=? where Tid=?";
        try (Connection conn = DatabaseAccessObject.getConn()) {
            System.out.println("Executing SQL: " + sql);
            System.out.println("Parameters: " + tb.getTname() + ", " + tb.getTpassword() + ", " + tb.getProne() + ", " + tb.getIntroduce() + ", " + tb.getIsdelete() + ", " + tb.getTid());
            return this.modify(conn, sql, tb.getTname(), tb.getTpassword(), tb.getProne(), tb.getIntroduce(), tb.getIsdelete(), tb.getTid());
        }
    }
}
