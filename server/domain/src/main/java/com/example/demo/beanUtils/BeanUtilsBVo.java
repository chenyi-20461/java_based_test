package com.example.demo.beanUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeanUtilsBVo {

    private List<BeanUtilsInnerBVo> respData;

    private String age;

    private Date houseSearchTime = new Date();

}
