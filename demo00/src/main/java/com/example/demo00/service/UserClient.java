package com.example.demo00.service;

import com.example.demo00.service.hystrix.ServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = ServiceHystrix.class)
public interface UserClient {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String homess(@RequestParam(value = "name") String name);
}
