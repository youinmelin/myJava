package demo44JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC03Insert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
            String sql = "insert into stu value(2, 'Nasa', 8)";
            stat = conn.createStatement();
            int ret = stat.executeUpdate(sql);
            System.out.println(ret);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stat.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}