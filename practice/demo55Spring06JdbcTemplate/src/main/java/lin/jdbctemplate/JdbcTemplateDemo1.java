package lin.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * basic use of JdbcTemplate
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 0.config dataSource
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///spring");
        ds.setUsername("root");
        ds.setPassword("aaaaaa");

        // 1.create JdbcTemplate object
        JdbcTemplate jt = new JdbcTemplate(ds);
        // 2.operate
        jt.execute("insert into account (name,money) values ('ccc',1000);");
    }
}
