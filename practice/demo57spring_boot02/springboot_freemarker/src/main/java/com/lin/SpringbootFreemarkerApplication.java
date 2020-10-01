package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.text.rtf.RTFEditorKit;

@SpringBootApplication
@MapperScan("com.lin.mapper")
public class SpringbootFreemarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFreemarkerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
		return restTemplate;
	}

}
