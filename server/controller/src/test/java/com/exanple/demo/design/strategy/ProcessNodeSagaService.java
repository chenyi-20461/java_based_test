package com.exanple.demo.design.strategy;

import com.example.demo.command.EasyCommand;
import com.example.demo.constant.TestEnum;
import com.example.demo.vo.EasyVo;

/**
 * 这个集合了策略和做事的接口.
 */
public interface ProcessNodeSagaService {
    /**
     * 组合实现功能
     * @param processCommand cmd包含日志信息
     * @return ProcessStatus
     */
    default EasyVo execCommand(EasyCommand processCommand) {
        throw new RuntimeException("组合处理processEvent功能没有实现");
    }


    /**
     * 进行处理事件
     * @param processCommand cmd包含日志信息
     */
    default void execNode(EasyCommand processCommand) {
        throw new RuntimeException("processEvent处理功能没有实现");
    }

    /**
     * 判断使用哪种service相当于工厂。
     * @param testEnum 不同枚举对应不同service
     * @return true使用false不使用
     */
    Boolean support(TestEnum testEnum);

}
