package com.exanple.demo.stringtest.test;



import org.junit.jupiter.api.Test;

import java.io.File;

public class CodingTest {

    /**
     * 测试特殊字符串.
     */
    @Test
    public void test1(){
        String s = "\u0001\u0001\u0001\u0001\u0001\u0001";
        System.out.println(s);
    }

    /**
     * 测试特殊字符串.
     */
    @Test
    public void test2(){
        String s = "1";
        String a = s.concat("1").concat(File.separator);
        System.out.println(a);
    }
}
