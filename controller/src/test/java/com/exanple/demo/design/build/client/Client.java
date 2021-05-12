package com.exanple.demo.design.build.client;

import com.exanple.demo.design.build.builder.ComplexProductBuilder;
import com.exanple.demo.design.build.builder.ProductABuilder;
import com.exanple.demo.design.build.commander.old.Commander;
import org.junit.Test;

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
