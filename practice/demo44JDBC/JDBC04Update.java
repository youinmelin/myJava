package demo44JDBC;

import java.sql.*;

public class JDBC04Update {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
            stat = conn.createStatement();
            String sql = "update stu set id = 3 where name = 'Nasa'";
            int ret = stat.executeUpdate(sql);
            System.out.println(ret);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stat.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}