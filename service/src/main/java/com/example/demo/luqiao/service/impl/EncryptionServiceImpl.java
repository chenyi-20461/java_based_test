package com.example.demo.luqiao.service.impl;

import com.example.demo.luqiao.service.EncryptionService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptionServiceImpl implements EncryptionService {
    @Override
    public String md5Encryption(String str) {
        String result = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((str).getBytes(StandardCharsets.UTF_8));
            byte b[] = md5.digest();

            int i;
            StringBuilder buf = new StringBuilder("");

            for(int offset=0; offset<b.length; offset++){
                i = b[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            return result;
        } catch (Exception e) {
            return null;
        }

    }

}
