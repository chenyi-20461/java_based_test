package com.example.req.inheritance;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/req1")
public interface RequestHeadApiService {
    @RequestMapping("/testThree")
    String testThree();

    @RequestMapping("/testFour")
    String testFour();
}
