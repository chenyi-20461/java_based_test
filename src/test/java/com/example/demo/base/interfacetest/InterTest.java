package com.example.demo.base.interfacetest;

import com.example.demo.domain.Person1;
import com.example.demo.domain.impl.CyTestImpl;
import org.junit.jupiter.api.Test;

public class InterTest {
    /**
     * 接口里面能不能有属性.
     *
     * public static final
     * 接口中不能出现变量，如果有变量，就和接口提供的统一的抽象这种思想是抵触的
     */
    @Test
    public void testOne(){
        CyTestImpl cyTest = new CyTestImpl();
//        cyTest.zhangSan = "11";错误代码，final变量不能赋值
        System.out.println(cyTest.zhangSan);
    }

    /**
     * 接口里面参数不能向下转型.
     *
     * 定义时必须强制相同，不管是泛型还是其他的东西
     *
     * 实际引用不是泛型和object的话都必须强制相同
     */
    @Test
    public void testTwo(){
        CyTestImpl cyTest = new CyTestImpl();
        cyTest.testOut(new Person1());
//        cyTest.testOut5(new Person1());
//        cyTest.testOut5(new GrandSon1());
    }

    /**
     * 普通方法紧接上一个测试.
     *

     * 实际引用不是泛型和object的话都必须强制相同
     */
    @Test
    public void testThree(){
        Person1 person1 = new Person1();
//        person1.testParam(new Person1());
//        person1.testParam(new GrandSon1());
    }
}
