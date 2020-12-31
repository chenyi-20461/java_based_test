package com.example.demo.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void testRight() {
        String a = "hello world";
        String pattern = ".*llo.*";
        String pattern2 = "//^h";

        Pattern patternCom = Pattern.compile(pattern2);
        Matcher m = patternCom.matcher(a);
        System.out.println("字符串：" + a.matches(pattern));
        System.out.println("正则：" + m.find());
        String b = "这是一个测试1";
        String pattern1 = ".*这是.*";
        System.out.println(b.matches(pattern1));

    }

    @Test
    public void arrayTest() {
        String a = "11,22";
        List list = Arrays.asList(a.split(","));
        System.out.println(list);
    }

    @Test
    public void wayTest() {
//       contains方法，包含字符串返回true，否者false
        String a = "[\"等待放款\"]";
        System.out.println(a.contains("等待放款"));
    }
}
