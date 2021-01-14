package jsontest;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.model.jsontest.JsonTestOne;
import org.junit.jupiter.api.Test;

public class JsonTest {
    /**
     * json转换转换内部静态类
     *
     * 结论能转换静态类
     */
    @Test
    public  void testOne() {
        String t = "{\"name\":\"张三\",\"jsonTestTwo\":{\"gentle\":\"女\"}}";
        JsonTestOne jsonTestOne = JSON.parseObject(t,JsonTestOne.class);
        System.out.println(jsonTestOne);
    }
}
