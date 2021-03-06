package com.example.demo.domain.model;

import com.example.demo.domain.model.son.Son;
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
    private Son son;

    @Tolerate
    public BuilderPerson() {

    }



}
