package com.yida.yidaweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yida.yidaweb.dao")
public class YidawebApplication {

	public static void main(String[] args) {
		SpringApplication.run(YidawebApplication.class, args);
	}
}
