package com.exanple.demo.design.build.classic.builder;

import com.exanple.demo.design.build.classic.product.ComplexProduct;

public abstract class ComplexProductBuilder {

    protected ComplexProduct complexProduct = new ComplexProduct();

    /**
     * 构建部分A.
     */
    public abstract void buildPartA();

    /**
     * 构建部分B.
     */
    public abstract void buildPartB();

    /**
     * 构建部分c.
     */
    public abstract void buildPartC();


    public ComplexProduct getComplexProduct() {
        return complexProduct;
    }

    public ComplexProduct getCompleteProduct() {
        buildPartA();
        buildPartB();
        buildPartC();
        return complexProduct;
    }

}
