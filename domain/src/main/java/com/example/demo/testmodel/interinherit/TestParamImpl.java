package com.example.demo.testmodel.interinherit;

import com.example.demo.testmodel.classinherit.Dad;

/**
 * 测试参数接口
 *
 * 接口继承的参数必须强制指定相同
 */
public class TestParamImpl implements TestParam {
    @Override
    public void testInterParam(Dad dad) {
        System.out.println(dad);
    }

    /**
     * 测试写法
     *
     * 接口继承的参数必须强制指定相同
     */
//    @Override
//    public void testInterParam(Grandchild grandchild) {
//        System.out.println(grandchild);
//    }


//     @Override
//     public void testInterParam(Grandpa grandpa) {
//        System.out.println(grandpa);
//     }
}
