package com.example.demo.domain.impl;

import com.example.demo.domain.inter.CyTest;
import com.example.demo.domain.model.son.Son;
import com.example.demo.domain.model.son.Son1;

public class CyTestImpl implements CyTest {


    @Override
    public <A> void testOut(A a) {

    }

    @Override
    public void testOut1(Object object) {
        System.out.println(1);
    }

    @Override
    public void testOut2(Son son) {

    }

    @Override
    public void testOut3(Son son) {

    }

    @Override
    public void testOut5(Son1 son) {

    }

/**
 * 必须强制参数相同，但是传参能传子类
 */
//    @Override
//    public void testOut2(GrandSon son) {
//
//    }
//
//    @Override
//    public void testOut3(Person son) {
//
//    }

//    @Override
//    public void testOut1(String s) {
//
//    }
}
