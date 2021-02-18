package com.example.demo.domain.testmodel.classinherit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 叔叔类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Uncle extends Grandpa{
    private String uncleName;

    public void testParam(Dad dad){
        System.out.println(dad);
    }
}
