package com.example.demo.BaseClassTest;

import com.example.demo.domain.model.Person;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

/**
 * arrays的测试类
 */
public class ArraysTest {
    /**
     * 方法测试
     * sort
     * 可以有时间研究排序算法
     */
    @Test
    public void testWay() {
        long startTime = System.currentTimeMillis();
        Instant instant = Instant.now();
//        直接排序
        int[] ints = {5, 3, 2, 0, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Arrays.sort(ints);
        long endTime = System.currentTimeMillis();
        Instant endInstant = instant.now();
        System.out.println("串行排序时间：" + Duration.between(instant, endInstant).toMillis()); //时间的另一种写法
        System.out.println(Arrays.toString(ints));
        int[] ints1 = {5, 3, 2, 0, 9};
//        对数组元素指定范围进行排序（排序范围是从元素下标为from,到下标为to-1的元素进行排序）
        Arrays.sort(ints1, 0, 3);
        System.out.println(Arrays.toString(ints1));
        startTime = System.currentTimeMillis();
//      对数组元素进行并行排序
        int[] ints2 = {5, 3, 2, 0, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Arrays.parallelSort(ints2);
        endTime = System.currentTimeMillis();
        System.out.println("并行排序时间：" + (endTime - startTime));
        System.out.println(Arrays.toString(ints2));
//        object排序
        Person person = Person.builder().age(10).build();
        Person person1 = Person.builder().age(9).build();
        Object[] persons = new Object[]{person, person1};
        Arrays.sort(persons, Comparator.comparingInt(p -> ((Person) p).getAge()));
        System.out.println(Arrays.toString(persons));
    }

    /**
     * asList将object数组转为arrays
     */
    @Test
    public void testWay1() {
//        多个参数
        Arrays.asList("1", 2).forEach(System.out::println);
//        数组参数
        Arrays.asList(new Object[]{1, 2}).forEach(System.out::println);
//        非object数组，会识别成一个参数
        Arrays.asList(new int[]{1, 2}).forEach(System.out::println);
    }

}
