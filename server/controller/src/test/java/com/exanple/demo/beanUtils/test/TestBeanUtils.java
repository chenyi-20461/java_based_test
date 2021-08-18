package com.exanple.demo.beanUtils.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.beanUtils.BeanUtilsAVo;
import com.example.demo.beanUtils.BeanUtilsBVo;
import com.example.demo.beanUtils.BeanUtilsInnerAVo;
import com.example.demo.model.Person;
import com.example.demo.model.son.Son;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TestBeanUtils {

    /**
     * beanUtils的source不能为null.
     */
    @Test
    public void testSon() {
        Person person = Person.builder().name("zs").build();
        Son son = Son.builder().sonName("zs").build();
        BeanUtils.copyProperties(person, son);
        System.out.println(son);
        BeanUtils.copyProperties(null, son);
    }

    /**
     * 能复制父类属性.
     */
    @Test
    public void testSon1() {
        Person person = Person.builder().name("zs").build();
        Son son = Son.builder().sonName("zs").build();
        BeanUtils.copyProperties(person, son);
        System.out.println(son);
    }

    /**
     * 复制list属性
     * beanUtils5.3.7
     * 当两个属性一摸一样（属性名，和属性类）时能复制list.
     * 否者不能
     * 而4.3.17.RELEASE
     *只要属性名一样就可以复制
     */
    @Test
    public void testList() {
        BeanUtilsInnerAVo beanUtilsInnerAVo = BeanUtilsInnerAVo.builder().name("zs").build();
        List<BeanUtilsInnerAVo> list =new ArrayList<BeanUtilsInnerAVo>();
        list.add(beanUtilsInnerAVo);
        BeanUtilsBVo beanUtilsBVo = new BeanUtilsBVo();
        BeanUtilsAVo beanUtilsAVo =  BeanUtilsAVo.builder().respData(list).age("1").build();
        System.out.println(JSON.toJSONString(beanUtilsAVo));
        System.out.println(JSON.toJSONString(beanUtilsBVo));
        BeanUtils.copyProperties(beanUtilsAVo,beanUtilsBVo);
        System.out.println(JSON.toJSONString(beanUtilsBVo));
    }
}
