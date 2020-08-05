package com.dmbjz.usercount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dmbjz"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.dmbjz.usercount.mapper")
@EnableScheduling
public class UserCountApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCountApplication.class,args);
    }

}
