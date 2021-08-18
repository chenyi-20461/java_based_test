package demo.jsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Person;
import com.example.demo.model.compare.Dog;
import com.example.demo.model.jsontest.JsonTestOne;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonTest {
    /**
     * json转换转换内部静态类
     * <p>
     * 结论能转换静态类
     */
    @Test
    public void testOne() {
        String t = "{\"name\":\"张三\",\"jsonTestTwo\":{\"gentle\":\"女\"}}";
        JsonTestOne jsonTestOne = JSON.parseObject(t, JsonTestOne.class);
        System.out.println(jsonTestOne);
    }

    /**
     * 复制数组相同属性
     */
    @Test
    public void testTwo() {
        List<Dog> list = new ArrayList<>();
        Dog dog = new Dog();
        dog.setName("zhangSan");
        list.add(dog);
        List<Dog> list1 = new ArrayList<Dog>();
        System.out.println(JSON.parseArray(JSON.toJSONString(list), Person.class));
    }

    /**
     * JSON.toJSONString能不能转null
     * 结果：能
     */
    @Test
    public void testThree() {
        Object a = null;
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * JSON的复杂解析
     * 结果：能
     */
    @Test
    public void testComplex() {
        String testJson = "{\n" +
                "        \"ceProductId\": \"187140f1d171400ab0352194b4e76c61\",\n" +
                "        \"ceProductVersion\": \"temp1614823166895\",\n" +
                "        \"personInfo\": {\n" +
                "                \"baseInfo\": {\n" +
                "                        \"base_info_name\": \"李星\",\n" +
                "                        \"base_info_idcard\": \"430426199711099518\",\n" +
                "                        \"base_info_tel\": \"15375162931\"\n" +
                "                }\n" +
                "        },\n" +
                "        \"memberId\": \"\",\n" +
                "        \"sourceId\": \"\",\n" +
                "        \"sourceName\": \"\",\n" +
                "        \"type\": 0,\n" +
                "        \"platformType\": \"1\",\n" +
                "        \"applyInfo\": {\n" +
                "                \"loan_check_fund\": \"60000\",\n" +
                "                \"apply_limit\": \"12\"\n" +
                "        }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(testJson);

        System.out.println(JSON.toJSONString(((Map) JSONObject.parseObject(testJson).get("personInfo")).get("baseInfo")));
        System.out.println((String) ((Map<Object, Object>)((Map)(jsonObject.get("personInfo"))).get("baseInfo")).get("base_info_idcard"));

    }
}
