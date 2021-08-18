package com.example.demo.lambok.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter(lombok.AccessLevel.PROTECTED)
@Builder(access = lombok.AccessLevel.PROTECTED)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BuildTestModel {
    private String name;
    private String tramp;

    public static BuildTestModel buildByNameAndTramp(String name, String tramp) {
        return BuildTestModel.builder()
                .name(name)
                .tramp(tramp)
                .build();
    }
}
