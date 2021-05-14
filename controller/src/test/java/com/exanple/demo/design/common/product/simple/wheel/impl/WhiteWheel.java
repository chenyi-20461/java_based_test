package com.exanple.demo.design.common.product.simple.wheel.impl;

import com.exanple.demo.design.common.product.simple.wheel.Wheel;

public class WhiteWheel implements Wheel {
    @Override
    public void wheeled() {
        System.out.println("装上了白色轮子");
    }
}
