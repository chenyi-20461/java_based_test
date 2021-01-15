package com.example.demo.enumtest;

import com.example.demo.constant.AttributeEnum;
import com.example.demo.constant.TestEnum;
import org.junit.jupiter.api.Test;

/**
 * 枚举测试类.
 */
public class EnumTest {
    /**
     * 测试输出的字符串，最干脆的定义，无属性.
     * <p>
     * 直接输出定义字符串
     */
    @Test
    public void test1() {
        System.out.println(TestEnum.FANG_XUN_TONG);
        System.out.println(TestEnum.lowString);
    }

    /**
     * valueOf
     * 没有键会抛异常
     */
    @Test
    public void test2() {
        System.out.println(TestEnum.valueOf("1"));
    }

    /**
     * toString,将对象转成string.
     * 没有无法equals
     */
    @Test
    public void test3() {
        System.out.println(TestEnum.lowString.equals("lowString"));
        System.out.println(TestEnum.lowString.toString().equals("lowString"));
    }

    /**
     * 有属性的测试.
     * 私有属性拿不到
     */
    @Test
    public void test4(){
//        System.out.println(AttributeEnum.apple.name1);
//        NormalClass normalClass = new NormalClass("11");
//        System.out.println(normalClass.name); 私有属性拿不到
//有了setter注解之后能拿到
        System.out.println(AttributeEnum.apple.getName1());
    }

    /**
     * name方法.
     *
     * 直接返回构造方法的键值的{@link String}
     */
    @Test
    public void test5(){
        System.out.println(AttributeEnum.WATERMELON.name());
    }
}
