package org.example.service.impl;

import org.example.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        return "Hello";
    }
}
