package com.example.demo.req.controller;

import com.example.req.inheritance.RequestHeadApiService;
import com.example.req.inheritance.RequestMappingApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RequestMapping注解能在任何类
 * 接口和类同样的继承关系.接口定义的@requestmapping（不管是方法上还是接口上）能生效，类能覆盖。
 */
@RestController
@RequestMapping("/req")
public class RequestMappingAndController implements RequestMappingApiService, RequestHeadApiService {
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

    /**
     * 该接口路径为req/testThree.
     * @return
     */
    @Override
    public String testThree() {
        return "111";
    }


    /**
     * 该接口的路径为/req/testFour1.
     * @return
     */
    @Override
    @RequestMapping("/testFour1")
    public String testFour() {
        return "1111";
    }
    
}
