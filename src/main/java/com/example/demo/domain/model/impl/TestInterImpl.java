package com.example.demo.domain.model.impl;

import com.example.demo.domain.model.TestInter;

public class TestInterImpl implements TestInter {
    /**
     * 静态接口不能继承
     */
//    @Override
    public void get(){
        System.out.println(1);
    }
}
