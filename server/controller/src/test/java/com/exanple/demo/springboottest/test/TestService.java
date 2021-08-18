package com.exanple.demo.springboottest.test;

import com.example.demo.Application;
import com.example.demo.springboottest.enums.AmuseEnum;
import com.example.demo.springboottest.service.AmuseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestService {

    @Autowired
    private List<AmuseService> amuseServices;

    @Autowired
    private Map<String, AmuseService> amuseServiceMap;

    @Autowired
    private AmuseService amuseService;

    @Test
    public void testMultipleService() {
        amuseServices.forEach(
                amuseService -> {
                    if (amuseService.support(AmuseEnum.mobile)) {
                        System.out.println(amuseService.amuse());
                    }
                }
        );
    }

    @Test
    public void testSingleService() {
        System.out.println(amuseService.amuse());
    }

    @Test
    public void testMapMultipleService() {
        amuseServiceMap.forEach(
                (a, b) -> {
                    if (b.support(AmuseEnum.eat)) {
                        System.out.println(b.amuse());
                    }
                }
        );
    }

}
