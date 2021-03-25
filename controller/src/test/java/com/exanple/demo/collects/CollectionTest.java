package com.exanple.demo.collects;

import com.example.demo.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionTest {
    List<Person> personList;

    @Before
    public void load() {
        personList = new ArrayList<>();
        personList.add(Person.builder().age(1).name("zs1").build());
        personList.add(Person.builder().age(1).name("zs2").build());
        personList.add(Person.builder().age(2).name("zs3").build());
        personList.add(Person.builder().age(3).name("zs4").build());
        personList.add(Person.builder().age(3).name("zs5").build());
        personList.add(Person.builder().age(3).name("-").build());
    }

    @Test
    public void test1() {
        List<Person> personArrayList = new ArrayList<>();
        personArrayList.add(Person.builder().age(1).name("zs").build());
        personArrayList.add(Person.builder().age(1).name("zsa").build());
        personArrayList.add(Person.builder().age(2).name("zsd").build());
        personArrayList.add(Person.builder().age(2).name("zsc").build());
        personArrayList.add(Person.builder().age(2).name("zsu").build());
        Integer collect = personArrayList.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(Person::getAge), typeListMap -> typeListMap.size()));
        Map collect1 = personArrayList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.toList()));
        Map userMap = personArrayList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.collectingAndThen(Collectors.toList(), value -> value.get(0))));
        System.out.println(collect);
        System.out.println(userMap);
        System.out.println(collect1);
        List list = personArrayList.stream().filter(a -> "".contains(a.getName())).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 分组
     */
    @Test
    public void testGroup() {
        Map map = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(map);
    }


    /**
     * 聚合.
     * toList(). 返回arrayList
     * toSet(). 返回hashSet
     * toCollection(ArrayList::new). 返回arrayList
     * toCollection(HashSet::new). 返回hashSet
     * toCollection(LinkedList::new). 返回任意集合和子类
     */
    @Test
    public void testList() {
        List vo = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toList());
        System.out.println("vo:" + vo);
        List list1 = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("list1:" + list1);
        Set personHashSet = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("personHashSet:" + personHashSet);
        List list2 = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("list2:" + list2);
        Set set = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toSet());
        System.out.println("set:" + set);
        List vo1 = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toUnmodifiableList());
//        vo1.add(Person.builder().age(3).name("-").build());
        System.out.println("vo1:" + vo1);
        Set UnmodifiableSet = personList.stream().filter(a -> Optional.ofNullable(a).map(Person::getName).orElse("")
                .contains("-"))
                .collect(Collectors.toUnmodifiableSet());
        System.out.println("UnmodifiableSet:" + set);
    }

    /**
     * 转为不可变list.
     * 如果add会产生UnsupportedOperationException的异常.
     */
    @Test
    public void testUnmodifiable() {
        System.out.println(Collections.unmodifiableList(personList));
    }


    /**
     * joining.
     * 将集合中的字符串映射然后转为连接字符串.
     */
    @Test
    public void testJoining() {
        String test1 = personList.stream().map(Person::getName).collect(Collectors.joining());
        System.out.println("test1:" + test1);
        String test2 = personList.stream().map(Person::getName).collect(Collectors.joining("&&"));
        System.out.println("test2:" + test2);
        String test3 = personList.stream().map(Person::getName).collect(Collectors.joining("&&","-","#"));
        System.out.println("test3:" + test3);
    }

    /**
     * MapMerger.
     * 将集合中的字符串映射然后转为连接字符串.
     */
    @Test
    public void testMapMerger() {
        List test1 = personList.stream().collect(Collectors.mapping(Person::getName,Collectors.toList()));
        System.out.println("test1:" + test1);
    }

    /**
     * 截取.
     */
    @Test
    public void testSubList() {
        List<Person> list = new ArrayList<>();
        list.add(Person.builder().age(1).name("zs1").build());
        if (list.size() > 0) {
            System.out.println(list.subList(0, 1));
        }
    }

}