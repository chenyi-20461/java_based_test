package com.example.demo.lambda;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.son.Son;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LamTest {
    /**
     * 不可以使用变量在lambda表达式当中
     * <p>
     * 只要变量在当前方法只赋值一次（）（有可能是栈释放了）
     */
    @Test
    public void testVariable(String b) {
        String a = b;
//		a = "1";
        String x = Optional.ofNullable(a)
                .map(s -> s + s)
                .map(s -> s + a)
                .orElse("1");
        System.out.println(x);
    }

    @Test
    public void testVariable1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的数字");
        List arrayList = Arrays.asList("1", "2");
        arrayList.forEach(a -> testVariable((String) a));
    }

    /**
     * 测试方法的简单写法
     * <p>
     * 引用对象的实例方法	Object::instanceMethodName
     * 引用类的静态方法	ClassName::staticMethodName
     * 引用类的实例方法	ClassName::methodName
     * 引用构造方法	ClassName::new
     * <p>
     * 结论：
     * 一共三种方法：
     * 类::静态方法 必须参数返回值类型一样
     * 类::非静态方法(默认把this作为第一个参数)
     * 实例对象::非静态方法 必须参数返回值类型一样
     */
    @Test
    public void testWay() {
        Person person = new Person();
        person.setAge(12);
        System.out.println(Optional.ofNullable(person).map(Person::getAge).get());
        Function<Person, Object> function = Person::getAge;
        Consumer<Person> consumer = Person::testWay;
        Consumer<Person> consumer2 = Person::testStaticWay;
        Consumer<Person> consumer4 = person::testNormalWay;
        /*等价于下一行*/
        Consumer<Person> consumer1 = (person2 -> person2.testWay());
        consumer.accept(person);
        person.getAge();
        System.out.println("函数测试" + function.apply(person));
    }

    @FunctionalInterface
    interface MyInter {
        void d(Son d, int param1, int param2);
    }

    /**
     * 第一点：接口方法的参数比引用方法的参数多一个
     * 第二点：接口方法的第一个参数恰巧是调用引用方法的对象（其引用方法所在类或其父类的实例）?
     * 原因猜想
     * 父类有的子类一定有。而子类有的父类不一定有。所以子类要调用方法和使用的时候它是绝对可以实现的。
     */
    @Test
    public void testClass() {
        MyInter myInter = Person::InterT;
        myInter.d(new Son(), 1, 1);
    }

    /**
     * foreach测试
     * <p>
     * 测试foreach,当你不指定foreach的泛型的时候，就是
     * default void forEach(Consumer<? super T> action) {
     * Objects.requireNonNull(action);
     * for (T t : this) {
     * action.accept(t);
     * }
     * 此时t为object，lambda表达式映射时才能正确完成
     * 指定泛型才能够lambda表达式映射成功
     */
    @Test
    public void testForeach() {
        Person person = new Person();
        Person person1 = new Person();
        person1.setAge(13);
        List<Person> a = new ArrayList();
        a.add(person);
        a.add(person1);
        a.forEach(Person::testWay);
//        List b = new ArrayList();
//        b.add(person);
//        b.add(person1);
//        b.forEach(Person::testStaticWay);
//        错误写法
    }


    /**
     * test UnaryOperator<T>
     * <p>
     * 返回一个始终返回输入参数的一元操作符.
     * 结果是输入什么，就输出什么.
     */
    @Test
    public void testUnaryOperator() {
        UnaryOperator<Integer> unaryOperator = a -> a + 1;
        UnaryOperator<Integer> unaryOperator1 = UnaryOperator.identity();
        System.out.println("测试identity方法:" + unaryOperator1.apply(1));
        System.out.println("普通UnaryOperator" + unaryOperator.apply(1));
    }


}
