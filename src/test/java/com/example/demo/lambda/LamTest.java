package com.example.demo.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LamTest {
    /**
     * 不可以使用变量在lambda表达式当中
     *
     * 只要变量在当前方法只赋值一次（）（有可能是栈释放了）
     */
    @Test
    public void testVariable(String b) {
        String a = b;
//		a = "1";
        String x = Optional.ofNullable(a)
                .map(s -> s + s)
                .map(s -> s + a)
                .orElse("1");
        System.out.println(x);
    }

    @Test
    public void testVariable1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的数字");
        List arrayList = Arrays.asList("1", "2");
        arrayList.forEach(a -> testVariable((String) a));
    }
}
