package com.example.demo.domain.inter;

import com.example.demo.domain.model.son.Son;
import com.example.demo.domain.model.son.Son1;

public interface CyTest {
    String zhangSan = null;

    <A> void testOut(A a);

    void testOut1(Object object);

    void testOut2(Son son);

    void testOut3(Son son);

    void testOut5(Son1 son);
}
