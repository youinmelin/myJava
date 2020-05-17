package demo47JDBCTemplate;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplate01 {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        InputStream is = JdbcTemplate01.class.getClassLoader().getResourceAsStream("lib/druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        JdbcTemplate template = new JdbcTemplate(ds);
        // template.update("update stu set age = 35 where name = 'zl'");
        // template.update ("insert into stu values(null, 'Nasa', 8)");
        // template.update ("insert into stu values(null, 'ming', 8)");
        // template.update ("insert into stu values(null, 'Ouyang', 8)");
        // template.update ("insert into stu values(null, 'song', 8)");
        // template.update ("delete from stu where name = 'ming'");
        // String sql = "delete from stu where id = ?";
        // template.update(sql, 5);

        String sql = "select * from stu where id =1";
        Map<String, Object> map = template.queryForMap(sql);
        System.out.println(map);

        sql = "select * from stu where age < 10";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);

        sql = "select * from stu where age < 10";
        List<Stu> stuList =template.query(sql, new BeanPropertyRowMapper<>(Stu.class));
        for (Stu stu : stuList) {
            System.out.println(stu);
        }

    }
}