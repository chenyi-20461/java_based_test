package demo.beanutil;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.compare.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtilTest {
    /**
     * 看能否复制null
     *
     * 不能复制null
     */
    @Test
    public void test(){
        List list = new ArrayList();
        BeanUtils.copyProperties(null,list);
        System.out.println(list);
    }

    /**
     * 能否复制list.
     * 不能
     */
    @Test
    public void testOne(){
        List<Dog> list = new ArrayList<>();
        Dog dog = new Dog();
        dog.setName("zhangSan");
        list.add(dog);
        List<Dog> list1= new ArrayList<Dog>();
        BeanUtils.copyProperties(list,list1);
        System.out.println(list1);
//        解决办法
        System.out.println(JSON.parseArray(JSON.toJSONString(list), Person.class));
    }

    /**
     * 复制后是否带上默认值
     *
     * 会把其他属性抹掉
     */
    @Test
    public void testTwo(){
        Dog dog = new Dog();
        dog.setName("zhangSan");
        Person person = new Person();
        System.out.println(person);
        BeanUtils.copyProperties(dog, person);
        System.out.println(person);
    }


}
