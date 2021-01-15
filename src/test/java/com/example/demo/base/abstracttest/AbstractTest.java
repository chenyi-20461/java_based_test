package com.example.demo.base.abstracttest;

import com.example.demo.domain.model.abstractclass.AbstractAnimal;
import com.example.demo.domain.model.abstractclass.animalImpl.GoodDog;

/**
 * 抽象类测试
 */
public class AbstractTest {
    /**
     * 抽象类测试实例化.
     * <p>
     * 即使没有抽象方法也不能实例化，必须要有方法类体
     */
    public void test() {
        AbstractAnimal abstractAnimal = new AbstractAnimal() {
        };
        AbstractAnimal abstractAnimal1 = new GoodDog();

    }
}
