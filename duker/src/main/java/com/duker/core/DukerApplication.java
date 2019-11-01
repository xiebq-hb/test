package com.duker.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.duker.core.mapper")
@EnableJms
//@EnableIdGenerator
public class DukerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DukerApplication.class, args);
    }

}
