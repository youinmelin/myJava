package lin.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 这个类到底要放在哪呀，目前这个类没有发挥作用
@Configuration
@ComponentScan(basePackages = "lin")
@EnableAspectJAutoProxy
public class SpringConfig {

}
