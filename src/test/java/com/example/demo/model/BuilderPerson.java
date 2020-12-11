package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * 测试@data和@builder连用的@toletate的作用
 */

@Builder
@Data
public class BuilderPerson {
    private String name;
    private Integer age;

    @Tolerate
    public BuilderPerson() {

    }

}
