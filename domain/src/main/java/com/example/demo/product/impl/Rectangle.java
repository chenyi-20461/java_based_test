package com.example.demo.product.impl;

import com.example.demo.product.Shape;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 长方形.
 * 产品类扩展的一个等级.
 */
public abstract class Rectangle implements Shape {

    /**
     * 长.
     */
    private BigDecimal length;

    /**
     * 宽.
     */
    private BigDecimal wide;

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(null);
        System.out.println(list.size());
    }

}
