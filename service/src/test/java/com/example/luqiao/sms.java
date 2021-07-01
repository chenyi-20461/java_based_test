package com.example.luqiao;

import com.alibaba.fastjson.JSON;
import com.example.demo.luqiao.model.Submit;
import com.example.demo.luqiao.service.EncryptionService;
import com.example.demo.luqiao.service.impl.EncryptionServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class sms {
    EncryptionService encryptionService = new EncryptionServiceImpl();

    /**
     * 测试短信.
     */
    @Test
    public void testParam() {
        String[] params ={"11"};
        Submit submit = Submit.builder()
                .ecName("浙江台州路桥农村商业银行股份有限公司")
                .apId("zhisy")
                .secretKey("Lqrcb@2021")
                .mobiles("18301751981")
                .sign("SKvcw3q1W")
                .params(JSON.toJSONString(params))
                .addSerial("")
                .templateId("a2995d47e82d431f913f7a1e295e8a1a")
                .build();
        String stringBuffer = submit.getEcName() +
                submit.getApId() +
                submit.getSecretKey() +
                submit.getTemplateId()+
                submit.getMobiles() +
                submit.getParams() +
                submit.getSign() +
                submit.getAddSerial();
        System.out.println(stringBuffer);
        String selfMac = encryptionService.md5Encryption(stringBuffer);
        System.out.println(selfMac);
        submit.setMac(selfMac);
        String param = JSON.toJSONString(submit);
        System.out.println("param:" + param);
        String encode = Base64.encodeBase64String(param.getBytes(StandardCharsets.UTF_8));
        System.out.println("encode:" + encode);
    }

}
