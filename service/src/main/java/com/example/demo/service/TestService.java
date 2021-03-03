package com.example.demo.service;

import com.example.demo.command.EasyCommand;
import com.example.demo.command.TestCommand;
import com.example.demo.vo.EasyVo;

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
     *
     * @param a 参数字符串
     * @return
     */
    String doTestString(String a);

    /**
     * 测试复杂参数.
     *
     * @param easyCommand 简单命令
     * @return 简单返回结果
     */
    EasyVo doEasyCommand(EasyCommand easyCommand);
}
