package com.example.demo.optional;

import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;


@NoArgsConstructor
@AllArgsConstructor
public class OptionalTest {
    private String name;

        /**
     * 优化空指针.
     */
    @Test
    public void test1() {
        Person person = new Person();
        person.setAge(12);
        System.out.println(person.getAge());
    }

}
