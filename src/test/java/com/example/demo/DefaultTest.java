package com.example.demo;
@FunctionalInterface
public interface DefaultTest {
    default void test1(String a){
        System.out.println(a);
    }
    default void test2(String a){
        System.out.println(a);
    }
    static  void test3(String a){
        System.out.println(a);
    }
    void test4();
}
