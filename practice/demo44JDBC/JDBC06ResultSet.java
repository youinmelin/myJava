package demo44JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC06ResultSet {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet ret = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
            String sql = "select * from stu";
            stat = conn.createStatement();
            ret = stat.executeQuery(sql);
            while (ret.next()) {
                System.out.print(ret.getString(2) + ":" + ret.getInt("age"));
                System.out.println("");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ret.close();
                stat.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}