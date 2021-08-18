package demo.base.paramtest;

import com.example.demo.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 测试Object...和object[]和T[]和object[]
 * <p>
 * 只传一个参数时
 * 相同：
 * 能解析非基本类型数组,即object子类数组
 * 不同：
 * objects能传多个参数
 * objects能传基本类型数组，能转为object[]的一个索引位置。
 * 而T[]和object[]不能传基本类型数组
 */
public class ObjectsTest {
    /**
     * 用于测试Object...解析.
     *
     * @param objects Object...参数
     * @return
     */
    public static void varParameterTest(Object... objects) {
        Stream.of(objects).forEach(System.out::println);
    }

    /**
     * 测试Object...解析
     * string[]是否能被object...识别到多个参数？
     * 结果：能
     * <p>
     * 泛型数组int[]
     * int[]是否能被object...识别到多个参数？
     * 结果：不能
     * <p>
     * 非泛型数组
     * 对象数组能不能被识别？
     * 结果：能
     * <p>
     * 如果传了多个参数，第一个是数组，那么将整个数组解析为数组中的一个对象，并没有深层解析
     */
    @Test
    public void test() {
        String[] strings = new String[]{"1", "a"};
        ObjectsTest.varParameterTest(strings);
        int[] ints = new int[]{1, 2};
        ObjectsTest.varParameterTest(ints);
        Dog[] dogs = new Dog[]{new Dog("1", 1), new Dog("2", 2)};
        ObjectsTest.varParameterTest(dogs);
        ObjectsTest.varParameterTest(dogs, 1);
    }

    /**
     * 用于测试Object[]参数解析.
     *
     * @param objects Object...参数
     * @return
     */
    public static void varParameterTest1(Object[] objects) {
        Stream.of(objects).forEach(System.out::println);
    }

    /**
     * 测试Object[]解析
     * string[]是否能被Object[]识别到多个参数
     * 能
     * <p>
     * 泛型数组int[]
     * 结果：不能传
     * <p>
     * 非泛型数组
     * 对象数组能不能被识别？
     * 能
     * <p>
     * 如果传了多个参数，第一个是数组，那么将整个数组解析为数组中的一个对象，并没有深层解析
     */
    @Test
    public void test1() {
        String[] strings = new String[]{"1", "a"};
        ObjectsTest.varParameterTest1(strings);
        Integer[] ints = new Integer[]{1, 2};
        ObjectsTest.varParameterTest1(ints);
        Dog[] dogs = new Dog[]{new Dog("1", 1), new Dog("2", 2)};
        ObjectsTest.varParameterTest1(dogs);
    }

    /**
     * 用于测试T[]参数解析.
     *
     * @param objects Object...参数
     * @return
     */
    public static <T> void varParameterTest2(T[] objects) {
        Stream.of(objects).forEach(System.out::println);
    }

    /**
     * 测试T[]解析
     * string[]是否能被T[]识别到多个参数
     * 能
     * <p>
     * 泛型数组int[]
     * 结果：不能传
     * <p>
     * 非泛型数组
     * 对象数组能不能被识别？
     * 能
     * <p>
     * 如果传了多个参数，第一个是数组，那么将整个数组解析为数组中的一个对象，并没有深层解析
     */
    @Test
    public void test2() {
        String[] strings = new String[]{"1", "a"};
        ObjectsTest.varParameterTest2(strings);
//        int[] ints = new int[]{1, 2};
//        ObjectsTest.varParameterTest2(ints);
        Dog[] dogs = new Dog[]{new Dog("1", 1), new Dog("2", 2)};
        ObjectsTest.varParameterTest2(dogs);
    }
}
