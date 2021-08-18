package com.exanple.demo.lambok.test;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.lambok.model.BuildTestModel;
import com.example.demo.lambok.model.NoSetModelTest;
import com.example.demo.lambok.model.SetModelTest;
import com.example.demo.lambok.model.SuperBuildTestModel;
import org.junit.jupiter.api.Test;

/**
 *@Data
 * @Setter(lombok.AccessLevel.PROTECTED)
 * @Builder(access = lombok.AccessLevel.PROTECTED)
 * @NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
 * @AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
 * 均可以生效
 * 但是继承关系的build无法生效
 */
public class SetTest {

    /**
     * 测试test方法的protect
     */
    @Test
    public void one(){
        SetModelTest setModel = new SetModelTest();
        setModel.setName("清子");
        setModel.setTramp("美由纪");
        System.out.println(setModel);
    }

    /**
     * 测试set方法的protect，加上protect不能在其他类访问.
     */
    @Test
    public void two(){
        NoSetModelTest setModel = new NoSetModelTest();
//        setModel.setName("清子");
//        setModel.setTramp("美由纪");
        System.out.println(setModel);
    }

    /**
     * 测试build的test方法的protect,加上protect不能在其他类访问.
     *
     */
    @Test
    public void three(){
//        BuildTestModel buildTestModel = BuildTestModel
//                .builder()
//                .name("清子")
//                .tramp("金")
//                .build();
//                BuildTestModel buildTestModel = new BuildTestModel();
        BuildTestModel buildTestModel = BuildTestModel.buildByNameAndTramp("清子","金");
        System.out.println(buildTestModel);
    }


    /**
     * 继承关系中其他类能访问.
     *
     */
    @Test
    public void four(){
        SuperBuildTestModel superBuildTestModel = SuperBuildTestModel.buildByName("zs");
        System.out.println(JSONObject.toJSONString(superBuildTestModel));
    }
}
