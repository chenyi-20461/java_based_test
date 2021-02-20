package com.example.demo.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 简单的command。
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EasyCommand {
    /**
     * 字符串.
     */
    private String string;
    /**
     * 整数.
     */
    private Integer integer;
    /**
     * 数字.
     */
    private BigDecimal bigDecimal;
    /**
     * 内嵌其他command.
     */
    private Boolean booleanCommand;
}
