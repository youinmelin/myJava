package demo44JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC08PrepareStatement {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
        String sql = "select * from users where name = ? and password = ?";
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1,"userone");
        pstat.setString(2, "12345");
        ResultSet ret = pstat.executeQuery();
        if (ret.next()) {
            System.out.println("login sucessfully.");
        }else {
            System.out.println("user or password wrong.");
        }
        ret.close();
        pstat.close();
        conn.close();
    }
}