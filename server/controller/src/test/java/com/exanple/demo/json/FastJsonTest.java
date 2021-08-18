package com.exanple.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.vo.EasyVo;
import org.junit.jupiter.api.Test;


import java.util.Map;

public class FastJsonTest {
    /**
     * 测试能不能解析两次.
     */
    @Test
    public void testOne(){
        String a = "[{\"name\":\"批发和零售业\",\"groupItemCode\":\"IndustryClassification_6\"},{\"name\":\"零售业\",\"groupItemCode\":\"IndustryClassification_0602\"}]";
        JSONArray jsonArray = JSON.parseArray(a);
        String parseString = ((Map<String, String>) jsonArray.get(1)).get("name");
        System.out.println(parseString);
    }

    /**
     * 测试属性为空的字符串.
     * 当属性为空时不会解析字符串
     */
    @Test
    public void testTwo(){
        EasyVo easyVo = new EasyVo();
        easyVo.setBigDecimalResults(null);
        System.out.println(JSON.toJSONString(easyVo));
        EasyVo easyVo1 = JSON.parseObject(JSON.toJSONString(easyVo),EasyVo.class);
        System.out.println(easyVo.getBigDecimalResults());
    }
}
