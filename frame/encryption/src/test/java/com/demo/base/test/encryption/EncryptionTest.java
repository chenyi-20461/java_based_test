package com.demo.base.test.encryption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

/**
 * 加密测试.
 */
public class EncryptionTest {

    /**
     * @author chen yi
     * @date 2021/8/18
     * @question md5用commons-codec如何加密
     * @result
     * @scene 数字签名，消息认证码，存入数据库密码
     * @extend 明文进行处理产生一个128位（16字节）的散列值,极其难以由散列函数输出的结果，回推输入的数据是什么，
     * 加密类型（16位大、16位小、32位大、32位小）32位是128位的二进制数转换成32位16进制数
     * 16 位实际上是从 32 位字符串中取中间的第 9 位到第 24 位的部分
     * 大写为其中字母大写
     * 小写为其中字母小写
     */
    @Test
    public void MD5Method() {
        String md5Hex = DigestUtils.md5Hex("123456");
        System.out.println("32位小写加密：" + md5Hex);
        System.out.println("32位大写加密：" + md5Hex.toUpperCase());
        System.out.println("16位小写加密" + md5Hex.substring(8, 24));
        System.out.println("16位大写加密" + md5Hex.substring(8, 24).toUpperCase());
        System.out.println("md5加密字符串的长度" + md5Hex.getBytes().length);
    }

    /**
     * @author chen yi
     * @date 2021/8/18
     * @question base64如何用commons-codec如何加密
     * @result
     * @scene 图片, 公钥证书, 电子邮件数据.
     * @extend Base64就是一种基于64个可打印字符来表示二进制数据的方法, 严格来说并不是加密算法，是一种编码方式
     * 而在网络上交换数据时，比如说从A地传到B地，往往要经过多个路由设备，
     * 由于不同的设备对字符的处理方式有一些不同，这样那些不可见字符就有可能被处理错误，这是不利于传输的。
     */
    @Test
    public void Base64Method() {
        Base64 base64 = new Base64();
        String a = "标准的Base64并不适合直接放在URL里传输,因为URL编码器会把标准Base64中的“/”和“+”字符变为形如“%XX”的形式，而这些“%”号在存入数据库时还需要再进行转换";
        String str = base64.encodeToString(a.getBytes());
        System.out.println("加密后的字符串:" + str);
        String s = new String(base64.decode(str));
        System.out.println("解密后的字符串：" + s);
        System.out.println("加密前的长度:" + a.getBytes().length);
        System.out.println("加密后的长度:" + str.getBytes().length);
    }


    /**
     * @author chen yi
     * @date 2021/8/18
     * @question SHA1散列算法（40位）加密 散列函数
     * @result
     * @scene 同md5一样应用余单项加密
     * @extend  安全散列算法（英语：Secure Hash Algorithm，缩写为SHA）是一个密码散列函数家族，是FIPS所认证的安全散列算法
     */
    @Test
    public void SHA1Method() {
        String s = DigestUtils.sha1Hex("123456");
        System.out.println("---------------SHA1-----------");
        System.out.println("加密后的字符串" + s + "加密后的长度" + s.length());
    }

    /**
     * @author chen yi
     * @date 2021/8/18
     * @question SHA256散列算法
     * @result
     * @scene 同md5一样应用余单项加密
     * @extend  安全散列算法（英语：Secure Hash Algorithm，缩写为SHA）是一个密码散列函数家族，是FIPS所认证的安全散列算法
     */
    @Test
    public void SHA256Method() {
        String s = DigestUtils.sha256Hex("123456");
        System.out.println("--------------SHA256------------");
        System.out.println("加密后的字符串" + s + "加密后的长度" + s.length());
    }

}
