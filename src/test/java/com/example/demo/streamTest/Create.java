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
        Arrays.stream(dd).forEach(System.out::println);
        String[] strings = new String[]{"1", "a", "b"};
        Arrays.stream(strings).forEach(System.out::println);
        int[] ints = new int[]{1,2,3};
        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * stream.of通过Stream的静态方法
     */


}
