package com.exanple.demo.design.build.think.builder;

import com.exanple.demo.design.build.product.ComplexProduct;

public abstract class ThinkProductBuilder {

    protected ComplexProduct complexProduct = new ComplexProduct();

    /**
     * 构建部分A.
     * @param a 参数a部分
     * @return 产品 为了让写法更和谐
     */
    public abstract ThinkProductBuilder buildPartA(String a);

    /**
     * 构建部分B.
     * @param b 参数a部分
     * @return 产品
     */
    public abstract ThinkProductBuilder buildPartB(String b);

    /**
     * 构建部分c.
     * @param c 参数a部分
     * @return 产品
     */
    public abstract ThinkProductBuilder buildPartC(String c);


    public ComplexProduct getComplexProduct() {
        return complexProduct;
    }

    public ComplexProduct getCompleteProduct() {
        return complexProduct;
    }

}
