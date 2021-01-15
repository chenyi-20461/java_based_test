package com.example.demo.base.interfacetest;

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
}
