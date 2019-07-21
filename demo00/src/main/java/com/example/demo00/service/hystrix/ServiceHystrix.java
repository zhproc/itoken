package com.example.demo00.service.hystrix;

import com.example.demo00.service.UserClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceHystrix implements UserClient {

    @Override
    public String homess(String name) {
        return String.format("Hi your is : %s bad",name);
    }


}
