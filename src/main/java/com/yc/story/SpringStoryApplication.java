package com.yc.story;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@Controller
@MapperScan("com.yc")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class SpringStoryApplication implements WebMvcConfigurer {
	//  lhrrrrrr
	//嘎嘎嘎嘎嘎58686
	//test
	//滚滚滚
	//嘎
	//lhr
	//sad	
	public static void main(String[] args) {
		SpringApplication.run(SpringStoryApplication.class, args);
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
