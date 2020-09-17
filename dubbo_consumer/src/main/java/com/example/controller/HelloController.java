package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/hello")
public class HelloController {


    @Reference
    // 使用Dubbo提供的注解，直接到注册中心查找服务
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
