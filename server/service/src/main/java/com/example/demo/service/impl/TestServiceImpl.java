package com.example.demo.service.impl;

import com.example.demo.command.EasyCommand;
import com.example.demo.command.TestCommand;
import com.example.demo.vo.EasyVo;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * 用于测试前端传入的boolean值.
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String doTestBoolean(TestCommand testCommand) {
        return testCommand.getLittleBoolean() ? "你输入了正确的数字" + testCommand.getLittleBoolean()
                : "你输入了错误的数字" + testCommand.getLittleBoolean();
    }

    @Override
    public String doTestString(String a) {
        return "good good 杀父弑母为了摆脱控制，觉得父亲就是自己的一堵墙，限制着自己，无法突破自己，最终演化为对父母的憎恨" +
                "\n你输入的字母" + a;
    }

    @Override
    public EasyVo doEasyCommand(EasyCommand easyCommand) {
        System.out.println(1);
//        添加逻辑
        String booleanResults = null;
        if (easyCommand.getBooleanCommand())
            booleanResults = "boolean的结果为true";
        else
            booleanResults = "boolean的结果为false";
//构建返回值
        return EasyVo.builder().bigDecimalResults(easyCommand.getBigDecimal())
                .booleanResults(booleanResults)
                .integerResults(easyCommand.getInteger())
                .stringResults(easyCommand.getString())
                .build();
    }
}
