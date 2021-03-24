package com.example.demo.springboottest.service;

import com.example.demo.springboottest.enums.AmuseEnum;

public interface AmuseService {
    /**
     * 娱乐方法.
     *
     * @return 娱乐字符串
     */
    String amuse();

    Boolean support(AmuseEnum amuseEnum);

}
