package demo.junit;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class baseJunit {

     /**
     * @Test标记的函数时，在run窗口无法输入数据
      * 定义
      * 单元测试是在软件开发过程中要进行的最低级别的测试活动，软件的独立单元将在与程序的其他部分相隔离的情况下进行测试
     */
     @Test
     public void testVariable(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("请输入你的数字");
         String s = scanner.nextLine();
         while (!s.equals(1)){
             System.out.println(s);
             s = scanner.nextLine();
         }
     }
}
