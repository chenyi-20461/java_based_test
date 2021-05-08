package com.exanple.demo.design.build.product;

import lombok.Data;

/**
 * 复杂产品由三部分构成.
 */
@Data
public class ComplexProduct {

    private String partA;

    private String partB;

    private String partC;
}
