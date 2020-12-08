package com.example.demo;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {
    //    Collection下的 stream() 和 parallelStream() 方法
    @Test
    public void test1() {
//          串行流
        long start = System.currentTimeMillis();
        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("串行的时间为:" + (end - start));
//          并行流
        start = System.currentTimeMillis();
        list = Arrays.asList(1, 2, 3);
        stream = list.parallelStream();
        stream.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("并行的时间为:" + (end - start));
    }
//    使用Arrays 中的 stream() 方法，将数组转成流
    @Test
    public void test2() {
        Integer[] nums = new Integer[100];
        Stream<Integer> stream = Arrays.stream(nums);
    }
//    使用Stream中的静态方法：of()、iterate()、generate()
    @Test
    public void test3(){
        //          串行流
        Stream<Integer> stream = Stream.iterate(0, (x) -> x + 2).limit(100000000);
        long start = System.currentTimeMillis();
        stream.mapToInt(Integer::intValue).forEach(x->{x=x++;
            return;});
        long end = System.currentTimeMillis();
        System.out.println("串行的时间为:" + (end - start));
//          并行流
        Stream<Integer> stream1 = Stream.iterate(0, (x) -> x + 2).limit(100000000);
        start = System.currentTimeMillis();
        stream1.parallel().mapToInt(Integer::intValue).forEach(x->{x=x++;});
        end = System.currentTimeMillis();
        System.out.println("并行的时间为:" + (end - start));
//      of方法
        Stream<Integer> stream4 = Stream.of(1,2,3,4,5,6);
//      iterate方法
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10
//      generate方法
        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }
//    使用 BufferedReader.lines() 方法，将每行内容转成流


}
