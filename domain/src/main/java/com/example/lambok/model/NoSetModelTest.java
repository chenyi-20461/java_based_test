package com.example.lambok.model;

import lombok.Data;
import lombok.Setter;

/**
 * protect属性.
 * 若A和B在同一个包下：在B类中是可以通过A直接访问A中的protect属性
 * 若A和B在同一个包下，并且B继承于A：在B类中也是可以直接访问A中的protect属性
 * 若A和B不在同一个包下：在B类中是不可以通过A来访问A中的protect属性
 * 若A和B不在同一个包下，并其B继承于A：在B类中是可以访问到A中的protect属性
 */
@Data
@Setter(lombok.AccessLevel.PROTECTED)
public class NoSetModelTest {
    private String name;
    private String tramp;
}
