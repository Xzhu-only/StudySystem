package Dao.impl;

import Dao.abst.CourseDao;
import Dao.DatabaseAccessObject;
import javaBean.CourseBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoimpl implements CourseDao {

    @Override
    public List<CourseBean> getCoursesByTeacherId(int teacherId) {
        List<CourseBean> courses = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccessObject.getConn();
            if (conn == null) {
                System.out.println("Database connection failed");
                return courses;
            }
            System.out.println("Database connection successful");

            // 修改SQL查询语句，使用course表
            String sql = "SELECT Courid, Tid, Cname, category, grade, introduce, isdelete " +
                    "FROM course WHERE Tid = ? AND isdelete = 'no'";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, teacherId);
            System.out.println("Executing query for teacherId: " + teacherId);

            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("No courses found for teacherId " + teacherId);
            } else {
                do {
                    CourseBean course = new CourseBean();
                    course.setCourseId(rs.getInt("Courid"));
                    course.setTid(rs.getInt("Tid"));
                    course.setCourname(rs.getString("Cname"));
                    course.setCategory(rs.getString("category"));
                    course.setGrade(rs.getString("grade"));
                    course.setIntroduce(rs.getString("introduce"));
                    course.setIsDelete(rs.getString("isdelete"));
                    courses.add(course);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库资源
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total courses retrieved: " + courses.size());
        return courses;
    }


    @Override
    public boolean addCourse(CourseBean course, int teacherId) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 获取数据库连接
            conn = DatabaseAccessObject.getConn();

            // 确认数据库连接是否成功
            if (conn == null) {
                System.out.println("Database connection failed.");
                return false;
            }
            System.out.println("Database connection successful.");

            // 禁用自动提交，开始事务
            conn.setAutoCommit(false);

            // 修改SQL语句，插入到course表，并包括Tid
            String sql = "INSERT INTO course (Cname, category, grade, introduce, isdelete, Tid) VALUES (?, ?, ?, ?, 'no', ?)";
            ps = conn.prepareStatement(sql);

            // 设置参数
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCategory());
            ps.setString(3, course.getGrade());
            ps.setString(4, course.getIntroduce());
            ps.setInt(5, teacherId);  // 设置Tid为当前会话中的teacherId

            System.out.println("Executing query for course: " + course.getCourseName());

            // 执行插入操作
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            // 如果有行被插入，提交事务
            if (rowsAffected > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();  // 如果没有插入任何行，则回滚
                System.out.println("No rows inserted, rolling back.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // 捕获SQL异常，输出详细错误信息
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();  // 回滚事务
                    System.out.println("Transaction rolled back.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            return false;
        } finally {
            // 关闭资源
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);  // 恢复自动提交
                    conn.close();  // 关闭数据库连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Override
    public boolean updateCourse(CourseBean course) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseAccessObject.getConn();
            // 修改SQL语句，更新course表
            String sql = "UPDATE course SET Cname = ?, category = ?, grade = ?, introduce = ?, isdelete = ? WHERE Courid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCategory());
            ps.setString(3, course.getGrade());
            ps.setString(4, course.getIntroduce());
            ps.setString(5, course.getIsDelete());
            ps.setInt(6, course.getCourseId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(int courid) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseAccessObject.getConn();
            // 修改SQL语句，更新isdelete字段为'yes'来逻辑删除
            String sql = "UPDATE course SET isdelete = 'yes' WHERE Courid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, courid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
