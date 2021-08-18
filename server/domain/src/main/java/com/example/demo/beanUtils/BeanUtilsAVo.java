package com.example.demo.beanUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeanUtilsAVo {
    private List<BeanUtilsInnerAVo> respData;

    private String age;
}
