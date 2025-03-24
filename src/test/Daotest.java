package test;

import Dao.BaseDao;
import Dao.DatabaseAccessObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Daotest {
    public static void main(String[] args) {
        // 查询操作
        String sql = "SELECT * FROM users WHERE Uid = ?";
        Object[] obj = {1};
        BaseDao dao = new BaseDao();

        try (Connection conn = DatabaseAccessObject.getConn();
             ResultSet rs = dao.query(conn, sql, obj)) {

            // 在此处确认 ResultSet 是有效的
            if (rs != null && rs.next()) {
                System.out.println(rs.getInt("Uid"));
                System.out.println(rs.getString("Uname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
