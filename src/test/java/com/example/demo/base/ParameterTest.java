package com.example.demo.base;

import com.example.demo.domain.model.Generic;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.son.Son;
import com.example.demo.domain.model.son.grandson.GrandSon;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 参数类型和“...”三个点之间不必须有一个空格（Object ...os），Object...os也不会报错误；
 * 可变长度参数列表这个参数必须是参数列表中的最后一个参数，不然会报错
 * <p>
 * class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>
 * <p>
 * //静态方法 使用泛型,只能声明为泛型方法,无法依托于泛型类,因为静态方法早于类编译
 */
//public class ParameterTest<X> {
public class ParameterTest {
//    private X key;

    /**
     * @param a
     * @param objects 有空格写法
     * @return
     */
    public static int varParameterTest(int a, Object... objects) {
        System.out.println("参数个数：" + a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + (int) o);
            }
        });
        return a;
    }

    /**
     * 泛型测试定义方法
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示
     */
    public static <T> int testGeneric(int a, T... objects) {
        System.out.println("参数个数：" + a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + o);
            }
        });
        return a;
    }

    public static <T, S extends T> int testGeneric1(int a, S s1, T... objects) {
        System.out.println(s1);
        System.out.println("参数个数：" + a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + o);
            }
        });
        return a;
    }

    /**
     * 其实是属于非泛型方法
     * @param key
     */
//    public ParameterTest(X key) {
//        this.key = key;
//    }

    /**
     * @param a
     * @param objects 无空格写法
     * @return
     */
    public static int varNoSpace(int a, Object... objects) {
        System.out.println("参数个数：" + a);
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + (int) o);
            }
        });
        return a;
    }

    /**
     * 测试可变长度参数，有空格
     */
    @Test
    public void testParameter() {
//        一个参数
        ParameterTest.varParameterTest(1);
//        两个参数
        ParameterTest.varParameterTest(2, 3);
//        多个参数,非数组写法
        ParameterTest.varParameterTest(2, 3, 4);
//        多个参数，数组写法
        Object[] x = {1, 2, 3};
        ParameterTest.varParameterTest(2, x);
    }

    /**
     * 测试可变长度参数，无空格
     */
    @Test
    public void testNoSpace() {
//        一个参数
        ParameterTest.varParameterTest(1);
//        两个参数
        ParameterTest.varParameterTest(2, 3);
//        多个参数,非数组写法
        ParameterTest.varParameterTest(2, 3, 4);
//        多个参数，数组写法
        Object[] x = {1, 2, "11"};
        ParameterTest.varParameterTest(2, x);
    }


    /**
     * 泛型测试方法
     */
    @Test
    public void testGeneric1() {
//        多个参数，数组写法
        Object[] x = {1, 2, "11"};
        ParameterTest.varParameterTest(2, x);
        System.out.println("========");
        ParameterTest.testGeneric(2, x);
    }

    /**
     * @param objects 有空格写法
     * @return
     */
    public static int varParameterTest1(Object... objects) {
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + (int) o);
            }
        });
        return 1;
    }

    /**
     * 泛型测试定义方法
     */
    public static <T> int testGeneric1(T... objects) {
        Stream.of(objects).forEach(o -> {
            if (o instanceof Integer) {
                System.out.println("数组:" + o);
            }
        });
        return 1;
    }

    /**
     * 测试单个参数
     * <p>
     * Object范围非常广，而T从一开始就会限定这个类型（包括它可以限定类型为Object）。
     * Object由于它是所有类的父类，所以会强制类型转换，而T从一开始在编码时（注意是在写代码时）就限定了某种具体类型，所以它不用强制类型转换。（之所以要强调在写代码时是因为泛型在虚拟机中会被JVM擦除掉它的具体类型信息，这点可参考泛型，在这里不做引申）
     * <p>
     * T...就是object[],如果传参非object[]就会参数组成一个object[]
     */
    @Test
    public void testOneParam() {
        //        多个参数，数组写法
        int[] x = {1, 2, 3};
        ParameterTest.varParameterTest1(x);
        System.out.println("========");
        ParameterTest.testGeneric1(x);
        System.out.println("大哥不容易啊");
        Object[] x1 = {1, 2, 3};
        ParameterTest.varParameterTest1(x1);
        System.out.println("========");
        ParameterTest.testGeneric1(x1);
    }

    /**
     * 测试泛型类
     */
    @Test
    public void testGeneric() {
        Generic<Person, Son> generic = new Generic<>();
        generic.setT1(Person.builder().age(12).build());
        generic.setS1(Son.builder().sonName("zhangSan").build());
        System.out.println("泛型类测试"+generic.getS1().getName()+generic.getT1().getAge());
    }

    /**
     * 泛型类问号测试
     */
    @Test
    public void testQuestionMark(){
        Generic<Person , Son> generic = new Generic<>();
        /*
        * ？号泛指
        * 可以传入不同的generic*/
        Generic<Person , Son> generic1 = new Generic<>();
        generic1.setT1(Person.builder().age(12).build());
        generic1.setS1(Son.builder().sonName("zhangSan").build());
        Generic<Son, GrandSon> generic2 = new Generic<>();
        generic2.setT1(Son.builder().sonName("zhangSan1").age(13).build());
        generic2.setS1(GrandSon.builder().GrandSonName("孙子").build());
        generic.testQuestion(generic1);
        generic.testQuestion(generic2);
        /*
        * 不使用？如果初始化就会指定类型
        * 应该是不能行的*/
        generic.testQuestion2(generic1);
        /*
        * 下面为出错代码*/
//        generic.testQuestion2(generic2);
    }

}
