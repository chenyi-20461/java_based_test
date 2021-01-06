package com.example.demo.domain.model.son;

import com.example.demo.domain.model.Person;

/**
 * 当父类没有默认构造方法时时无法构造的，
 * 1.当有参构造覆盖无参构造
 * 2.直接私有化无参构造
 */
public class Son extends Person {
    private String sonName;
    public static void main(String[] args) {
        System.out.println(new Son());
    }

    /**
     * 接口测试
     */
    public void interTest(int param1,int param2){
        System.out.println(1);
    }
}
