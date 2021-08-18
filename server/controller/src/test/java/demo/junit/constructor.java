package demo.junit;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;

/**
 * Junti不能在有两个构造方法的类中使用
 */
//@NoArgsConstructor
//@AllArgsConstructor
public class constructor {
    /**
     * 报错.
     * org.junit.platform.commons.PreconditionViolationException: Class
     * [com.example.demo.optional.OptionalTest] must declare a single constructor
     *
     * Error:(12, 1) java: 已在类 com.example.demo.junit.constructor中定义了构造器 constructor()
     */
    @Test
    public void test1() {
        Person person = new Person();
    }

}
