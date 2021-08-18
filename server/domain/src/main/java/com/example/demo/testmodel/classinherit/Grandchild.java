package com.example.demo.testmodel.classinherit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 孙子类.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Grandchild extends Dad {
    private String GrandSonName;
}
