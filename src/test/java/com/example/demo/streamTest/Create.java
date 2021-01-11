package com.example.demo.streamTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Create {
    /**
     * Arrays.stream，我们可以通过Arrays的静态方法，传入一个泛型数组，创建一个流
     */
    @Test
    public void testCreate(){
        Object[] dd = {"a","b","C"};
        Arrays.asList(dd).forEach(System.out::println);
    }


}
