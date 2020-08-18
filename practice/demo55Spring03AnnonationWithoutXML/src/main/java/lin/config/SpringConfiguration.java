package lin.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * This is a config Class, same as bean.xml
 *  @Configuration in spring, define this Class is a config Class
 * @ComponetScan define the package to scan when spring create the containor
 */
@Configuration
//@ComponentScan(basePackages = {"lin"})
@ComponentScan("lin")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
    // jdbc.driver come from properties file
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /*
    * create a QueryRunner object and add it into ioc containor
    * */
    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /*
    * create dataSource object
    * */
    @Bean(name="dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(username);
        ds.setPassword(password);
        return ds;
    }
}
