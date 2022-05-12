package com.example.SustechStore;

import com.example.SustechStore.util.SendEmail;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//主启动入口
@MapperScan(basePackages = "resources/mapConfig")
@SpringBootApplication
public class SustechStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SustechStoreApplication.class, args);

    }
}
