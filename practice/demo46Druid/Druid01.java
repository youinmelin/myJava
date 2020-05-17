package demo46Druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Druid01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream is = Druid01.class.getClassLoader().getResourceAsStream("lib/druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        Statement stat = conn.createStatement();
        String sql = "Update users set password = '222222' where name= 'zhenglin'";
        int ret = stat.executeUpdate(sql);
        System.out.println(ret);
    }
}