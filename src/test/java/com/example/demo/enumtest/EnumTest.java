package com.example.demo.enumtest;

import com.example.demo.constant.TestEnum;
import org.junit.jupiter.api.Test;

/**
 * 枚举测试类.
 */
public class EnumTest {
    /**
     * 测试输出的字符串，最干脆的定义，无属性.
     *
     * 直接输出定义字符串
     */
    @Test
    public void test1(){
        System.out.println(TestEnum.FANG_XUN_TONG);
        System.out.println(TestEnum.lowString);
    }

    /**
     * valueOf
     * 没有键会抛异常
     */
    @Test
    public void test2(){
        System.out.println(TestEnum.valueOf("1"));
    }
}
