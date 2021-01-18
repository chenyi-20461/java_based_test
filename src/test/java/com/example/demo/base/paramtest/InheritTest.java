package com.example.demo.base.paramtest;

import com.example.demo.domain.testmodel.classinherit.Dad;
import com.example.demo.domain.testmodel.classinherit.Grandchild;
import com.example.demo.domain.testmodel.interinherit.TestParamImpl;
import org.junit.jupiter.api.Test;

/**
 * 测试参数的继承
 * <p>
 * 传父类？要强制转型
 * 出错
 * <p>
 * 传子类？
 * 可以
 */
public class InheritTest {
    /**
     * 测试普通参数的继承类.
     *
     * @param dad
     */
    public static void test1(Dad dad) {
        System.out.println(dad);
    }

    /**
     * 普通类的参数
     * 测试参数的继承能不能作为参数.
     * <p>
     * 传父类？要强制转型
     * 出错
     * <p>
     * 传子类？
     * 可以
     */
    @Test
    public void testOne() {
//        Grandpa grandpa = Grandpa.builder().name("康熙").age(81).build();
//        InheritTest.test1((Dad) grandpa);
        Grandchild grandchild = new Grandchild();
        InheritTest.test1(grandchild);
    }

    /**
     * 接口类的参数
     * 测试参数的继承能不能作为参数.
     * <p>
     * 传父类？要强制转型
     * 出错
     * <p>
     * 传子类？
     * 可以
     */
    @Test
    public void testTwo() {
        TestParamImpl testParam = new TestParamImpl();
//        Grandpa grandpa = Grandpa.builder().name("康熙").age(81).build();
//        testParam.testInterParam((Dad) grandpa);
        Grandchild grandchild = new Grandchild();
        testParam.testInterParam(grandchild);
    }

    /**
     * 抽象类名作为形式参数
     * 如果你以后看到一个方法的形参要一个“抽象类类型”，就传该类的子类对象
     */
    @Test
    public void testFour(){
        Dog dog = new Dog();
        setMethod(dog,114);
    }

    private static void setMethod(Animal an, int num) {
        an.show(num);
    }

    abstract class Animal{
        int num=110;
        public abstract void show(int a);
    }
    class Dog extends Animal {
        int num=20;
        @Override
        public void show(int num) {
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(super.num);
        }
    }
}
