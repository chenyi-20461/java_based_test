package com.example.demo.springboottest.service.impl;

import com.example.demo.springboottest.enums.AmuseEnum;
import com.example.demo.springboottest.service.AmuseService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MobileAmuseServiceImpl implements AmuseService {

    @Override
    public String amuse() {
        return "玩手机真好玩";
    }

    @Override
    public Boolean support(AmuseEnum amuseEnum) {
        return AmuseEnum.mobile.equals(amuseEnum);
    }
}
