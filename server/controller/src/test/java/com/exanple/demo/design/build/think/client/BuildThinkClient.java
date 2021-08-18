package com.exanple.demo.design.build.think.client;

import com.exanple.demo.design.build.classic.product.ComplexProduct;
import com.exanple.demo.design.build.think.builder.ThinkProductBuilder;
import com.exanple.demo.design.build.think.builder.impl.ThinkProductABuilderImpl;
import org.junit.jupiter.api.Test;


public class BuildThinkClient {
    /**
     * 测试客户端手写builder模式.
     */
    @Test
    public void test1() {
        ThinkProductBuilder thinkProductBuilder = new ThinkProductABuilderImpl();
        ComplexProduct complexProduct = thinkProductBuilder.buildPartA("1").buildPartB("2").buildPartC("3").getCompleteProduct();
        System.out.println(complexProduct);
    }
}
