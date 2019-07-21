package com.example.springcloudcinfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudCinfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudCinfigApplication.class, args);
    }

}
