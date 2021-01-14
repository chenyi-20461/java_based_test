package com.example.demo.domain.model.jsontest;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * json转换的内部
 */
@Data
@Builder
public class JsonTestOne {
    @Tolerate
    protected JsonTestOne() {

    }

    private String name;

    private JsonTestTwo jsonTestTwo;

    @Data
    public static class JsonTestTwo {
        private String gentle;
    }
}
