package demo.base;

import com.example.demo.domain.model.testobject.Object1;
import com.example.demo.domain.model.testobject.Object2;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ObjectTest {
    /**
     * 不是通过hashcode来判断是否相等
     */
    @Test
    public void testHash(){
        Object a = new Object2();
        Object b = new Object1();
        System.out.println("hashcode:"+a.hashCode());
        System.out.println(a.equals(b));
    }
    /**
     * 测试==
     */
    @Test
    public void testEqual(){
        /*
        * 　　浮点型：float(4 byte), double(8 byte)

　　整型：byte(1 byte), short(2 byte), int(4 byte) , long(8 byte)

　　字符型: char(2 byte)

　　布尔型: boolean(JVM规范没有明确规定其所占的空间大小，仅规定其只能够取字面值"true"和"false")
    对于这8种基本数据类型的变量，变量直接存储的是“值”,，因此在用关系操作符==来进行比较时，比较的就是 “值” 本身*/
        int a = 128;
        int b = 128;
        System.out.println("基本类型变量比较："+(a == b));
        Integer c = 128;
        Integer d = 128;
        System.out.println("泛型变量比较："+(c == d));
        boolean e = Objects.equals(c,d);
        System.out.println("泛型变量比较equals:"+e);
        System.out.println("泛型变量比较equals:"+c.equals(d));
        Integer f = 127;
        Integer g = 127;
        System.out.println("泛型缓冲测试："+(f == g));
        System.out.println("泛型和基本类型："+(a == c));

    }


}
