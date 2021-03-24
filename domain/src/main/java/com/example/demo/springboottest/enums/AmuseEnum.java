package com.example.demo.springboottest.enums;

/**
 * 娱乐枚举.
 */
public enum AmuseEnum {
    /**
     * 玩手机.
     */
    mobile("mobile"),
    /**
     * 吃.
     */
    eat("eat");

    private String amuseString;

    AmuseEnum(String amuseString) {
        this.amuseString = amuseString;
    }
}
