package com.example.req.inheritance;

import org.springframework.web.bind.annotation.RequestMapping;

public interface RequestMappingApiService {

    @RequestMapping("/req/testOne")
    void testOne();
}
