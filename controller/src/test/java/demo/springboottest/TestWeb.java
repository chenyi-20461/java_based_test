package demo.springboottest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.DemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.Inet4Address;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 测试springBootTest接口
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWeb {
    /**
     * Spring boot 获取当前启动端口和IP.
     *
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
     *
     */
    @Test
    public void testPort(){
        System.out.println("port:"+port+"\n"+"port1:"+port1+"\n"+"environment.port:"+environment.getProperty("local.server.port"));
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

    @Test
    public void getUserByIdTest() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a",1);
        ResponseEntity<String> response = restTemplate.postForEntity(
                this.base.toString() + "/test/test1",jsonObject,String.class);
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }




}
