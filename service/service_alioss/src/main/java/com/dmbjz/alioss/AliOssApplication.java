package com.dmbjz.alioss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.dmbjz")
@EnableDiscoveryClient
public class AliOssApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliOssApplication.class,args);
    }

}
