package com.example.demo.base;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class numberTest {
    @Test
    public void testWay() {
        BigDecimal a = new BigDecimal(0);
        System.out.println(a.doubleValue());
    }

    public static String keepTwo(Double doubleNum) {
        if (doubleNum == null) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(doubleNum.toString());
        BigDecimal result = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        DecimalFormat df = new DecimalFormat("#############0.##");
        return df.format(result);
    }

    /**
     * 测试保留两位小数.
     */
    @Test
    public void test() {
        System.out.println(numberTest.keepTwo(11111111.11 * 123232.1));
    }

    /**
     * 测试保留两位小数之后的double.
     *
     * bigDecimal是能看到正常数组的
     */
    @Test
    public void testOne() {
        double totalPrice = Double
                .valueOf(numberTest.keepTwo(79973.0 * 139.08));
        System.out.println(new BigDecimal(totalPrice));
    }
}
