import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC", "root", "aaaaaa");
        String sql = "insert into usertable values(null, '亲爱的', '333', 'default')";
        sql = "select * from usertable";
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery(sql);
        System.out.println(res);
        while (res.next()) {
            System.out.println(res.getInt("id") + res.getString("name") + res.getString("tel"));
        }
        stat.close();
        conn.close();
    }
}
