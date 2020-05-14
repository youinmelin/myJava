package demo44JDBC;
// get the data from table stu in the database, save data in Class Stu, print out.

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBC07Practice {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "aaaaaa");
        Statement stat = conn.createStatement();
        String sql = "select * from stu";
        ResultSet ret = stat.executeQuery(sql);
        Stu stu = new Stu();
        List<Stu> stus = new ArrayList<>();
        while (ret.next()) {
            stu.setId(ret.getInt("id"));
            stu.setName(ret.getString("name"));
            stu.setAge(ret.getInt("age"));
            System.out.println(stu);
            stus.add(stu);
        }
        System.out.println(stus);
        ret.close();
        stat.close();
        conn.close();
    }
}