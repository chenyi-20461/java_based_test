package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map has = new HashMap();
        has.put("1", null);
        System.out.println(has.get("1"));
        System.out.println(has.get(null));
    }

    /**
     * 不能手写map，toString的是表面，实际应该是数组加链表
     * 结果应该是错误
     */
    @Test
    void writeMap() {
        Object a = "{\"a\" = \"3\"}";
//        由于它有他的数据结构
        Map map = new HashMap();
        map.put("2", "2");
        System.out.println(map);
        Map b = (Map) a;
        System.out.println(b.get("a"));
    }
}
