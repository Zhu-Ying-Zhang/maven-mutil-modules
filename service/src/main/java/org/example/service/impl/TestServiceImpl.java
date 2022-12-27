package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.core.model.dto.User;
import org.example.mapper.TestMapper;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuyingzhang
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public void testBuilder() {
        int i = 5;
        List l = new ArrayList<User>();
        while (i != 0) {
            User t;
            if ( i % 2 == 0) {
                t = User.builder()
                         .name("Joe")
                         .age(100)
                         .build();
            } else {
                t = User.builder().age(10).build();
            }
            log.info("{}", t.toString());
            l.add(t);
            i--;
        }
    }

    @Override
    public User selectUser() {
        User u = testMapper.selectTestObject();
        log.info("{}", u);
        return u;
    }
}
