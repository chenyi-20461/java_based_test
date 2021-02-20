package com.example.demo.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCommand {
    /**
     * 字符串的Boolean.
     */
    Boolean littleBoolean;
}
