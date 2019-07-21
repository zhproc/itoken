package com.example.demo00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//进入服务与注册中心
@EnableFeignClients//负载均衡
@EnableHystrixDashboard//熔断监控
public class Demo00Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo00Application.class, args);
    }

}
