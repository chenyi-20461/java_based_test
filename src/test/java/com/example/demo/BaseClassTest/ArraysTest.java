package com.example.demo.BaseClassTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * arrays的测试类
 */
public class ArraysTest {
    /**
     * 方法测试
     * sort
     * 可以有时间研究排序算法
     */
    @Test
    public void testWay() {
        int[] ints = {1, 5, 2, 7, 9};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 测试asList
     */
    @Test
    public void testWay1(){
//        多个参数
        Arrays.asList("1",2).forEach(System.out::println);
//        数组参数
        Arrays.asList(new Object[]{1,2}).forEach(System.out::println);

    }

}
