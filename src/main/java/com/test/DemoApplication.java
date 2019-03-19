package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {


  
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}