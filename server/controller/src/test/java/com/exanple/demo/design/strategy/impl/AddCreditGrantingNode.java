package com.exanple.demo.design.strategy.impl;

import com.example.demo.command.EasyCommand;
import com.example.demo.constant.TestEnum;
import com.example.demo.service.TestService;
import com.exanple.demo.design.strategy.ProcessNodeSagaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(4)
@Slf4j
public class AddCreditGrantingNode implements ProcessNodeSagaService {
    @Autowired
    private TestService testService;

    @Override
    public void execNode(EasyCommand processCommand) {
    }

    @Override
    public Boolean support(TestEnum eventEnum) {
        return TestEnum.FANG_XUN_TONG.equals(eventEnum);
    }

}
