package org.example.openapi.controller;

import org.example.core.model.dto.User;
import org.example.core.utils.RedisUtil;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hello")
    public String hello() {
        return testService.sayHello();
    }

    @GetMapping("/testBuild")
    public String test() {
        testService.testBuilder();
        return "Success";
    }

    @GetMapping("/user")
    public User user() {
        return testService.selectUser();
    }

    @GetMapping("/testRedis")
    public String testRedis() {
        return "success!";
    }
}
