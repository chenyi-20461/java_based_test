package com.example.demo.controller;

import com.example.demo.command.EasyCommand;
import com.example.demo.command.TestCommand;
import com.example.demo.vo.EasyVo;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public String test(@RequestBody TestCommand testCommand) {
        return testService.doTestBoolean(testCommand);
    }

    /**
     * 用类测试普通get.
     *
     * @param a 参数字符串
     * @return 字符串
     */
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String testGet(@RequestParam String a) {
        return testService.doTestString(a);
    }

    /**
     * get测试PathVariable.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test3/{id}", method = RequestMethod.GET)
    public String testGetPath(@PathVariable("id") String id) {
        return testService.doTestString(id);
    }

    /**
     * get测试command.
     *
     * @param easyCommand 简单命令
     * @return 简单结果
     */
    @RequestMapping(value = "/test4/{id}", method = RequestMethod.GET)
    public EasyVo testGetCommand(@PathVariable("id") String id, EasyCommand easyCommand) {
        System.out.println(id);
        return testService.doEasyCommand(easyCommand);
    }

    /**
     * get传body.
     *
     * @param id id.
     * @return 简单返回
     */
    @RequestMapping(value = "/test5/{id}", method = RequestMethod.GET)
    public EasyVo testGetBody(@PathVariable("id") String id, @RequestBody EasyCommand easyCommand) {
        System.out.println(id);
        return testService.doEasyCommand(easyCommand);
    }
}
