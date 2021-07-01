package com.example.demo.luqiao.service;

/**
 * 加密service.
 */
public interface EncryptionService {

    /**
     * 对信息进行MD5 32位小写加密.
     *
     * @param content 要加密的内容
     * @return 加密信息.
     */
    String md5Encryption(String content);
}
