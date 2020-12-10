package com.example.demo.base;

import org.junit.jupiter.api.Test;

public class StringTest {
    //   判断字符串保存另一个字符串
    @Test
    public void test1() {
        System.out.println("abc".contains("ab"));
    }

    //    判断字符串是否等于数字
    @Test
    public void test2() {
        System.out.println("2".equals(2));
    }
//只要是双引号开头都能识别为字符串
    @Test
    public void test3() {
        Object a = "{}";
        System.out.println(a instanceof String);
    }

}
