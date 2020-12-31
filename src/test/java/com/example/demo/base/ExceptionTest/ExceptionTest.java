package com.example.demo.base.ExceptionTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExceptionTest {
    /**
     * 测试异常的属性
     */
    @Test
    public void testRunningException() {
        RuntimeException runtimeException = new RuntimeException("基础异常测试");
        System.out.println(runtimeException.getMessage());
        throw runtimeException;
    }

    /**
     * 多重catch,一重一重拿，先拿子异常
     * 日志输出可以完全的输出异常
     */
    @Test
    public void testCatch() {
        try {
            RuntimeException runtimeException = new RuntimeException("基础异常测试");
            System.out.println(runtimeException.getMessage());
            throw runtimeException;
        } catch (NullPointerException nullPo) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("捕获到大异常");
            log.info("大异常:" + e); //日志的写法，这样不会打出异常信息
            log.info("输出异常信息:", e); //日志的写法，这样可以打出异常
        }
    }

    @Test
    public void testCheck() throws Exception {
        String a = "1";
        if ("1".equals(a)) {
            throw new RuntimeException("测试异常");
        }
    }

    @Test
    public void getInt() throws Exception {
        testCheck();
        System.out.println(1);
    }


}
