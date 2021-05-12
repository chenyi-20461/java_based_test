package com.exanple.demo.design.build.commander.old;

import com.exanple.demo.design.build.builder.ComplexProductBuilder;
import com.exanple.demo.design.build.product.ComplexProduct;

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
