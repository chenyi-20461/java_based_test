package com.example.demo.streamTest;

import com.example.demo.domain.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终止操作
 * void forEach(Consumer<? super T> action);
 * void forEachOrdered(Consumer<? super T> action);
 * Object[] toArray();
 * <A> A[] toArray(IntFunction<A[]> generator);
 * T reduce(T identity, BinaryOperator<T> accumulator);
 * Optional<T> reduce(BinaryOperator<T> accumulator);
 * <U> U reduce(U identity,BiFunction<U, ? super T, U>accumulator,
 * BinaryOperator<U> combiner);
 * <R> R collect(Supplier<R> supplier,iConsumer<R, ? super T> accumulator,iConsumer<R, R> combiner);
 * <R, A> R collect(Collector<? super T, A, R> collector);
 * Optional<T> min(Comparator<? super T> comparator);
 * Optional<T> max(Comparator<? super T> comparator);
 * long count();
 * boolean anyMatch(Predicate<? super T> predicate);
 * boolean allMatch(Predicate<? super T> predicate);
 * boolean noneMatch(Predicate<? super T> predicate);
 * Optional<T> findFirst();
 * Optional<T> findAny();
 */
public class TerminalTest {
    /**
     * 循环消费.
     * <p>
     * list的forEach和stream的ForEach没有任何关系。
     * <p>
     * 只是功能参数相同
     * <p>
     * 遍历消费
     */
    @Test
    public void testForEach() {
        Stream.of(1, 2, 3).forEach(System.out::println);
        Arrays.asList(1, 2, 3).forEach(System.out::println);
    }

    /**
     * forEachOrdered.
     * <p>
     * 并行处理的时候按顺序处理的。
     */
    @Test
    public void testForEachOrdered() {
        Stream.of(1, 2, 3).parallel().forEach(System.out::println);
        Stream.of(1, 2, 3).parallel().forEachOrdered(System.out::println);
    }

    /**
     * toArray().
     * 返回一个数组
     */
    @Test
    public void testToArray() {
        Object[] objects = Stream.of(1, 2, 3).toArray();
        System.out.println(Arrays.toString(objects));

    }

    /**
     * toArray(IntFunction<A[]> generator)
     * <p>
     * 指定类型，生成的数组类型强制指定.
     */
    @Test
    public void testToArrayByIntFunction() {
        Object[] objects = Stream.of(1, 2, 3).toArray(Integer[]::new);
        System.out.println(Arrays.toString(objects));

        Object[] objects2 = Stream.of(1, 2, 3).toArray(a -> new Integer[3]);
        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects2));
        //处理对象数组
        Dog dog = new Dog("zs", 11);
        Dog dog1 = new Dog("ls", 10);
        Dog[] objects1 = Stream.of(dog, dog1).toArray(Dog[]::new);
