package com.wber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC02 {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test";
        String user = "root";
        String password = "aaaaaa";
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "update stu set age = 30 where id = 1";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println("--------" + count);
        stmt.close();
        conn.close();
    }
}