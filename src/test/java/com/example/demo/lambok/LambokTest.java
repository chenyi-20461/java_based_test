package com.example.demo.lambok;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.son.Son;
import com.example.demo.domain.testmodel.classinherit.Uncle;
import org.junit.jupiter.api.Test;

/**
 * lambok的测试
 */
public class LambokTest {
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
     * Error:(13, 1) java: 已在类 com.example.demo.domain.testmodel.classinherit.Uncle中定义了构造器 Uncle()
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
     * Error:(13, 1) java: 已在类 com.example.demo.domain.testmodel.classinherit.Uncle中定义了构造器 Uncle()
     */
    @Test
    public void testAttribute1() {
        Uncle uncle = Uncle.builder().build();
    }
}
