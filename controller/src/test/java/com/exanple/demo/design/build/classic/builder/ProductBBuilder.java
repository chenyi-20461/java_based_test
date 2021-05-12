package com.exanple.demo.design.build.classic.builder;

public class ProductBBuilder extends ComplexProductBuilder {



    @Override
    public void buildPartA() {
        complexProduct.setPartA("B");
    }

    @Override
    public void buildPartB() {
        complexProduct.setPartB("B");
    }

    @Override
    public void buildPartC() {
        complexProduct.setPartC("B");
    }


}
