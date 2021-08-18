package com.example.demo.utils;

import java.io.File;

public class FileNameUtils {

    /**
     * 文件去除后缀.
     *
     * @param fileName 文件名
     * @return 去除后缀后的文件
     */
    public static String removeSuffix(String fileName) {
        return new StringBuffer(new File(fileName).getName())
                .subSequence(0, new File(fileName).getName().indexOf("."))
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(removeSuffix("兰亭集序.pdf"));
    }
}
