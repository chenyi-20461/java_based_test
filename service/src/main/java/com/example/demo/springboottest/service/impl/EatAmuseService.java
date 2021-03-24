package com.example.demo.springboottest.service.impl;

import com.example.demo.springboottest.enums.AmuseEnum;
import com.example.demo.springboottest.service.AmuseService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class EatAmuseService implements AmuseService {
    @Override
    public String amuse() {
        return "吃东西真好玩";
    }

    @Override
    public Boolean support(AmuseEnum amuseEnum) {
        return AmuseEnum.eat.equals(amuseEnum);
    }
}
