package com.example.demo.product.impl;

import com.example.demo.product.Shape;

import java.math.BigDecimal;

/**
 * 圆形.
 * 产品类扩展的一个等级.
 */
public abstract class Circle implements Shape {

    /**
     * 直径.
     */
    private BigDecimal diameter;
}
