package com.exanple.demo.design.build.think.impl;

import com.exanple.demo.design.build.classic.builder.ProductABuilder;
import com.exanple.demo.design.build.think.ComplexProductCommander;
import com.exanple.demo.design.build.classic.product.ComplexProduct;

public class ProductACommander implements ComplexProductCommander {

    @Override
    public ComplexProduct getComplexProduct() {
        ProductABuilder productABuilder = new ProductABuilder();
        return productABuilder.getComplexProduct();
    }
}
