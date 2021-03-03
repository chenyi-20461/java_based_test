package demo.streamTest;

import com.example.demo.model.Person;
import com.example.demo.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * stream的中间操作.
 * <p>
 * 一个流可以后面跟随零个或多个 intermediate 操作。
 * 其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），
 * 就是说，仅仅调用到这类方法，并没有真正开始流的遍历。中间都是返回中间stream.
 * <p>
 * short-circuiting
 * 对于一个 intermediate 操作，如果它接受的是一个无限大（infinite/unbounded）的 Stream，但返回一个有限的新 Stream。
 * <p>
 * public interface Stream<T> extends BaseStream<T, Stream<T>> {
 * Stream<T> filter(Predicate<? super T> predicate);
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 * IntStream mapToInt(ToIntFunction<? super T> mapper);
 * LongStream mapToLong(ToLongFunction<? super T> mapper);
 * DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
 * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
 * IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
 * LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
 * DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);
 * Stream<T> distinct();
 * Stream<T> sorted();
 * Stream<T> sorted(Comparator<? super T> comparator);
 * Stream<T> peek(Consumer<? super T> action);
 * Stream<T> limit(long maxSize);
 * Stream<T> skip(long n);
 */
public class Intermediate {
    /**
     * filter.
     * <p>
     * 提供一个判断函数，满足条件的成为新的流.
     * 不
     */
    @Test
    public void testOne() {
        Stream.of("1", "a", "2", "b").filter(a -> a.equals("1")).forEach(System.out::println);
    }

    /**
     * map.
     * <p>
     * 通过map映射条件来形成一个新的stream，是一对一的关系.
     * <p>
     * 进入的元素数量=消费的元素数量
     * 只是对数组里面的东西遍历产生新steam，他会将数组里面的每一个东西都看成整体.不能传基本类型数组
     */
    @Test
    public void testMap() {
        String[] strings = new String[]{"1", "a", "2", "b"};
        Stream.of(strings).map(a -> a + "1").forEach(System.out::println);
        System.out.println(Arrays.toString(strings));
        Dog dog = Dog.builder().age(11).name("zs").build();
        Dog dog1 = Dog.builder().age(12).name("z1").build();
        Dog dog2 = Dog.builder().age(11).name("zq").build();
        Stream.of(dog, dog1, dog2).map(dog3 -> {
            dog3.setName("test");
            return dog3;
        }).forEach(System.out::println);
        System.out.println(dog.toString() + dog1 + dog2);
    }

    /**
     * mapToInt .
     * 提供intStream
     * <p>
     * mapToLong.
     * 提供LongStream
     * <p>
     * mapToDouble
     * 提供DoubleStream
     */
    @Test
    public void testMapToInt() {
        Stream.of("1", "2", "2", "3").mapToInt(Integer::valueOf).forEach(System.out::println);
        Stream.of("1", "2", "2", "3").mapToLong(Long::valueOf).forEach(System.out::println);
        Stream.of("1", "2", "2", "3").mapToDouble(Long::valueOf).forEach(System.out::println);
        System.out.println("---数组测试");
        Stream.of("1,1", "2,2", "2,2", "3,1").map(str -> str.split(",")).forEach(System.out::println);
    }

    /**
     * flatMap
     * <p>
     * 提供一个产生流的函数，如果识别到了该流里面有多个元素，那么将所有的元素拿出来，组成一个新的流.
     * <p>
     * 适合一对多
     * 多对多等
     * 进入的元素数量<消费的元素数量
     * <p>
     * map区别:
     * 当都返回流时
     * map：不检测流里面的元素的多少。不做操作.  参数的返回值随意.
     * flatMap: 检查流中元素的多少，如果大于一，则取出所有的平铺 参数的返回必须是流.
     */
    @Test
    public void testFlatMap() {
        String[] strings = new String[]{"1", "2", "3"};
//        Stream.of(strings).forEach(System.out::println);
        String[] strings1 = new String[]{"1", "2", "3"};
//        必须两个参数类型相同才会解析为调用stream.of(T... values)
        System.out.println("传同类型参数,识别到里面还是一个collection");
        Stream.of(strings, strings1).flatMap(Stream::of).forEach(System.out::println);
//        不同调用stream.ofStream<T> of(T t)
        System.out.println("不传同类型参数，没有识别为数组");
        Stream.of(strings, "1").flatMap(Stream::of).forEach(System.out::println);
//        map区别
        System.out.println("map区别");
        Stream.of(strings, strings1).map(Stream::of).forEach(System.out::println);
//       测试多重嵌套
        System.out.println("多重嵌套");
        Object[] objects = new Object[]{strings, strings};
        Object[] objects1 = new Object[]{strings, strings};
//        元素的增加，即每一个流里面的对象是数组的时候，通过Arrays.stream解构stream.从而增加了元素
        Stream.of(objects, objects1).flatMap(Stream::of
        ).flatMap(a -> Arrays.stream((String[]) a)).forEach(System.out::println);
//        map的差异
        System.out.println("map的差异对比");
        Stream.of(objects, objects1).map(Stream::of
        ).map(Stream::of).forEach(System.out::println);
        System.out.println("等价map");
//        没有前面的这个map，那就是object
        Stream.of(objects, objects1).map(Stream::of
        ).forEach(a -> a.forEach(b -> Arrays.stream((String[]) b).forEach(System.out::println)));
    }

