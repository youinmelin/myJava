package demo44JDBC;

import java.sql.*;

public class JDBC05Delete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
            stat = conn.createStatement();
            String sql = "delete from stu where id = 2" ;
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