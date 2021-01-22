package com.example.demo.baseclass;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * arrays的测试类
 */
public class ArraysTest {
    /**
     * toString方法遍历输出
     * deepToString
     * Arrays.deepToString()主要用于数组中还有数组的情况，而Arrays.toString()则相反，对于Arrays.toString()而言，当数组中有数组时，不会打印出数组中的内容，只会以地址的形式打印出来。
     */
    @Test
    public void testToString() {
        int[] arr = new int[]{3, 5, 4, 1};
        System.out.println(Arrays.toString(arr));
        Object[] arr1 = new Object[]{3, 5, 4, 1};
        System.out.println(Arrays.deepToString(arr1));

//        deepToString
        int a[] = {1, 2, 3};
        System.out.println(Arrays.toString(a));
        int b[][] = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));
    }

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
        System.out.println("对象通过比较lambda表达式排序：" + Arrays.toString(persons));
    }

    /**
     * 对象的比较,对象需要实现Comparable接口
     */
    @Test
    public void testObject() {
        Dog dog = Dog.builder().age(12).name("zhangSan").build();
        Dog dog1 = Dog.builder().age(11).name("zhangSan1").build();
        Dog[] dogs = new Dog[]{dog, dog1};
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));
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

    /**
     * 测试parallelPrefix
     * <p>
     * 并行地计算给定阵列的每个元素a
     * </p>
     */
    @Test
    public void test() {
        int[] ints = new int[]{3, 2, 1};
        Arrays.parallelPrefix(ints, (a, b) -> a - b);
        /*
         *计算过程
         * 第一个不变
         * 第二个 3-2 为1
         * 第三个 1-1 为0
         * 最终结果为[3,1,0]*/
        System.out.println("第一个数组：" + Arrays.toString(ints));


//        对于指定的元素范围进行操作
        Arrays.parallelPrefix(ints, 0, 2, (a, b) -> a - b);
        /*只计算前两个
         * 所以结果为[3,1,1]*/
    }

    /**
     * binarySearch测试
     * <p>
     * [1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；
     * <p>
     * [2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
     * <p>
     * [3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
     * <p>
     * [4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
     */
    @Test
    public void test1() {
        int[] arr = new int[]{3, 5, 4, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        [1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；结果为一
        System.out.println(Arrays.binarySearch(arr, 2));
//        [2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
        System.out.println(Arrays.binarySearch(arr, 3));
//        [3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
        System.out.println(Arrays.binarySearch(arr, 6));
//        [4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
        System.out.println(Arrays.binarySearch(arr, 0));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * equals方法
     */
    @Test
    public void test2() {
        int[] arr = new int[]{3, 5, 4, 1};
        int[] arr1 = new int[]{3, 5, 4, 1};
        System.out.println(arr1.equals(arr));
        System.out.println(Arrays.equals(arr, arr1));
    }

    /**
     * fill方法
     * 全部覆盖
     */
    @Test
    public void test3() {
        int[] arr = new int[]{3, 5, 4, 1};
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * copyOf方法,指定长度的截取
     * 全部覆盖
     */
    @Test
    public void test4() {
        int[] arr = new int[]{3, 5, 4, 1};
        int[] arr1 = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * copyOfRange方法，指定from to复制
     * from 和 to 两个数不能一样
     * 全部覆盖
     */
    @Test
    public void test5() {
        int[] arr = new int[]{3, 5, 4, 1};
        int[] arr1 = Arrays.copyOfRange(arr, 1, 2);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * asList方法，作为一个arrayList
     */
    @Test
    public void test6() {
        int[] arr = new int[]{3, 5, 4, 1};
        List list = Arrays.asList(arr);
        System.out.println(Arrays.toString(list.toArray()));
        Object[] arr1 = new Object[]{3, 5, 4, 1};
        List list1 = Arrays.asList(arr1);
        System.out.println(Arrays.toString(list1.toArray()));
    }

    /**
     * setAll 一个函数生成，产生的数填充数组
     */
    @Test
    public void test7() {
        int[] arr = new int[]{3, 5, 4, 1};
        Arrays.setAll(arr, a -> a + 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * spliterator
     * Spliterator是一个可分割迭代器(splitable iterator)，
     * 可以和iterator顺序遍历迭代器一起看。
     * jdk1.8发布后，对于并行处理的能力大大增强，Spliterator就是为了并行遍历元素而设计的一个迭代器，jdk1.8中的集合框架中的数据结构都默认实现了spliterator，
     * 后面我们也会结合ArrayList中的spliterator()一起解析。
     */
    @Test
    public void test8() {
        int[] arr = new int[]{3, 5, 4, 1};
        Arrays.spliterator(arr).forEachRemaining((Consumer<? super Integer>) a-> System.out.println(a));
    }

    /**
     * stream返回泛型数组对应的stream.
     *
     * char数组不能被转为stream,基本类型数组char不能识别
     */
    @Test
    public void test9(){
//        char[] chars = new char[]{22,'a'};
//        Arrays.stream(chars);
        Dog dog = new Dog("zs", 1);
        Dog dog1 = new Dog("liSi", 2);
        Dog[] dogs = new Dog[]{dog, dog1};
        Arrays.stream(dogs).forEach(System.out::println);
    }

    /**
     * 实用arrays.
     *实际还是equals方法，对比每个对象。
     * 筛选数字
     */
    @Test
    public void test10(){
        System.out.println(Arrays.asList(1,2,3).contains(1));
        System.out.println(Arrays.asList(Dog.builder().age(12).build(),Dog.builder().age(12).build()).contains(Dog.builder().age(12).build()));
    }
}
