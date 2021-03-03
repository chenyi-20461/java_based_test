package com.example.demo.testmodel.classinherit;

/**
 * 类继承参数测试
 * 接口继承的参数必须强制指定相同
 */
public class UncleSon extends Uncle {
//    @Override
//    public void testParam(Grandchild dad){
//        System.out.println(dad);
//    }

//    @Override
//    public void testParam(Grandpa dad){
//        System.out.println(dad);
//    }

    @Override
    public void testParam(Dad dad){
        System.out.println(dad);
    }
}
