package com.exanple.demo.design.factory.classic.client;

import com.exanple.demo.design.factory.classic.method.ShellMethodFactory;
import com.exanple.demo.design.factory.classic.method.impl.BlueShellMethodFactory;
import com.exanple.demo.design.factory.classic.method.impl.RedShellMethodFactory;
import com.exanple.demo.design.factory.classic.simple.SimpleShellEnum;
import com.exanple.demo.design.factory.classic.simple.SimpleShellFactory;
import org.junit.jupiter.api.Test;


public class FactoryClient {
    /**
     * 测试简单工厂模式.
     */
    @Test
    public void testSimpleFactory(){
        SimpleShellFactory.getShell(SimpleShellEnum.blueShell).SetUp();
        SimpleShellFactory.getShell(SimpleShellEnum.redShell).SetUp();
    }

    /**
     * 测试工厂方法模式.
     */
    @Test
    public void testMethodFactory(){
        ShellMethodFactory blueShellMethodFactory = new BlueShellMethodFactory();
        blueShellMethodFactory.getShell().SetUp();
        ShellMethodFactory redShellMethodFactory = new RedShellMethodFactory();
        redShellMethodFactory.getShell().SetUp();
    }
}
