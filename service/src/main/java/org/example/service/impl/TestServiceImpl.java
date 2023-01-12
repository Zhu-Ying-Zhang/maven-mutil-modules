package org.example.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.example.core.model.dto.User;
import org.example.core.model.dto.UserTest;
import org.example.mapper.TestMapper;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        Optional.ofNullable(u).ifPresent(value -> System.out.println(value));
        return u;
    }

    @Override
    public Map<String, UserTest> getUser() {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 1000; i++) a.add(i);
        log.info("Test: {}", getSegmentedList(a, 2));
        return testMapper.selectTestObjectTestMap();
    }

    private <T> Collection<List<T>> getSegmentedList(List<T> midList, Integer chunkSize) {
        final AtomicInteger counter = new AtomicInteger();
        return Optional.ofNullable(midList).orElse(Collections.emptyList()).stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();
    }

    @Override
    public Integer testReduce() {
        List<Integer> a = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        Optional<Integer> sum = a.stream().reduce((b, c) -> {
            b += c;
            return b;
        });

        log.info("sum: {}", sum.get());
        return sum.get();
    }
}
