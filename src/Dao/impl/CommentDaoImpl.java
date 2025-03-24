package Dao.impl;

import Dao.BaseDao;
import Dao.DatabaseAccessObject;
import Dao.abst.CommentDao;
import javaBean.CommentBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends BaseDao implements CommentDao {

    Connection conn = DatabaseAccessObject.getConn();
    @Override
    public List<CommentBean> getAll() throws Exception {
        String sql = "select*from comments";
        ResultSet rt=this.query(conn,sql);
        List<CommentBean> list=new ArrayList<CommentBean>();
        while (rt.next()){
            CommentBean cb=new CommentBean();
            cb.setCid(rt.getInt(1));
            cb.setUid(rt.getInt(2));
            cb.setVid(rt.getInt(3));
            cb.setCreate_time(String.valueOf((rt.getDate(4))));
            cb.setComment(rt.getString(5));
            list.add(cb);
        }
        return list;
    }

    @Override
    public int delete(int Cid) throws Exception {
        String sql = "delete from comments where Cid=?";
        Object[] obj = {Cid};
        int rt;
        try {
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public int deleteByUid(int Uid) throws Exception {
        String sql = "delete from comments where Uid=?";
        Object[] obj = {Uid};
        int rt;
        try {
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public int deleteByVid(int Vid) throws Exception {
        String sql = "delete from comments where Vid=?";
        Object[] obj = {Vid};
        int rt;
        try {
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public List<CommentBean> getByUid(int Uid) throws Exception {
        String sql = "select*from comments where Uid=?";
        Object[] obj = {Uid};
        ResultSet rt=this.query(conn,sql,obj);
        List<CommentBean> list=new ArrayList<CommentBean>();
        while (rt.next()){
            CommentBean cb=new CommentBean();
            cb.setCid(rt.getInt(1));
            cb.setUid(rt.getInt(2));
            cb.setVid(rt.getInt(3));
            cb.setCreate_time(String.valueOf((rt.getDate(4))));
            cb.setComment(rt.getString(5));
            list.add(cb);
        }
        return list;
    }

    @Override
    public List<CommentBean> getByVid(int Vid) throws Exception {
        String sql = "select*from comments where Vid=?";
        Object[] obj = {Vid};
        ResultSet rt=this.query(conn,sql,obj);
        List<CommentBean> list=new ArrayList<CommentBean>();
        while (rt.next()){
            CommentBean cb=new CommentBean();
            cb.setCid(rt.getInt(1));
            cb.setUid(rt.getInt(2));
            cb.setVid(rt.getInt(3));
            cb.setCreate_time(String.valueOf(rt.getDate(4)));
            cb.setComment(rt.getString(5));
            list.add(cb);
        }
        return list;
    }
    @Override
    public boolean add(int Uid, int Vid, String create_time, String comments) {
        // 确保 create_time 是有效的 'yyyy-MM-dd' 格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        try {
            // 先将 String 转换为 java.util.Date
            java.util.Date utilDate = dateFormat.parse(create_time);
            // 再将 java.util.Date 转换为 java.sql.Date
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // 如果日期格式不正确，返回 false
        }

        String sql = "insert into comments(Uid, Vid, creat_time, comments) values(?, ?, ?, ?)";
        Object[] obj = {Uid, Vid, sqlDate, comments};
        boolean temp = false;
        try {
            int rt = this.insert(conn, sql, obj);
            if(rt != 0) {
                temp = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }


}
