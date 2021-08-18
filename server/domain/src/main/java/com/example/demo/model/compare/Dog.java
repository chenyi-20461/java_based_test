package com.example.demo.model.compare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Comparable的测试类
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dog implements Comparable {
    /**
     * 名字
     */
    String name;
    /**
     * 年龄
     */
    Integer age;

    @Override
    public int compareTo(Object o) {
        return this.age - ((Dog) o).age;
    }

    public <T,S> T bite(S s){
        System.out.println("泛型方法");
        if (s instanceof String){
            return (T)s;
        }
        return null;
    }

    public <T,S> T bite1(S s){
        System.out.println("泛型方法");
        if (s instanceof String){
            return (T)s;
        }
        return null;
    }
}
