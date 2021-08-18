package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Data
public class Person {
    /*
     * 默认值*/
    @Builder.Default
    private String name = "zhangSan";
    private Integer age = 10;
    //    Person(String name, String age){}
    private BuilderPerson builderPerson;

    /**
     * 非静态方法测试
     */
    public void testWay() {
        System.out.println("Person的非静态方法");
    }

    /**
     * 静态方法测试
     */
    public static void testStaticWay(Person person) {
        System.out.println("Person的静态方法");
    }

    /**
     * 普通方法
     */
    public void testNormalWay(Person person) {
        System.out.println("Person的静态方法");
    }

    /**
     * 接口测试
     */
    public void InterT(int param1, int param2) {
        System.out.println(1);
    }

}
