package com.example.demo.base;

import org.junit.jupiter.api.Test;

public class BaseTest {
    //    测试||和&&只判前面就能行,
    @Test
    public void testIf() {
        String a = null;
        String b = null;
        if (a == null || a.toString() == "1") {
            System.out.println(1);
        }

        if (a != null && b.toString() == "1") {
            System.out.println(1);
        }
    }

    //    测试while快捷写法
    @Test
    public void testWhile() {
        int n = 3;
        while (n-- != 0) {
            System.out.println(n);
        }
        int a = 3;
        while (a != 0) {
            a--;
            System.out.println(a);
        }
    }


}
