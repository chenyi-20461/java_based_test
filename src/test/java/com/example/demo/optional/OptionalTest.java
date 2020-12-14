package com.example.demo.optional;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

/**
 * 测试optional
 */
public class OptionalTest {
    private String name;

    /**
     * 优化空指针.
     */
    @Test
    public void test1() {
        Person person = new Person();
        person.setAge(12);
        if (Objects.nonNull(person)) {
            System.out.println(person.getAge());
        }
//        优化
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        Integer name = optionalPerson.map(a -> a.getAge()).get();
        System.out.println(name);
    }

}
