package com.example.demo.wx;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信密文解密.
 */
@Slf4j
public class WechatAesUtil {
    /**
     * 初始化.
     */
    private static boolean initialized = false;

    /**
     * 解密方法.
     *
     * @param encryptedData 密文
     * @param sessionKey    key
     * @param iv            iv[偏移向量]
     * @return 结果
     */
    public static Map<String, Object> decryptEncryptedData(String encryptedData, String sessionKey, String iv) {
        Map<String, Object> map = new HashMap<>();
        try {
            byte[] resultByte = decrypt(Base64.decodeBase64(encryptedData),
                    Base64.decodeBase64(sessionKey),
                    Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                map = JSONObject.parseObject(result, Map.class);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * AES解密.
     *
     * @param content 密文
     * @param keyByte key
     * @param ivByte  iv
     * @return 解密后的信息
     * @throws InvalidAlgorithmParameterException {@link InvalidAlgorithmParameterException}
     */
    public static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws InvalidAlgorithmParameterException {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte)); // 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 初始化.
     */
    public static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**
     * 生成iv.
     *
     * @param iv iv
     * @return 结果
     * @throws Exception {@link Exception}
     */
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String encryptedData = "b3mQssbf8ogjstsahJkztou21nM5orENcrEitwEUUWmyFl61YIal2SaLHhBITaw6mbzKLkRvvmEYVfyW77z7hdbYb8zCKTWldBz4+FLZHZAKYZIrFaYl9tDrlf8/1Qf9+LPOzc2QGv/NpHf8TVioGfBbCAWmWEJZJS8TkYPc26gzJeX2JdCd7wn4lsJuRTgoWFlnjPIi8mWhCreyRr75DQ==";
        String sessionKey = "+jxwKV/OH7xNbVuLKTurxQ==";
        String iv = "6eXWCeQL1/0ZqxIFwtrmCA==";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(WechatAesUtil.decryptEncryptedData(encryptedData, sessionKey, iv)));
    }

}
