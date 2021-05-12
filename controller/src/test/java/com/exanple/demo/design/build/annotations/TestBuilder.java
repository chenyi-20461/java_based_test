package com.exanple.demo.design.build.annotations;

import org.junit.Test;

public class TestBuilder {
    @Test
    public void test1(){
        System.out.println(Simple.builder().zs("1").ll("1").build());
    }
}
