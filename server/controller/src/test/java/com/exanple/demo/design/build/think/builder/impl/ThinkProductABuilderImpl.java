package com.exanple.demo.design.build.think.builder.impl;

import com.exanple.demo.design.build.think.builder.ThinkProductBuilder;

public class ThinkProductABuilderImpl extends ThinkProductBuilder {

    @Override
    public ThinkProductBuilder buildPartA(String a) {
        complexProduct.setPartA(a);
        return this;
    }

    @Override
    public ThinkProductBuilder buildPartB(String b) {
        complexProduct.setPartB(b);
        return this;
    }

    @Override
    public ThinkProductBuilder buildPartC(String c) {
        complexProduct.setPartC(c);
        return this;
    }
}
