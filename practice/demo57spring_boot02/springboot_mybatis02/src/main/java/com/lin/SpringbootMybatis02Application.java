package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lin.mapper")
public class SpringbootMybatis02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatis02Application.class, args);
	}

}
