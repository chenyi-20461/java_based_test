package com.example.demo.base;

import com.example.demo.domain.model.son.Son;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LogTest {
    /**
     * {}只是能占位
     * 用，能打出栈信息
     */
    @Test
    public void testLog(){
        Son son = new Son();
        son.setName("zhangSan");
        log.info("son:{}",son);
        log.info("son"+son);
        try {
            Integer a = null;
            System.out.println(a.toString());
        }catch (Exception e){
            log.debug("异常",e);
            log.debug("异常"+e);
        }
    }
}
