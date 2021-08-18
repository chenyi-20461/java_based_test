package com.exanple.demo.design.factory.classic.method.impl;

import com.exanple.demo.design.common.product.simple.shell.Shell;
import com.exanple.demo.design.common.product.simple.shell.impl.RedShell;
import com.exanple.demo.design.factory.classic.method.ShellMethodFactory;

public class RedShellMethodFactory implements ShellMethodFactory {

    @Override
    public Shell getShell() {
        return new RedShell();
    }
}
