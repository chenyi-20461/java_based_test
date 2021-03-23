package com.example.lambok.model;

import lombok.Data;

@Data
public class SetModelTest {
    private String name;
    private String tramp;

    /**
     * 同包能访问protect属性.
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        NoSetModelTest noSetModel = new NoSetModelTest();
        noSetModel.setName("清子");
        noSetModel.setTramp("阿花");
        System.out.println(noSetModel);
    }

}
