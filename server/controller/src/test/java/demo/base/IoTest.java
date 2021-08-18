package demo.base;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IoTest {
    /**
     * 很明显，使用缓冲流的速度要快很多
     * 使用缓冲流之后不flush就不会去写入
     * 测试{@link PrintStream}.
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testPrintStream() throws FileNotFoundException, UnsupportedEncodingException {
//        String path = ResourceUtils.getURL("classpath:").getPath()+"static";
        long start = System.currentTimeMillis();
//        true表示追加,下一个是刷新
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("d:/test.txt"), true), true, "utf-8");

//        有异常标记错误
        System.out.println(printStream.checkError());
        int n = 100;
        while (n-- != 0) {
            printStream.println("这是一个测试");
            printStream.print("这是一个测试1");
            printStream.print("这是一个测试2");
        }
        long end = System.currentTimeMillis();
        System.out.println("不使用缓冲流：" + (end - start));


        start = System.currentTimeMillis();
        n = 100;
        //        true表示追加
        PrintStream printStream1 = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("d:/test1.txt"), false)), false, "gb2312");
        while (n-- != 0) {
            printStream1.println("这是一个测试");
            printStream1.print("这是一个测试1");
            printStream1.print("这是一个测试2");
        }
        printStream1.flush();
        end = System.currentTimeMillis();
        System.out.println("使用缓冲流：" + (end - start));
        //        有异常标记错误
        System.out.println(printStream.checkError());
    }

    /**
     * 测试{@link PrintWriter}
     * 测试字符缓冲和字节缓冲的使用速度
     * 结论：字符用字符缓冲流比字节缓冲流快
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testPrintWriter() throws IOException {

        long start = System.currentTimeMillis();
//        true表示追加,下一个是刷新
        PrintWriter printStream = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("d:/test.txt"), true)));
        int n = 1000;
        while (n-- != 0) {
            printStream.println("这是一个测试");
            printStream.print("这是一个测试1");
            printStream.print("这是一个测试2");
        }
        long end = System.currentTimeMillis();
        //        有异常标记错误
        System.out.println(printStream.checkError());
        System.out.println("不使用字节缓冲流：" + (end - start));


//        测试字节缓冲流
        start = System.currentTimeMillis();
        n = 1000;
        //        true表示追加
        PrintWriter printStream1 = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(new File("d:/test1.txt"), false))));
        while (n-- != 0) {
            printStream1.println("这是一个测试");
            printStream1.print("这是一个测试1");
            printStream1.print("这是一个测试2");
        }
        printStream1.flush();
        end = System.currentTimeMillis();
        System.out.println("使用字节缓冲流：" + (end - start));
        //        有异常标记错误
        System.out.println(printStream.checkError());


//        测试字符缓冲流
        start = System.currentTimeMillis();
        n = 1000;
        //        true表示追加
        PrintWriter printStream2 = new PrintWriter(new FileWriter(new File("d:/test2.txt"), false));
        while (n-- != 0) {
            printStream2.println("这是一个测试");
            printStream2.print("这是一个测试1");
            printStream2.print("这是一个测试2");
        }
        printStream2.flush();
        end = System.currentTimeMillis();
        System.out.println("不使用字符缓冲流：" + (end - start));
        //        有异常标记错误
        System.out.println(printStream.checkError());
        //        测试字符缓冲流
        start = System.currentTimeMillis();
        n = 1000;
        //        true表示追加
        PrintWriter printStream3 = new PrintWriter(new BufferedWriter(new FileWriter(new File("d:/test3.txt"), false)));
        while (n-- != 0) {
            printStream3.println("这是一个测试");
            printStream3.print("这是一个测试1");
            printStream3.print("这是一个测试2");
        }
        printStream3.flush();
        end = System.currentTimeMillis();
        System.out.println("使用字符缓冲流：" + (end - start));
        //        有异常标记错误
        System.out.println(printStream.checkError());


    }

    /**
     * scan结合缓冲是最快.
     *
     * @throws IOException
     */
    @Test
    public void testScan() throws IOException {
//        scan的装饰速度
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(new FileReader(new File("d:/test1.txt")));
        String scanSum = "";
        while (scanner.hasNext(Pattern.compile(".是"))) {
            scanSum = scanSum + scanner.nextLine();
        }
        System.out.println(scanSum);
        long end = System.currentTimeMillis();
        System.out.println("scan：" + (end - start));
//        buff的速度
        start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader((new FileReader(new File("d:/test1.txt"))));
        String readContent = bufferedReader.readLine();
        String sunContent = "";
        while (readContent != null) {
            sunContent = sunContent + readContent;
            readContent = bufferedReader.readLine();
        }
        System.out.println("bufferedReader:" + sunContent);
        end = System.currentTimeMillis();
        System.out.println("Buffer：" + (end - start));
//        scan结合buff
        start = System.currentTimeMillis();
        scanner = new Scanner(new BufferedReader(new FileReader(new File("d:/test1.txt"))));
        scanSum = "";
        while (scanner.hasNext()) {
            scanSum = scanSum + scanner.nextLine();
        }
        System.out.println(scanSum);
        end = System.currentTimeMillis();
        System.out.println("scan结合缓冲：" + (end - start));
    }

    /**
     * 测试hasNext(pattern)
     */
    @Test
    public void testHasNext() {
        String s = "Hello World! 3+3.0=6";

        // create a new scanner with the specified String Object
        Scanner scanner = new Scanner(s);

        // check if the scanner's next token matches "rld" following 2 chars
        System.out.println("" + scanner.hasNext(Pattern.compile("..rld")));

        // check if the scanner's next token matches "llo" following 2 chars
        System.out.println("" + scanner.hasNext(Pattern.compile("..llo")));

        // print the rest of the string
        System.out.println("" + scanner.nextLine());

        // close the scanner
        scanner.close();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/util/scanner_hasnext_pattern.html

    }

    /**
     * 测试hasNext(pattern)
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testHasNext1() throws FileNotFoundException, UnsupportedEncodingException {
        // create a new scanner with the specified String Object
        Scanner scanner = new Scanner(new FileReader(new File("d:/test4.txt")));
//        行数
        int i = 1;
        while (scanner.hasNext(Pattern.compile("..llo"))) {
            System.out.println(i++ + "行" + scanner.nextLine());
        }
        Scanner scanner1 = new Scanner(new InputStreamReader(new FileInputStream(new File("d:/test5.txt")), "utf-8"));
//        行数
        i = 1;
        while (scanner1.hasNext(".*这是.*")) {
            System.out.println(scanner1.nextLine());
        }
        scanner.close();
    }

    /**
     * 测试失败
     */
//    @Test
//    public void testUrl() throws FileNotFoundException {
//        String path = ResourceUtils.getFile("classpath:").getPath() + "static/testfile/test.txt";
//
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/testfile/test.txt");
//        assert inputStream != null;
//        Scanner scanner = new Scanner(inputStream);
////        行数
//        int i = 1;
//        while (scanner.hasNext()) {
//            System.out.println(i++ + "行" + scanner.nextLine());
//        }

//    }


}
