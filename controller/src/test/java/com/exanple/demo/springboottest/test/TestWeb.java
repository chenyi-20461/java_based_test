package com.exanple.demo.springboottest.test;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Application;
import com.example.demo.vo.EasyVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * 测试springBootTest接口
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWeb {
    /**
     * Spring boot 获取当前启动端口和IP.
     */
    @LocalServerPort
    private int port;

    /**
     * 当前环境.
     */
    @Autowired
    Environment environment;

    @Value("${local.server.port}")
    private String port1;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * 获取端口三种方式.
     */
    @Test
    public void testPort() {
        System.out.println("port:" + port + "\n" + "port1:" + port1 + "\n" + "environment.port:" + environment.getProperty("local.server.port"));
    }

    /**
     * 获取ip.
     */
    @Test
    public void testIp() throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
    }

    /**
     * Java中，%d和%f分别用来表示输出时，替换整型输出和浮点型输出的占位符.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    /**
     * post方式发送json体.
     *
     * @throws Exception
     */
    @Test
    public void postTest() throws Exception {
        HashMap<String, Integer> jsonObject = new HashMap<>();
        jsonObject.put("a", 1);
        ResponseEntity<String> response = restTemplate.postForEntity(
                this.base.toString() + "/test/test1", jsonObject, String.class);
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }

    /**
     * get方式发送请求.
     */
    @Test
    public void getTest() {
        HashMap hashMap = new HashMap();
        hashMap.put("a", "111");
//        直接写路径
        ResponseEntity<String> a = restTemplate.getForEntity(this.base.toString() + "/test/test2?a=1", String.class);
//        用getForObject
        String b = restTemplate.getForObject(this.base.toString() + "/test/test2?a=1", String.class);
        System.out.println(a.getBody());
        System.out.println("b为" + b);
    }

    /**
     * get的占位符.
     */
    @Test
    public void getPathTest() {
//        占位符
        String b = restTemplate.getForObject(this.base.toString() + "/test/test3/{id}", String.class, "张三");
        System.out.println(b);
    }

    /**
     * get的传多个参数.
     */
    @Test
    public void getTestMultiple() {
        HashMap<String, Object> map = new HashMap();
        map.put("string", "222");
        map.put("integer", 111);
        map.put("bigDecimal", new BigDecimal("1.11111111111"));
        map.put("booleanCommand", false);
        map.put("id", "张三");
//        占位符
        EasyVo b = restTemplate.getForObject(this.base.toString() + "/test/test4/{id}?string={string}&integer={integer}&bigDecimal={bigDecimal}&booleanCommand={booleanCommand}", EasyVo.class, map);
        System.out.println(JSONObject.toJSONString(b));
    }

    /**
     * get的传body体.
     */
    @Test
    public void getTestBody() {
        HashMap<String, Object> map = new HashMap();
        map.put("string", "222");
        map.put("integer", 111);
        map.put("bigDecimal", new BigDecimal("1.11111111111"));
        map.put("booleanCommand", false);
        map.put("id", "张三");
//        占位符
        EasyVo b = restTemplate.getForObject(this.base.toString() + "/test/test4/{id}?string={string}&integer={integer}&bigDecimal={bigDecimal}&booleanCommand={booleanCommand}", EasyVo.class, map);
        System.out.println(JSONObject.toJSONString(b));
    }

    /**
     * get
     */
    /**
     * 传头指针.
     */
    @Test
    public void testHead() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject param = new JSONObject();
        param.put("username", "123");
        param.put("a", 1);
        HttpEntity<JSONObject> formEntity = new HttpEntity<>(param, headers);
        String result = restTemplate.postForObject(base.toString() + "/test/test1", formEntity, String.class);
        System.out.println(result);
    }


}