    /**
     * flatMapToInt.
     * 平铺int，返回intStream，如果有多个值合并成行的流.
     * <p>
     * flatMapToLong
     * 平铺Long，返回LongStream，如果有多个值合并成行的流.
     * <p>
     * flatMapToDouble
     * 平铺Double，返回DoubleStream，如果有多个值合并成行的流.
     */
    @Test
    public void testFlatMapToInt() {
        System.out.println("flatMapToInt");
        int[] ints = new int[]{1, 1};
        int[] ints1 = new int[]{1, 1};
        Object[] objects = new Object[]{ints, ints1};
        Stream.of(objects).flatMapToInt(a -> Arrays.stream((int[]) a)).forEach(System.out::println);

        System.out.println("flatMapToLong");
        long[] longs = new long[]{1, 1};
        long[] longs1 = new long[]{1, 1};
        Object[] objects1 = new Object[]{longs, longs1};
        Stream.of(objects1).flatMapToLong(a -> Arrays.stream((long[]) a)).forEach(System.out::println);

        System.out.println("flatMapToInt");
        double[] doubles = new double[]{1.0, 1.0};
        double[] doubles1 = new double[]{1.0, 1.0};
        Object[] objects2 = new Object[]{doubles, doubles1};
        Stream.of(objects2).flatMapToDouble(a -> Arrays.stream((double[]) a)).forEach(System.out::println);
    }

    /**
     * distinct();
     * <p>
     * 去重，应该是先判断 == 再判断equals方法(一般@data的lambok会重写equals方法)
     */
    @Test
    public void testDistinct() {
        Dog dog = new Dog("zs", 1);
        Dog dog1 = new Dog("zs", 1);
        System.out.println("dog的等于" + (dog == dog1));
        System.out.println("dog的equals" + (dog.equals(dog1)));
        Stream.of(dog, dog1).distinct().forEach(System.out::println);
    }

    /**
     * sorted排序.
     * <p>
     * 从小到大排序.
     * 继承Comparable的接口排序.
     */
    @Test
    public void testSorted() {
        System.out.println("有继承比较的接口");
        Dog dog = new Dog("zs", 1);
        Dog dog1 = new Dog("zs", 2);
        Stream.of(dog, dog1).sorted().forEach(System.out::println);
        System.out.println("无继承比较的接口，就会报错com.example.demo.com.example.demo.domain.model.Person cannot be cast to java.lang.Comparable");
//        错误写法
//        Person person = Person.builder().age(2).name("zs").build();
//        Person person1 = Person.builder().age(1).name("zs").build();
//        Stream.of(person, person1).sorted().forEach(System.out::println);
    }

    /**
     * Stream<T> sorted(Comparator<? super T> comparator);
     * 从小到大排序.
     * <p>
     * 对于没继承Comparable.
     */
    @Test
    public void testSortedByComparator() {
        Person person = Person.builder().name("zs").age(12).build();
        Person person1 = Person.builder().name("zs").age(11).build();
        Stream.of(person, person1).sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
    }

    /**
     * peek.
     * 中文解释为   偷看；一瞥，看一眼；（计算机）读取数据.
     * 中间操作的消费.
     * 常用于debug，只是消费，产生一些中间数据，不改变原来的元素值，改变的只有map.
     */
    @Test
    public void testPeek() {
        Person person = Person.builder().name("zs").age(12).build();
        Person person1 = Person.builder().name("zs").age(11).build();
        Stream.of(person, person1).peek(System.out::println);
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(System.out::println);
        System.out.println("测试peek能不能改变stream");

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(String::toUpperCase)
                .forEach(System.out::println);

    }

    /**
     * peek能不能改变数据源?
     * 能
     */
    @Test
    public void testChange() {
        Person person = Person.builder().name("zs").age(12).build();
        Person person1 = Person.builder().name("zs").age(11).build();
        Stream.of(person, person1).peek(person2 -> {
            person2.setAge(55);
        }).forEach(System.out::println);
        System.out.println(person.toString() + person1.toString());
        System.out.println("会不会改变原来的流");
        Stream<Person> stream = Stream.of(person, person1);
        stream.peek(person2 -> {
            person2.setAge(51);
        }).forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    /**
     * limit.
     * 限制个数.
     */
    @Test
    public void testLimit() {
        Stream.iterate(1, a -> a + 1).limit(10).forEach(System.out::println);
    }

    /**
     * skip.
     * 跳过前面元素.
     * 2即跳过前面的两个元素
     */
    @Test
    public void testSkip() {
        Stream.iterate(1, a -> a + 1).limit(10).skip(2).forEach(System.out::println);
    }

}
