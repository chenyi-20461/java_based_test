package com.example.demo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 简单的vo.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EasyVo {
    /**
     * boolean结果.
     */
    private String booleanResults;
    /**
     * string结果.
     */
    private String stringResults;
    /**
     * bigDecimal结果.
     */
    private BigDecimal bigDecimalResults;
    /**
     * integer结果.
     */
    private Integer integerResults;
}
