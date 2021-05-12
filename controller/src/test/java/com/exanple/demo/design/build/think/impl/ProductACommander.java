package com.exanple.demo.design.build.think.impl;

import com.exanple.demo.design.build.builder.ProductABuilder;
import com.exanple.demo.design.build.think.ComplexProductCommander;
import com.exanple.demo.design.build.product.ComplexProduct;

public class ProductACommander implements ComplexProductCommander {

    @Override
    public ComplexProduct getComplexProduct() {
        ProductABuilder productABuilder = new ProductABuilder();
        return productABuilder.getComplexProduct();
    }
}
