package com.example.demo.req.controller;

import com.example.req.inheritance.RequestMappingApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/req")
public class RequestMappingAndController implements RequestMappingApiService {
    /**
     * 该接口的路径为/req/req/testOne.
     */
    @Override
    public void testOne() {
        System.out.println(1);
    }

    /**
     * 该接口的路径为/req/testTwo.
     */
    @RequestMapping("/testTwo")
    public void testTwo() {
        System.out.println(1);
    }
}
