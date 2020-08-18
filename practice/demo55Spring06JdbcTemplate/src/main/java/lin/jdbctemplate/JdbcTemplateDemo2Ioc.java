package lin.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * basic use of JdbcTemplate
 */
public class JdbcTemplateDemo2Ioc {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate)ac.getBean("JdbcTemplate");
        jt.execute("insert into account (name,money) values ('ccc',1000);");
    }
}
