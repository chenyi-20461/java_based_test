package com.example.demo.lambok.model.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PROTECTED)
public class BaseSuperBuildTestModel {
    private String name;
    private String tramp;
}
