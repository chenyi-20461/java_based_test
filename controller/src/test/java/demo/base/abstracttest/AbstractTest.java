package demo.base.abstracttest;

import com.example.demo.model.Person;
import com.example.demo.model.abstractclass.AbstractAnimal;
import com.example.demo.model.abstractclass.animalImpl.GoodDog;
import org.junit.Test;

import java.util.Objects;

/**
 * 抽象类测试
 */
public class AbstractTest {
    /**
     * 抽象类测试实例化.
     * <p>
     * 即使没有抽象方法也不能实例化，必须要有方法类体
     */
    public void test() {
        AbstractAnimal abstractAnimal = new AbstractAnimal() {
        };
        AbstractAnimal abstractAnimal1 = new GoodDog();

    }

    @Test
    public void test1() {
        Integer a = null;
        System.out.println(Objects.equals(a, 1));
        System.out.println(a == 1);
    }

    @Test
    public void test2() {
        System.out.println(null instanceof Person);
    }

}
