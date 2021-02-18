package com.example.demo.domain.model;

import lombok.Data;

/**
 * class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>
 * @param <T>
 * @param <S>
 */
@Data
public class Generic<T, S extends T> {
    private T t1;
    private S s1;

    public <A, B> A testGeneric(A a, B b) {
        if (a instanceof Person) {
            System.out.println(((Person) a).getAge());
            System.out.println(((Person) b).getName());
        }
        return a;
    }

    public void testQuestion(Generic<?, ?> generic) {
        if (generic.getT1() instanceof Person) {
            System.out.println(((Person) generic.getT1()).getAge());
        }
    }

    public void testQuestion2(Generic<T, S> generic) {
        if (generic.getT1() instanceof Person) {
            System.out.println(((Person) generic.getT1()).getAge());
        }
    }
}
