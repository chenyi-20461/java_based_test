package com.example.demo.constant;

import lombok.Getter;

/**
 * 有属性的枚举类
 */
@Getter
public enum AttributeEnum {
    /**
     * 西瓜.
     */
    WATERMELON("西瓜"),
    /**
     * 苹果.
     */
    apple("apple1"),
    /**
     * 香蕉.
     */
    banana("banana1");

    private String name1;

    AttributeEnum(String name){
        this.name1 = name;
    }

}
