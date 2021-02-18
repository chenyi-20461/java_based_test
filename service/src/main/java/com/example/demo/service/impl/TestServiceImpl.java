package com.example.demo.service.impl;

import com.example.demo.domain.command.TestCommand;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * 用于测试前端传入的boolean值.
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String doTestBoolean(TestCommand testCommand) {
        return testCommand.getA() ? "你输入了正确的数字" + testCommand.getA()
                : "你输入了错误的数字" + testCommand.getA();
    }
}
