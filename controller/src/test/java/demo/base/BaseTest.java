package demo.base;

import com.example.demo.model.Person;
import com.example.demo.model.compare.Dog;
import com.example.demo.model.son.Son;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
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
    public void testplus() {
        Integer num = 1;
//        null的等于会出错,由于1转成object，object相等时不会有错的
        System.out.println(num == (Object) 1);
        System.out.println(Objects.equals(num, 1));
    }

    /**
     * 测试除法和取余
     */
    @Test
    public void testDivide() {
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
     * <p>
     * 能
     */
    @Test
    public void testEquals() {
        System.out.println("1".equals(null));
    }

    /**
     * object的toString测试
     * 检查到对应的类型，向下转型了
     * <p>
     * 结果
     * Object a = "1";
     * Object b = new Dog();
     * <p>
     * 由于System.out.println默认调用toString方法
     */
    @Test
    public void testToString() {
        Object a = "1";
        Object b = new Dog();
        System.out.println(a.toString());
        System.out.println(b.toString());
    }

    /**
     * Double.valueOf测试
     * 会空指针
     */
    @Test
    public void testDouble() {
//        System.out.println(Double.valueOf(null));
        Object a = null;
        System.out.println((double) a);
    }

    /**
     * Double.valueOf测试
     * <p>
     * 强转可以为空
     */
    @Test
    public void testThree() {
//        System.out.println(Double.valueOf(null));
        Object a = null;
        System.out.println((Dog) a);
    }

    /**
     * java基本语法.
     * <p>
     * a+b操作不接收不能直接写.
     */
    @Test
    public void testFour() {
        int a = 1;
        int b = 1;
//        a+b;
    }

    /**
     * arrayList的foreach
     * steam的list的foreach都能改变数据源
     * <p>
     * 可以改变数组源
     */
    @Test
    public void test10() {
        Dog dog = Dog.builder().age(11).name("zs").build();
        Dog dog1 = Dog.builder().age(12).name("z1").build();
        Dog dog2 = Dog.builder().age(11).name("zs").build();
        ArrayList<Dog> arrayList = new ArrayList();
        arrayList.add(dog);
        arrayList.add(dog1);
        arrayList.add(dog2);
        arrayList.forEach(dog3 -> dog3.setName("11"));
        arrayList.forEach(System.out::println);
        arrayList.stream().forEach(dog3 -> dog3.setName("12"));
        arrayList.forEach(System.out::println);
        System.out.println(arrayList);
        System.out.println(dog.toString()+dog1.toString()+dog2.toString());
    }

    @Test
    public void testSon() {
        Person person = Person.builder().name("zs").build();
        Son son = Son.builder().sonName("zs").build();
        BeanUtils.copyProperties(person, son);
        System.out.println(son);
        BeanUtils.copyProperties(null, son);
    }

    /**
     * java的return在if语句中能起效.
     */
    @Test
    public void testIfTwo() {
        String a = "1";
        if(a.equals("1"))
            return;

        System.out.println(2);
    }

    /**
     * for循环里面的返回.
     */
    @Test
    public void testFor() {
        String a = "1";
        List<String> list = Collections.singletonList(a);
        for (Object obj:list){
            if(obj.equals("1")){
                return;
            }
        }
        System.out.println(2);
    }


    /**
     * 打错误日志，同时抛出错误.
     */
    @Test
    public void testExc() {
        try {
            int i = 0;
            i= 1/i;
        } catch (Exception e) {
            log.error("公积金pdf不存在", e);
            throw new RuntimeException( "公积金pdf不存在");
        }
    }



}
