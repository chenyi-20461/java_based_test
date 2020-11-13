package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefaultTestImpl implements DefaultTest {
    @Override
    public void test1(String a){
        System.out.println(a+a);
    }

    @Override
    public void test4() {

    }

}
