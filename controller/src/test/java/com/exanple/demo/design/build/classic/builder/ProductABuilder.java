package com.exanple.demo.design.build.classic.builder;

public class ProductABuilder extends ComplexProductBuilder{

    @Override
    public void buildPartA() {
        complexProduct.setPartA("A");
    }

    @Override
    public void buildPartB() {
        complexProduct.setPartB("A");
    }

    @Override
    public void buildPartC() {
        complexProduct.setPartC("A");
    }

}
