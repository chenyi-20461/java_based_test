package com.example.demo.req.controller;

import com.example.req.inheritance.RequestHeadApiService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoHeadController implements RequestHeadApiService {
    @Override
    public String testThree() {
        return "222";
    }

    @Override
    public String testFour() {
        return null;
    }
}
