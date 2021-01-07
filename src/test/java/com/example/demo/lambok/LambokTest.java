package com.example.demo.lambok;

import com.example.demo.domain.model.Person;
import org.junit.jupiter.api.Test;

/**
 * lambok的测试
 */
public class LambokTest {
    /**
     * 默认的buildDefault来构建默认值
     */
    @Test
    public void testBuildDefault(){
        Person person = Person.builder().build();
        System.out.println(person.getName());
        Person person1 = new Person();
        System.out.println("普通构造："+person1.getName());
    }
}
