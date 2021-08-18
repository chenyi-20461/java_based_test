package com.example.demo.luqiao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Submit {

    private String ecName;

    private String apId;

    private String mobiles;

    private String sign;

    private String addSerial;

    private String mac;

    private String secretKey;

    private String params;

    private String templateId;

}
