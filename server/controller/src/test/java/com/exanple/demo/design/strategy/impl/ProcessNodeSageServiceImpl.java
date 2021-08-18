package com.exanple.demo.design.strategy.impl;


import com.example.demo.command.EasyCommand;
import com.example.demo.constant.TestEnum;
import com.example.demo.vo.EasyVo;
import com.exanple.demo.design.strategy.ProcessNodeSagaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Slf4j
public class ProcessNodeSageServiceImpl implements ProcessNodeSagaService {
    @Autowired
    private List<ProcessNodeSagaService> processNodeSageServices;


    /**
     * 一二三步，纵向扩展
     * @param processCommand cmd包含日志信息
     * @return
     */
    @Override
    public EasyVo execCommand(EasyCommand processCommand) {
        ProcessNodeSagaService processNodeSagaService = getService(processCommand.getTestEnum());
        processNodeSagaService.execNode(processCommand);
        addWdApplicationComment(processCommand);
        return new EasyVo();
    }


    private void addWdApplicationComment(EasyCommand processCommand) {

    }

    @Override
    public Boolean support(TestEnum processNodeTypeConsts) {
        return false;
    }

    private ProcessNodeSagaService getService(TestEnum processNodeTypeConsts) {
        for (ProcessNodeSagaService service : processNodeSageServices) {
            if (service.support(processNodeTypeConsts)) {
                return service;
            }
        }
        throw new RuntimeException("没有找到processEvent对应服务");
    }
}
