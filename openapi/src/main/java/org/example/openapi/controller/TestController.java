package org.example.openapi.controller;

import org.example.core.model.dto.User;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplate redisTemplate;

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
        redisTemplate.opsForValue().set("Test", 111);
        return "success!";
    }

    @GetMapping("/testNull")
    public String testNull(@RequestParam("id") Integer id) {
        if (id == 1) {
            throw new NullPointerException();
        }
        return "success!";
    }
}
