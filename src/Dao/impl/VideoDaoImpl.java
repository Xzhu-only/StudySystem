package Dao.impl;
import Dao.BaseDao;
import Dao.DatabaseAccessObject;
import Dao.abst.VideoDao;
import javaBean.VideoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoDaoImpl extends BaseDao implements VideoDao {

    @Override
    public boolean add(int Tid, String Vname, String category, String grade, String introduce, String img, String path) {
        String sql ="insert into video(Tid,Vname,category,grade,introduce,img,path) values(?,?,?,?,?,?,?)";
        Object[] obj = {Tid, Vname, category, grade, introduce, img, path};
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
    public List<VideoBean> getAll() throws Exception {
        String sql = "select * from video";
        List<VideoBean> list = new ArrayList<>();
        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql)) {
            while (rt.next()) {
                VideoBean vb = new VideoBean();
                vb.setVid(rt.getInt(1));
                vb.setTid(rt.getInt(2));
                vb.setVname(rt.getString(3));
                vb.setCategory(rt.getString(4));
                vb.setGrade(rt.getString(5));
                vb.setIntroduce(rt.getString(6));
                vb.setImg(rt.getString(7));
                vb.setPath(rt.getString(8));
                list.add(vb);
            }
        }
        return list;
    }

    @Override
    public VideoBean getOne(String Vname) throws Exception {
        String sql = "select * from video where Vname=?";
        Object[] obj = {Vname};
        VideoBean vb = new VideoBean();
        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql, obj)) {
            if (rt.next()) {
                vb.setVid(rt.getInt(1));
                vb.setTid(rt.getInt(2));
                vb.setVname(rt.getString(3));
                vb.setCategory(rt.getString(4));
                vb.setGrade(rt.getString(5));
                vb.setIntroduce(rt.getString(6));
                vb.setImg(rt.getString(7));
                vb.setPath(rt.getString(8));
            }
        }
        return vb;
    }

    @Override
    public VideoBean getOneByVid(int Vid) throws Exception {
        String sql = "select*from video where Vid=?";
        Object[] obj = {Vid};
        VideoBean vb=new VideoBean();
        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql, obj)) {
           if (rt.next()) {
                vb.setVid(rt.getInt(1));
                vb.setTid(rt.getInt(2));
                vb.setVname(rt.getString(3));
                vb.setCategory(rt.getString(4));
                vb.setGrade(rt.getString(5));
                vb.setIntroduce(rt.getString(6));
                vb.setImg(rt.getString(7));
                vb.setPath(rt.getString(8));
            }
        }
        return vb;
    }

    @Override
    public List<VideoBean> getOneByTid(int Tid) throws Exception {
        String sql = "SELECT * FROM video WHERE Tid=?";
        Object[] obj = {Tid};
        List<VideoBean> videoList = new ArrayList<>(); // 创建一个视频列表

        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rt = this.query(conn, sql, obj)) {

            while (rt.next()) { // 使用 while 循环获取所有符合条件的视频
                VideoBean vb = new VideoBean();
                vb.setVid(rt.getInt(1));
                vb.setTid(rt.getInt(2));
                vb.setVname(rt.getString(3));
                vb.setCategory(rt.getString(4));
                vb.setGrade(rt.getString(5));
                vb.setIntroduce(rt.getString(6));
                vb.setImg(rt.getString(7));
                vb.setPath(rt.getString(8));

                // 将每个 VideoBean 添加到列表中
                videoList.add(vb);
            }
        }

        return videoList; // 返回视频列表
    }

    @Override
    public int update(VideoBean vb) throws Exception {
        String sql = "update video set Vname=?, category=?, grade=?, introduce=?, img=?, path=? where Vid=?";
        try (Connection conn = DatabaseAccessObject.getConn()) {
            return this.modify(conn, sql, vb.getVname(), vb.getCategory(), vb.getGrade(), vb.getIntroduce(), vb.getImg(), vb.getPath(), vb.getVid());
        }
    }
    public int update1(VideoBean vb1) throws Exception {
        String sql = "update video set Vname=?, category=?, grade=?, introduce=? where Vid=?";
        try (Connection conn = DatabaseAccessObject.getConn()) {
            return this.modify(conn, sql, vb1.getVname(), vb1.getCategory(), vb1.getGrade(), vb1.getIntroduce());
        }
    }

    @Override
    public List<VideoBean> getByKeyword(String keyword) throws Exception {
        String sql = "SELECT * FROM video WHERE Vname LIKE ?";
        Object[] params = {"%" + keyword + "%"};
        List<VideoBean> list = new ArrayList<>();

        try (Connection conn = DatabaseAccessObject.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, (String) params[0]);
            try (ResultSet rt = ps.executeQuery()) {
                while (rt.next()) {
                    VideoBean vb = new VideoBean();
                    vb.setVid(rt.getInt(1));
                    vb.setTid(rt.getInt(2));
                    vb.setVname(rt.getString(3));
                    vb.setCategory(rt.getString(4));
                    vb.setGrade(rt.getString(5));
                    vb.setIntroduce(rt.getString(6));
                    vb.setImg(rt.getString(7));
                    vb.setPath(rt.getString(8));
                    list.add(vb);
                }
            }
        }
        return list;
    }


    @Override
    public List<VideoBean> getByCategory(String instrumentType, String hardType) throws Exception {
        String sql = "SELECT * FROM video";
        List<VideoBean> list = new ArrayList<>();
        Object[] params = null;

        System.out.println("SQL: " + sql);
        System.out.println("Parameters: " + Arrays.toString(params));

        if (instrumentType != null && !instrumentType.isEmpty() && hardType != null && !hardType.isEmpty()) {
            sql += " WHERE category = ? AND grade = ?";
            params = new Object[]{instrumentType, hardType};
        } else if (instrumentType != null && !instrumentType.isEmpty()) {
            sql += " WHERE category = ?";
            params = new Object[]{instrumentType};
        } else if (hardType != null && !hardType.isEmpty()) {
            sql += " WHERE grade = ?";
            params = new Object[]{hardType};
        }



        try (Connection conn = DatabaseAccessObject.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            try (ResultSet rt = ps.executeQuery()) {
                while (rt.next()) {
                    VideoBean vb = new VideoBean();
                    vb.setVid(rt.getInt(1));
                    vb.setTid(rt.getInt(2));
                    vb.setVname(rt.getString(3));
                    vb.setCategory(rt.getString(4));
                    vb.setGrade(rt.getString(5));
                    vb.setIntroduce(rt.getString(6));
                    vb.setImg(rt.getString(7));
                    vb.setPath(rt.getString(8));
                    list.add(vb);
                }
            }
        }
        return list;
    }

    @Override
    public int delete(String Vname) throws Exception {
        String sql = "delete from video where Vname=?";
        Object[] obj = {Vname};
        int rt;
        try (Connection conn = DatabaseAccessObject.getConn()){
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }

    @Override
    public int deleteByTid(int Tid) throws Exception {
        String sql = "delete from video where Tid=?";
        Object[] obj = {Tid};
        int rt;
        try (Connection conn = DatabaseAccessObject.getConn()){
            rt = this.modify(conn,sql, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rt;
    }


}
