package com.example.demo.testmodel.classinherit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 爷爷类，根部类
 */
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Data
public class Grandpa {
    private String name;
    private Integer age = 68;
}
