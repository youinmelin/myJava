import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Druid01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream is = Druid01.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        String sql = "select * from usertable";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println(rs.next());

    }
}
