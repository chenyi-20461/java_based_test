package com.example.demo.optional;

import com.example.demo.domain.model.Person;
import com.example.demo.domain.model.son.Son;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

/**
 * 测试optional
 */
public class OptionalTest {
    private String name;

    /**
     * 优化空指针.
     */
    @Test
    public void test1() {
        Person person = new Person();
        person.setAge(12);
        if (Objects.nonNull(person)) {
            System.out.println(person.getAge());
        }
        Person person1 = null;
//        优化
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        Integer age = optionalPerson.map(a -> a.getAge()).get();
        System.out.println("age=" + age);
//        优化
        int age1 = Optional.ofNullable(person).map(a -> a.getAge()).get();
//        会出错
//        int age2 = Optional.ofNullable(person1).map(a->a.getAge()).get();
        int age2 = Optional.ofNullable(person1).map(a -> a.getAge()).orElse(1);
        System.out.println("age1=" + age1 + ",age2=" + age2);
//        优化两层拿
        Person person2 = null;
        System.out.println("son为"+Optional.ofNullable(person2).map(x->x.getBuilderPerson()).map(x->x.getSon()).orElse(new Son()));
    }

    @Test
    public void testWay() throws Throwable {
//        构造方法被私有化了
//        Optional rightoption = new Optional<>();
        Optional rightoption = Optional.ofNullable(1);
//        测试empty，返回一个空的empty
        Optional optional = Optional.empty();
//       静态方法测试of，要求非空对象，如果空会抛出空指针异常
//      int age = (int) Optional.of(null).get(); 报异常
        int age = Optional.of(1).get();
//       静态方法测试ofNullable，如果空就会返回一个空的optional,此时
        Optional optional1 = optional.ofNullable(null);
//       测试方法get,如果为一个空值，则会抛出NoSuchElementException("No value present")异常
//        int a = (int) optional1.get();
        int a = (int) rightoption.get();
        System.out.println("测试方法get:" + a);
//        测试isPresent()，如果不为空则返回true
        System.out.println("测试isPresent():" + optional1.isPresent());
//        测试ifPresent，如果值不为空就消费，否者不消费
        rightoption.ifPresent(x -> System.out.println("测试消费：" + x));
//        测试filter，如果验证正确返回optional
        System.out.println("测试filter" + rightoption.filter(x -> (int) x > 1));
//        测试map，返回optional，空不操作，不为空返回一个带有值得optional
        System.out.println("测试map：" + rightoption.map(x -> (int) x + 1).get());
//        测试flatmap，返回optional，空不操作，不为空返回一个带有值得optional，与map不同的是映射参数不同
        rightoption.flatMap(t -> Optional.of((Integer) t + 1)).get();
//        测试orElse，空返回参数，不空返回值
        System.out.println("测试orelse正确:" + rightoption.orElse(3) + "空：" + optional.orElse(2));
//        测试orElseGet，空返回生产者参数，不空返回值
        System.out.println("测试orElseGet正确:" + rightoption.orElseGet(() -> 1) + "空：" + optional.orElseGet(() -> 1));
//        测试orElseThrow，空返回异常生产者，不空返回值
        System.out.println("测试orElseThrow正确:" + rightoption.orElseThrow(() -> new Exception("11")));
        System.out.println("测试orElseThrow错误:" + optional.orElseThrow(() -> new Exception("无值")));
    }

}
