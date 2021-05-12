package com.exanple.demo.design.build.think;

import com.exanple.demo.design.build.classic.product.ComplexProduct;

public interface ComplexProductCommander {
    /**
     * 获取产品.
     * @return ComplexProduct 产品.
     */
    ComplexProduct getComplexProduct();
}
