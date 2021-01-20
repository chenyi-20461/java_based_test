package com.example.demo.baseclass;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * random的测试类.
 */
public class RandomTest {
    /**
     * 种子一样产生的随机数列表一样.
     */
    @Test
    public void testSeed() {
        Random random = new Random(10);
        System.out.println("种子为10：" + random.nextInt(10));
        Random random1 = new Random(10);
        System.out.println("种子为10：" + random1.nextInt(10));
    }
}
