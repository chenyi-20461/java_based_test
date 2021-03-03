package demo.jsontest;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Person;
import com.example.demo.model.compare.Dog;
import com.example.demo.model.jsontest.JsonTestOne;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
