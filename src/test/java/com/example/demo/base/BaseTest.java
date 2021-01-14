package com.example.demo.base;

import com.example.demo.domain.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BaseTest {
    //    测试||和&&只判前面就能行,
    @Test
    public void testIf() {
        String a = null;
        String b = null;
        if (a == null || a.toString() == "1") {
            System.out.println(1);
        }

        if (a != null && b.toString() == "1") {
            System.out.println(1);
        }
    }

    //    测试while快捷写法
    @Test
    public void testWhile() {
        int n = 3;
//        从n-1到0，循环n次
        while (n-- != 0) {
            System.out.println(n);
        }
        int a = 3;
        while (a != 0) {
            a--;
            System.out.println(a);
        }

    }

    /**
     * i++等价于
     * {int temp = i;
     * i = i + 1;
     * return temp; }
     */
    @Test
    public void testAdd() {

//        int a = 1;
//        System.out.println(a++);
//        System.out.println(a);
        Integer a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            /*代码详解i=i++
             * i={int temp = i;
             * i = i + 1;
             * return temp; }*/
            a = a++; //第一次返回前一个值,自增在赋值之前， a=0 a=a+1;
            b = a++; //b=1 a=2
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        Integer c = 0;
        int d = 0;
        for (int i = 0; i < 99; i++) {
            /*代码详解i=i++
             * i={int temp = i;
             * i = i + 1;
             * return i; }*/
            c = ++c; //第一次返回前一个值,自增在赋值之前， c=1; 1:3 2:5 3:7  .. 98:197
            d = ++c; //d=2 c=2 1:4 2:6 3:8 .. 98:198
        }
        System.out.println("c=" + c);
        System.out.println("d=" + d);
    }
    /**
     * 表达式不能转对象,反向证明这是表达式
     * 表达式的返回值是由编译器识别的，不是你能强转的
     * lambda表达式不能写i++
     */
//    @Test
//    public Integer testPlus(){
//        Object i = 1;
//        return (Integer)(i++);
//    }
//    @Test
//    public Integer testPlus1(){
//        Object i = 1;
//        return (Integer)(i+1);
//    }
    //    表达式原则 表达式有一个原则：一个变量也是表达式，多个表达式的加减法运算都是从左到右进行的

    /**
     * i++ 即后加加，原理是：先自增，然后返回自增之前的值
     * ++i 即前加加，原理是：先自增，然后返回自增之后的值
     * 一个变量也是表达式，多个表达式的加减法运算都是从左到右进行的
     */
    @Test
    public void testExpress() {
        int a = 2;
        System.out.println(("无用加法：" + (a = a++)));
        a = 2;
        System.out.println("从左到右先计算左边的a：" + (a + (3 * a++)));
        a = 2;
        System.out.println("从左到右先计算右边的a：" + ((3 * a++) + a));
        int i = 1;
        int j = 1;
        int k = i++ + ++i + ++j + j++;
        /*
         * 4个·表达式
         * 1 i=2
         * 3 i=3
         * 1
         * 3*/
        System.out.println("复杂运算：" + k);  // 结果：8

    }
    @Test
    public void testplus(){
        Integer num = 1;
//        null的等于会出错,由于1转成object，object相等时不会有错的
        System.out.println(num == (Object)1);
        System.out.println(Objects.equals(num,1));
    }

    /**
     * 测试除法和取余
     */
    @Test
    public void testDivide(){
                int a = 13 / 5;
                int b = 13 % 5;
                int c = 5 / 13;
                int d = 5 % 13;
                int e = 13 / -5;
                int f = -13 / 5;
                int h = -13 % 5;
                int j = 13 % -5;
                System.out.println(a + "，" + b);
                System.out.println(c + "，" + d);
                System.out.println(e + "，" + f);
                System.out.println(h + "，" + j);
    }
    /**
     * string的equals比较能不能有null
     */
    @Test
    public void testEquals(){
        System.out.println("1".equals(null));
    }

    /**
     * object的toString测试
     * 检查到对应的类型，向下转型了
     *
     * 结果
     * Object a = "1";
     * Object b = new Dog();
     */
    @Test
    public void testToString(){
        Object a = "1";
        Object b = new Dog();
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
