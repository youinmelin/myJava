package demo45C3P0;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P001 {
    public static void main(String[] args) throws SQLException {
        // 1.create datasource object
        DataSource ds = new ComboPooledDataSource();
        // 2. get connection object
        Connection conn = ds.getConnection();
        System.out.println(conn);
        Statement stat = conn.createStatement();
        String sql = "Update users set password = '222222' where name= 'zhenglin'";
        stat.executeUpdate(sql);
    }
}