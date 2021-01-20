package com.example.demo.streamTest;

import com.example.demo.domain.model.compare.Dog;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream的创建.
 * <p>
 * Arrays.stream
 * stream.of
 * Collection.stream
 * Stream.generate
 * Stream.builder
 * Stream.iterate
 * Files.lines,所有流的lines方法
 * java.util.stream.IntStream.range()
 * Stream<Path> walk(Path start,int maxDepth,FileVisitOption... options)
 * Random.ints()无 Random.ints(long streamSize)
 * BitSet.stream()
 */
public class Create {
    /**
     * Arrays.stream，我们可以通过Arrays的静态方法，传入一个泛型数组，创建一个流
     * <p>
     * 为了提高效率，Java标准库提供了IntStream、LongStream和DoubleStream这三种使用基本类型的Stream，
     * 它们的使用方法和范型Stream没有大的区别，设计这三个Stream的目的是提高运行效率
     * <p>
     * stream(T[] array)
     * stream(int[] array)
     * stream(long[] array)
     * stream(double[] array)
     */
    @Test
    public void testCreate() {
        Object[] dd = {"a", "b", "C"};
        Arrays.stream(dd).forEach(System.out::println);
        String[] strings = new String[]{"1", "a", "b"};
        Arrays.stream(strings).forEach(System.out::println);
        int[] ints = new int[]{1, 2, 3};
        Arrays.stream(ints).forEach(System.out::println);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.forEach(System.out::println);
    }

    /**
     * stream.of通过Stream的静态方法
     * <p>
     * of(T... values) 底层使用arrays.stream(T[] array)
     * of(T t)
     */
    @Test
    public void testOf() {
        Stream.of(1, "1").forEach(System.out::println);
        Dog dog = new Dog("zs", 1);
        Stream.of(dog).forEach(System.out::println);
    }

    /**
     * Collection.stream.
     */
    @Test
    public void testCollection() {
        List<Object> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.forEach(System.out::println);
        int a = list.size();
        Object o = list.stream().findFirst();
        System.out.println("测试toString:" + a + o.toString());
    }

    /**
     * Stream.generate.
     * <p>
     * 流不可以消费第二次
     * stream has already been operated upon or closed
     */
    @Test
    public void testGenerate() {
//        AtomicInteger自动生成方法
        AtomicInteger a = new AtomicInteger(1);
        Stream<Integer> integerStream = Stream.generate(a::getAndIncrement);
        integerStream.limit(10).forEach(System.out::println);
//       自己实现的生产者接口，没实现自增
        Stream<Integer> integerStream1 = Stream.generate(() -> {
            int s = 0;
            return 1 + s;
        });
        integerStream1.limit(10).forEach(System.out::println);
//        自己实现的生产者接口，实现自增
        Stream<Integer> integerStream2 = Stream.generate(new NatualSupplier());
        integerStream2.limit(10).forEach(System.out::println);
    }

    class NatualSupplier implements Supplier<Integer> {
        int n = 0;

        public Integer get() {
            n++;
            return n;
        }
    }


    /**
     * Stream.builder.
     * <p>
     * 通过add方法添加泛型参数.
     */
    @Test
    public void testBuilder() {
        Stream<Integer> integerStream = Stream.<Integer>builder().add(1).build();
        integerStream.forEach(System.out::println);
    }

    /**
     * 文件的流Files.lines不如buffer
     * files.lines不稳定？
     * <p>
     * 速度
     * buffer>BufferedReader.line>Files.lines
     */
    @Test
    public void testFile() throws IOException {
        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\filetest.txt")));
        String a = null;
        a = bufferedReader.readLine();
        while (a != null) {
            System.out.println(a);
            a = bufferedReader.readLine();
        }
        end = System.currentTimeMillis();
        System.out.println("buffer的测试时间" + (end - start));
        //--
        start = System.currentTimeMillis();
        Stream<String> lines = Files.lines(Paths.get("D:\\filetest.txt"));
        lines.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Files.lines的测试时间" + (end - start));
        //--
        start = System.currentTimeMillis();
        Stream<String> lines1 = new BufferedReader(new FileReader(new File("D:\\filetest.txt"))).lines();
        lines1.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("BufferedReader.lines的stream测试时间" + (end - start));
    }

    /**
     * Stream.iterate(起始元素，处理的函数)无限流
     */
    @Test
    public void testIterate() {
        Stream<Integer> integerStream = Stream.iterate(2, a -> a + 2);
        integerStream.limit(10).forEach(System.out::println);
    }

    /**
     * java.util.stream.IntStream.range()(起始元素，终止元素).
     * <p>
     * 包前不包后
     * 返回IntStream
     */
    @Test
    public void testRange() {
        IntStream intStream = IntStream.range(1, 10);
        intStream.forEach(System.out::println);
    }

    /**
     * java.nio.file.Files.walk(文件路径,深度,访问方式).
     * 返回该目录下面的路径.
     * <p>
     * 返回Stream<Path>
     * <p>
     * 如果没有权限就会抛出java.nio.file.AccessDeniedException
     */
    @SneakyThrows
    @Test
    public void testWalk() {
        Stream<Path> stream = Files.walk(Paths.get("D:\\"), 2, FileVisitOption.FOLLOW_LINKS);
        stream.filter(a -> a.toString().contains("down")).forEach(path -> {
            System.out.println(path.toString());
        });
    }

    /**
     * Random.ints()无 Random.ints(long streamSize).
     */
    @Test
    public void testRandom(){
        Random random = new Random(10);
//        有限流
        IntStream intStream = random.ints(10);
//        无限流
        intStream.forEach(System.out::println);
    }

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

    /**
     * JarFile.stream().
     */
    @Test
    public void testJar() throws IOException {
        JarFile jarFile = new JarFile("D://1.jar");
        jarFile.stream().forEach(System.out::println);
    }

    /**
     * Pattern.splitAsStream(java.lang.CharSequence).
     */
    @Test
    public void testSplitAsStream(){
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,a,a,b,aaa,ff");
        stringStream.forEach(System.out::println);
        Stream<String> stringStream1 = pattern.splitAsStream("a");
        stringStream1.forEach(System.out::println);
    }

}