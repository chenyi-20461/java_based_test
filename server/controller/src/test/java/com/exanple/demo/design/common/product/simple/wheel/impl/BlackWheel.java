package com.exanple.demo.design.common.product.simple.wheel.impl;

import com.exanple.demo.design.common.product.simple.wheel.Wheel;

public class BlackWheel implements Wheel {
    @Override
    public void wheeled() {
        System.out.println("装上了黑色轮子");
    }
}
