package com.exanple.demo.design.build.classic.client;

import com.exanple.demo.design.build.classic.builder.ComplexProductBuilder;
import com.exanple.demo.design.build.classic.builder.ProductABuilder;
import com.exanple.demo.design.build.classic.old.Commander;
import org.junit.jupiter.api.Test;


/**
 * 客户端.
 */
public class Client {

    @Test
    public void test1() {
        ComplexProductBuilder complexProductBuilder = new ProductABuilder();
        Commander commander = new Commander(complexProductBuilder);
        System.out.println(commander.getComplexProduct());
    }
}
