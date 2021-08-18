package com.exanple.demo.design.build.classic.old;

import com.exanple.demo.design.build.classic.builder.ComplexProductBuilder;
import com.exanple.demo.design.build.classic.product.ComplexProduct;

/**
 * 指挥者
 */
public class Commander {
    private ComplexProductBuilder complexProductBuilder;

    public Commander(ComplexProductBuilder complexProductBuilder) {
        this.complexProductBuilder = complexProductBuilder;
    }

    public ComplexProduct getComplexProduct() {
        return complexProductBuilder.getCompleteProduct();
    }
}
