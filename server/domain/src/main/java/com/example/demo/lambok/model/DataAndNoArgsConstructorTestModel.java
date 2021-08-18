package com.example.demo.lambok.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试data和NoArgsConstructor连用.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DataAndNoArgsConstructorTestModel {
    private String name;
    private String tramp;

    public static void main(String[] args) {
        DataAndNoArgsConstructorTestModel dataAndNoArgsConstructorTestModel = new DataAndNoArgsConstructorTestModel();
        dataAndNoArgsConstructorTestModel.setName("1");
        System.out.println(dataAndNoArgsConstructorTestModel);
    }
}
