package com.example.demo.base;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 参数类型和“...”三个点之间不必须有一个空格（Object ...os），Object...os也不会报错误；
 * 可变长度参数列表这个参数必须是参数列表中的最后一个参数，不然会报错
 */
public class ParameterTest {
    /**
     *
     * @param a
     * @param objects 有空格写法
     * @return
     */
    public static int varParameterTest(int a, Object... objects) {
        System.out.println("参数个数："+a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:"+(int) o);
            }
        });
        return a;
    }

    /**
     * 泛型测试定义方法
     */
    public static <T> int testGeneric(int a,T... objects){
        System.out.println("参数个数："+a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:"+ o);
            }
        });
        return a;
    }

    /**
     *
     * @param a
     * @param objects 无空格写法
     * @return
     */
    public static int varNoSpace(int a, Object...objects) {
        System.out.println("参数个数："+a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:"+(int) o);
            }
        });
        return a;
    }

    /**
     * 测试可变长度参数，有空格
     */
    @Test
    public void testParameter(){
//        一个参数
        ParameterTest.varParameterTest(1);
//        两个参数
        ParameterTest.varParameterTest(2,3);
//        多个参数,非数组写法
        ParameterTest.varParameterTest(2,3,4);
//        多个参数，数组写法
        Object[] x ={1,2,3};
        ParameterTest.varParameterTest(2,x);
    }

    /**
     * 测试可变长度参数，无空格
     */
    @Test
    public void testNoSpace(){
//        一个参数
        ParameterTest.varParameterTest(1);
//        两个参数
        ParameterTest.varParameterTest(2,3);
//        多个参数,非数组写法
        ParameterTest.varParameterTest(2,3,4);
//        多个参数，数组写法
        Object[] x ={1,2,"11"};
        ParameterTest.varParameterTest(2,x);
    }


    /**
     * 泛型测试方法
     */
    @Test
    public void testGeneric1(){
//        多个参数，数组写法
        Object[] x ={1,2,"11"};
        ParameterTest.varParameterTest(2,x);
        System.out.println("========");
        ParameterTest.testGeneric(2,x);
    }

    /**
     *
     * @param objects 有空格写法
     * @return
     */
    public static int varParameterTest1(Object... objects) {
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:"+(int) o);
            }
        });
        return 1;
    }

    /**
     * 泛型测试定义方法
     */
    public static <T> int testGeneric1(T... objects){
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:"+ o);
            }
        });
        return 1;
    }

    /**
     * 测试单个参数
     *
     * Object范围非常广，而T从一开始就会限定这个类型（包括它可以限定类型为Object）。
     * Object由于它是所有类的父类，所以会强制类型转换，而T从一开始在编码时（注意是在写代码时）就限定了某种具体类型，所以它不用强制类型转换。（之所以要强调在写代码时是因为泛型在虚拟机中会被JVM擦除掉它的具体类型信息，这点可参考泛型，在这里不做引申）
     *
     * T...就是object[],如果传参非object[]就会参数组成一个object[]
     */
    @Test
    public void testOneParam(){
        //        多个参数，数组写法
        int[] x ={1,2,3};
        ParameterTest.varParameterTest1(x);
        System.out.println("========");
        ParameterTest.testGeneric1(x);
        System.out.println("大哥不容易啊");
        Object[] x1 ={1,2,3};
        ParameterTest.varParameterTest1(x1);
        System.out.println("========");
        ParameterTest.testGeneric1(x1);
    }
}
