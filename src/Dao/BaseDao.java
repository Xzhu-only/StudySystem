package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    // 查询方法
    public ResultSet query(Connection conn, String sql, Object... obj) throws Exception {
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; ++i) {
                ps.setObject(i + 1, obj[i]);
            }
            result = ps.executeQuery();
            if (result == null) {
                throw new SQLException("Query execution failed, ResultSet is null.");
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Database query error: " + e.getMessage());
        } finally {
            // 关闭 PreparedStatement，但不关闭 ResultSet

        }
    }

    // 插入方法
    public int insert(Connection conn, String sql, Object... obj) throws Exception {
        int result = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < obj.length; ++i) {
                ps.setObject(i + 1, obj[i]);
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Database insert error: " + e.getMessage());
        }
        return result;
    }

    // 修改方法
    public int modify(Connection conn, String sql, Object... obj) throws Exception {
        int result = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < obj.length; ++i) {
                ps.setObject(i + 1, obj[i]);
                System.out.println("设置参数 " + (i + 1) + ": " + obj[i]);
            }
            result = ps.executeUpdate();
            System.out.println("执行结果: " + result);
        } catch (SQLException e) {
            System.out.println("SQL 执行错误: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Database modify error: " + e.getMessage());
        }
        return result;
    }

}
