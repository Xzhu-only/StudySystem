package Dao;

import java.sql.*;

public class DatabaseAccessObject {
    public static Connection getConn() {
        Connection conn;
        // 修改数据库连接 URL
        String dburl = "jdbc:mysql://db:3306/studytest?characterEncoding=utf8&serverTimezone=UTC";
        String dbusername = "root";
        String dbpassword = "example"; // 注意使用在 Docker Compose 中设置的密码
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    //查询
}