//        错误写法
//        Dog[] objects2 = Stream.of(dog, dog1).toArray();
        System.out.println(Arrays.toString(objects1));
    }

    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * <p>
     * 上一个是下一个的值,identity作为起始值.
     * 递归操作.
     */
    @Test
    public void testReduce1() {
        int c = 1;
        Integer result = Stream.of(1, 2, 3).reduce(c, Integer::sum);
        System.out.println(result);
        String result1 = Stream.of("a", "b", "c").reduce("a", (a, b) -> a + b);
        System.out.println(result1);
    }

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator).
     *
     * <p>
     * 递归操作
     */
    @Test
    public void testReduce() {
        Optional<Integer> result = Stream.of(1, 2, 3).reduce(Integer::sum);
        System.out.println(result.get());
    }

    /**
     * <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner).
     *
     * <p>
     * 表示多个进程做accumulator,全部实现BiFunction<U, ? super T, U>，产生多个U，然后combiner合并结果集，
     * 如果accumulator和combiner不一致会导致多线程时有数据两个操作都做.
     * 递归操作
     * combiner(identity, u)  is equal to u 即n*identity = identity（n为变量等于分支线程数，求identity）
     * combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
     */
    @Test
    public void testReduce2() {
        long start = 0;
        long end = 0;
        Integer result = Stream.of(1, 2, 3).reduce(1, Integer::sum, (a, b) -> a - b);
        Integer result1 = Stream.of(1, 2, 3).parallel().reduce(1, Integer::sum, (a, b) -> a - b);
//        推测，(1+1)+(1+2)+(1-3) = 3
        System.out.println(result);
        System.out.println(result1);
        Integer result2 = Stream.of(1, 2, 3).parallel().reduce(0, Integer::sum, (a, b) -> a - b);
//        0+1 0+3 0-2
        System.out.println(result2);
        Integer result5 = Stream.of(1, 2, 3).parallel().reduce(2, Integer::sum, Integer::sum);
//        2+1 2+2 2+3
        System.out.println(result5);
        System.out.println("测试开始");
        start = System.currentTimeMillis();
        Integer result3 = Stream.iterate(1, a -> a + 1).limit(10).parallel().reduce(0, (a, b) -> {
            System.out.println("accumulator:a:" + a + "b:" + b);
            return a + b;
        }, (a, b) -> {
            System.out.println("combiner:a:" + a + "b:" + b);
            return a + b;
        });
        System.out.println(result3);
        end = System.currentTimeMillis();
        System.out.println("并行时间" + (end - start));
        start = System.currentTimeMillis();
        Integer result4 = Stream.iterate(1, a -> a + 1).limit(10).reduce(0, Integer::sum, Integer::sum);
        System.out.println(result4);
        end = System.currentTimeMillis();
        System.out.println("串行时间" + (end - start));
    }

    /**
     * <R> R collect(Supplier<R> supplier,
     * BiConsumer<R, ? super T> accumulator, （每次消费都会产生结果）
     * BiConsumer<R, R> combiner) (前面消费过的结果过后，合并结果)
     * <p>
     * 注意参数第二个在消费
     * <p>
     * string可能没有用引用
     */
    @Test
    public void testCollect() {
        ArrayList list = Stream.of("hello", "world", "helloworld").collect(
                () -> new ArrayList(),
                (theList, item) -> theList.add(item),
                (list1, list2) -> list1.addAll(list2)
        );
        String collect = Stream.of("hello", "world", "helloworld").collect(() -> "1", (a, b) -> {
            System.out.println(a + b);
        }, (a, b) -> {
            System.out.println(a + b + "1");
        });
        System.out.println("并行消费");
        String collect1 = Stream.of("hello", "world", "helloworld").parallel().collect(() -> new String("1"), (a, b) -> {
            System.out.println(a + b);
            a = a + b;
            System.out.println("a为" + a);
        }, (a, b) -> {
            System.out.println("并行执行" + a + b + "1");
            a = a + b;
        });
        System.out.println(list.toString());
        System.out.println("collect:" + collect);
        System.out.println("collect1:" + collect1);
        System.out.println("并行消费1");
        Dog collect2 = Stream.of("hello", "world", "helloworld").parallel().collect(() -> new Dog(), (a, b) -> {
            a.setName(b);
            System.out.println("accumulator" + a);
        }, (a, b) -> {
            System.out.println("combiner" + a);
            System.out.println(b);
            a.setAge(12);
        });
        System.out.println("非string类测试" + collect2);
        System.out.println("做自己的map");
        HashMap<String, String> map = Stream.of("hello", "world", "helloworld").collect(HashMap::new, (x, y) -> {
            x.put(y, y); // 自己做自己的key
        }, HashMap::putAll);
        System.out.println(map);
    }

    /**
     * <R, A> R collect(Collector<? super T, A, R> collector);
     * <p>
     * 获取list
     */
    @Test
    public void testCollect1() {
//        arrayList的两种写法
        List list = Stream.of("hello", "world", "helloworld").collect(Collectors.toList());
        List list1 = Stream.of("hello", "world", "helloworld").collect(Collectors.toCollection(ArrayList::new));
        System.out.println("list：" + list);
        System.out.println("ArrayList:" + list1);
        TreeSet<String> treeSet = Stream.of("hello", "world", "helloworld").collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet"+treeSet);
    }
}
