package lin;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("lin.mapper")  // mybatis scan interface in mapper
public class DemoApplicationContext {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationContext.class, args);
    }
}
