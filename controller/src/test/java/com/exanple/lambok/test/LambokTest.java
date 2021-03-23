package com.exanple.lambok.test;

import com.example.demo.model.Person;
import com.example.demo.model.son.Son;
import com.example.demo.testmodel.classinherit.Dad;
import com.example.demo.testmodel.classinherit.Uncle;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * lambok的测试
 */
public class LambokTest {
    /**
     * list
     * list能改变
     */
    @Test
    public void testList() {
        List newList = new ArrayList();
        List list = new ArrayList();
        list.add("1");
        list.forEach(a -> newList.add(1));
        System.out.println(newList);

        AtomicReference<Boolean> JudgeAuth = new AtomicReference<>(false);
        list.forEach(a -> {
            if ("1".equals(a)) {
                JudgeAuth.set(true);
            }
        });
        System.out.println(JudgeAuth.get());
    }


    /**
     * 默认的buildDefault来构建默认值
     */
    @Test
    public void testBuildDefault() {
        Person person = Person.builder().build();
        System.out.println(person.getName());
        Person person1 = new Person();
        System.out.println("普通构造：" + person1.getName());
    }

    /**
     * 测试父子类的测试.
     * 结果：
     * 父类与子类都加上这个注解才能用build模式
     */
    @Test
    public void testSuperBuilder() {
        Person person = Person.builder().age(13).build();
        Son son = Son.builder().sonName("11").build();
        System.out.println(person + "||" + son);
    }

    /**
     * 子类必须有独有属性，是否报错.
     * <p>
     * 子类无属性 new出来报错
     * <p>
     * Error:(13, 1) java: 已在类 com.example.demo.com.example.demo.domain.testmodel.classinherit.Uncle中定义了构造器 Uncle()
     */
    @Test
    public void testAttribute() {
        Uncle uncle = new Uncle();
    }

    /**
     * 子类必须有独有属性，是否报错.
     * <p>
     * 子类无属性 build报错
     * <p>
     * Error:(13, 1) java: 已在类 com.example.demo.com.example.demo.domain.testmodel.classinherit.Uncle中定义了构造器 Uncle()
     */
    @Test
    public void testAttribute1() {
        Uncle uncle = Uncle.builder().build();
    }

    /**
     * @SneakyThrows.
     * @SneakyThrows就是为了消除模板话的try catch代码
     * 编译后的代码
     * @Test public void testAttribute2() {
     * try {
     * Uncle var1 = Uncle.builder().build();
     * } catch (Throwable var2) {
     * throw var2;
     * }
     * }
     */
    @SneakyThrows
    @Test
    public void testAttribute2() {
        Uncle uncle = Uncle.builder().build();
    }

    /**
     * 测试父类构造器.
     * 必须都要superBuild
     */
    @Test
    public void testFather() {
        System.out.println(Dad.builder().name("11").build());
    }


}
