package com.example.demo.service;

import com.example.demo.domain.command.TestCommand;

public interface TestService {
    /**
     * 测试server能不能注入.
     *
     * @param testCommand
     * @return 返回测试字符串
     */
    String doTestBoolean(TestCommand testCommand);

    /**
     * 测试字符串.
     * @param a 参数字符串
     * @return
     */
    String doTestString(String a);
}
