package com.yc.story;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class SpringStoryApplication implements WebMvcConfigurer {

	//嘎嘎嘎嘎嘎58686
	//test
	//lhr
	//sad

	public static void main(String[] args) {
		SpringApplication.run(SpringStoryApplication.class, args);
	}		
}
