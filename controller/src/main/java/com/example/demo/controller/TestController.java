package com.example.demo.controller;

import com.example.demo.domain.command.TestCommand;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    /**
     * 测试boolean能不能用int和string转换
     *
     * @param testCommand 测试command
     * @return 结果int1可以转化为true，而字符串需要“true”和”false“才能1识别
     */
    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String test(@RequestBody TestCommand testCommand) {
       return testService.doTestBoolean(testCommand);
    }

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String testGet(@RequestParam String a) {
        return testService.doTestString(a);
    }
}
