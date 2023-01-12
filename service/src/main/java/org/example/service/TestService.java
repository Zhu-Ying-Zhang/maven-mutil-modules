package org.example.service;

import org.example.core.model.dto.User;
import org.example.core.model.dto.UserTest;

import java.util.Map;

public interface TestService {

    String sayHello();

    void testBuilder();

    User selectUser();

    Map<String, UserTest> getUser();

    Integer testReduce();
}
