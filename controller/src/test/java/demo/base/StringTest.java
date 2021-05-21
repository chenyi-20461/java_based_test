package demo.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.model.compare.Dog;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    //   判断字符串保存另一个字符串
    @Test
    public void test() {
        System.out.println("abc".charAt(-22));
    }

    //   判断字符串保存另一个字符串
    @Test
    public void test1() {
        System.out.println("abc".contains("ab"));
    }

    //    判断字符串是否等于数字
    @Test
    public void test2() {
        System.out.println("2".equals(2));
    }

    //只要是双引号开头都能识别为字符串
    @Test
    public void test3() {
        Object a = "{}";
        System.out.println(a instanceof String);
    }

    @Test
    public void testRight() {
        String a = "hello world";
        String pattern = ".*llo.*";
        String pattern2 = "//^h";

        Pattern patternCom = Pattern.compile(pattern2);
        Matcher m = patternCom.matcher(a);
        System.out.println("字符串：" + a.matches(pattern));
        System.out.println("正则：" + m.find());
        String b = "这是一个测试1";
        String pattern1 = ".*这是.*";
        System.out.println(b.matches(pattern1));

    }

    @Test
    public void arrayTest() {
        String a = "11,22";
        List list = Arrays.asList(a.split(","));
        System.out.println(list);
    }

    @Test
    public void wayTest() {
//       contains方法，包含字符串返回true，否者false
        String a = "[\"等待放款\"]";
        System.out.println(a.contains("等待放款"));
    }

    @Test
    public void stringTest() {
//       contains方法，包含字符串返回true，否者false
        String a = "[001]";
        a.replace("[005]","1");
        System.out.println(a);
    }


    public void test(String a){
        a = a+"1";
        System.out.println(a);
    }

    public void test(Dog dog){
        dog.setAge(13);
    }

    /**
     * 测试变量string传递和普通类变量传递是否可变.
     *
     * string不可变,无法改变引用的地址内的东西，所以a+1；不可以独立没有变量接受
     * 方法的变量只是一个新变量引用了相同的地址块，作＋时并没有改变内存值
     *
     * 而其他类是可变的,方法的变量只是一个新变量引用了相同的地址块，但是能改变地址块，所有其他能变
     *
     * 因为参数传递的都是对象引用，就是地址，这个地址是复制到参数里的，所以地址本身不会改变其他对象可以不改变地址，只改变这个对象里面的内容而String对象需要改变就必须改变地址，那么在方法里面就无法改变String内容了
     */
    @Test
    public void testParam(){
        String a = "1";
        Dog dog = new Dog();
        test(a);
        test(dog);
        System.out.println("string:"+a);
        System.out.println("dog:"+dog);
    }

    /**
     * split方法
     */
    @Test
    public void testSplit(){
        String a = "11";
        System.out.println(Arrays.toString(a.split(",")));
        String b = "11,22";
        System.out.println(Arrays.toString(b.split(",")));
        Arrays.asList(b.split(",")).forEach(System.out::println);
    }

    /**
     * 测试字符串的equals为是否可以为空.
     * 可以
     */
    @Test
    public void testString() {
        String a = "1";
        System.out.println(a.equals(null));
    }

    /**
     * 测试字符串的equals为是否可以为空.
     * 可以
     */
    @Test
    public void test4() {
        String a = "\"[{\"groupItemCode\":\"ProductCodeLQ_1\",\"name\":\"信用贷\"},{\"groupItemCode\":\"ProductCodeLQ_15A1\",\"name\":\"中普惠易贷-15A1\"}]\"";
        String b = a.substring(1,a.length()-1);
        System.out.println(b);
        JSONArray jsonArray = JSON.parseArray(b);
        System.out.println(((Map<String, String>) jsonArray.get(0)).get("name"));
        System.out.println(((Map<String, String>) jsonArray.get(1)).get("name").split("-")[1]);
    }
}
