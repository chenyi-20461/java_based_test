package com.exanple.demo.document.test;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class compress {

    /**
     * Uncompress the incoming file.
     *
     * @param inFileName Name of the file to be uncompressed
     */
    private static void doUncompressFile(String inFileName) {

        try {

            if (!getExtension(inFileName).equalsIgnoreCase("gz")) {
                System.err.println("File name must have extension of \".gz\"");
                System.exit(1);
            }

            System.out.println("Opening the compressed file.");
            GZIPInputStream in = null;
            try {
                File file = new File(inFileName);
                System.out.println(file.getAbsolutePath());
                in = new GZIPInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                System.err.println("File not found. " + inFileName);
                System.exit(1);
            }
            Scanner scanner = new Scanner(in, "GBK");
//            while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s);
            String s1 = s.replace("\u0001", ",");
            System.out.println(s1.split(",").length);
            System.out.println(s1);
            s = s.replace("\u0001", " ").replaceAll(" {2,}", " ");
            String[] s2 = s.split(" ");
            System.out.println(s2.length);
            System.out.println(s);
//            }
//            System.out.println("Open the output file.");
//            String outFileName = getFileName(inFileName);
//            FileOutputStream out = null;
//            try {
//                out = new FileOutputStream(outFileName);
//            } catch (FileNotFoundException e) {
//                System.err.println("Could not write to file. " + outFileName);
//                System.exit(1);
//            }
//
//            System.out.println("Transfering bytes from compressed file to the output file.");
//            byte[] buf = new byte[1024];
//            int len;
//            while((len = in.read(buf)) > 0) {
//                out.write(buf, 0, len);
//            }
//            System.out.println("Closing the file and stream");
            in.close();
//            out.close();
//            Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(outFileName))));
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * Used to extract and return the extension of a given file.
     *
     * @param f Incoming file to get the extension of
     * @return <code>String</code> representing the extension of the incoming
     * file.
     */
    public static String getExtension(String f) {
        String ext = "";
        int i = f.lastIndexOf('.');

        if (i > 0 && i < f.length() - 1) {
            ext = f.substring(i + 1);
        }
        return ext;
    }

    /**
     * Used to extract the filename without its extension.
     *
     * @param f Incoming file to get the filename
     * @return <code>String</code> representing the filename without its
     * extension.
     */
    public static String getFileName(String f) {
        String fname = "";
        int i = f.lastIndexOf('.');

        if (i > 0 && i < f.length() - 1) {
            fname = f.substring(0, i);
        }
        return fname;
    }

    /**
     * Sole entry point to the class and application.
     * main方法和@test的相对路径不一样，@test的相对路径在controller下面，而mainn在整个项目下面
     *
     * @param args Array of String arguments.
     */
    public static void main(String[] args) throws Exception {
//        TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(new FileInputStream(new File("D:\\HS_RC_20200327_N_all.tar")));
//        deTarFile(getPrevDir(), tarArchiveInputStream);
        doUncompressFile(getPrevDir() + File.separator + "HS_RC_20200327_N_all" + File.separator + "lm_setlmt_log.unl.gz");
    }

    private static void deTarFile(String destPath, TarArchiveInputStream tais) throws Exception {
        TarArchiveEntry tae = null;
        while ((tae = tais.getNextTarEntry()) != null) {
            String dir = destPath + File.separator + tae.getName();//tar档中文件
            File dirFile = new File(dir);
            System.out.println(dirFile.getAbsolutePath());
            if (tae.isDirectory() && !dirFile.exists()) {
                boolean a = dirFile.mkdirs();
            }
            if (tae.isFile()) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dirFile));
                int count;
                byte[] data = new byte[1024];
                while ((count = tais.read(data, 0, 1024)) != -1) {
                    bos.write(data, 0, count);
                }

                bos.close();
            }
        }
    }

    private static String getPrevDir() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 解析.gz文件.
     */
    @Test
    public void testCompressAndRead() {
        doUncompressFile(getPrevDir() + File.separator + "HS_RC_20200327_N_all" + File.separator + "lm_setlmt_log.unl.gz");
//        doUncompressFile("D:\\download\\idea pro\\test\\20210507\\HS_RC_20200327_N_all\\lm_setlmt_log.unl.gz");
    }

    /**
     * 解压tar包.
     *
     * @throws Exception 异常
     */
    @Test
    public void testCompress() throws Exception {
        TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(new FileInputStream(new File("D:\\HS_RC_20200327_N_all.tar")));
        deTarFile(getPrevDir(), tarArchiveInputStream);
    }

}   