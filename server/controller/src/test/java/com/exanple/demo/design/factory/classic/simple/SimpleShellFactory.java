package com.exanple.demo.design.factory.classic.simple;

import com.exanple.demo.design.common.product.simple.shell.Shell;
import com.exanple.demo.design.common.product.simple.shell.impl.BlueShell;
import com.exanple.demo.design.common.product.simple.shell.impl.RedShell;

/**
 * 简单外壳工厂.
 */
public class SimpleShellFactory {
    public static Shell getShell(SimpleShellEnum simpleShellEnum) {
        switch (simpleShellEnum) {
            case redShell:
                return new RedShell();
            case blueShell:
                return new BlueShell();
            default:
                return null;
        }
    }
}
