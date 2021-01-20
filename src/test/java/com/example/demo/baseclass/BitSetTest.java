package com.example.demo.baseclass;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * BitSet的测试类
 *
 * BitSet是位操作的对象，值只有0或1即false和true，内部维护了一个long数组，初始只有一个long，所以BitSet最小的size是64，当随着存储的元素越来越多，BitSet内部会动态扩充，最终内部是由N个long来存储，这些针对操作都是透明的。
 * 用1位来表示一个数据是否出现过，0为没有出现过，1表示出现过。使用用的时候既可根据某一个是否为0表示，此数是否出现过。
 * 一个1G的空间，有 8102410241024=8.5810^9bit，也就是可以表示85亿个不同的数
 */
public class BitSetTest {

    /**
     * BitSet.stream().
     */
    @Test
    public void testBitSet(){
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(6);
        bitSet.clear(1);
        IntStream intStream = bitSet.stream();
        intStream.forEach(System.out::println);
    }
}
