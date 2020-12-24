package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Person {
    private String name;
    private Integer age;
//    Person(String name, String age){}
    private BuilderPerson builderPerson;

}
