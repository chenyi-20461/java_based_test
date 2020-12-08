package com.example.demo.base;

import org.junit.jupiter.api.Test;

public class BaseTest {
//    测试||只判前面就能行
    @Test
    public void testIf() {
        String a = null;
        String b = null;
        if (a == null || b.toString() == "1") {
            System.out.println(1);
        }
    }


}
