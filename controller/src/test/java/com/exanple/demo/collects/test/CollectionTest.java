package com.exanple.demo.collects.test;

import com.example.demo.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CollectionTest {
    List<Person> personList;

    List<Person> personListForGroupAnd;

    @Before
    public void load() {
        personList = new ArrayList<>();
        personList.add(Person.builder().age(1).name("zs1").build());
        personList.add(Person.builder().age(1).name("zs2").build());
        personList.add(Person.builder().age(2).name("zs3").build());
        personList.add(Person.builder().age(3).name("zs4").build());
        personList.add(Person.builder().age(3).name("zs5").build());
        personList.add(Person.builder().age(3).name("-").build());
        personListForGroupAnd = new ArrayList<>();
        personListForGroupAnd.add(Person.builder().age(1).name("zs1").build());
        personListForGroupAnd.add(Person.builder().age(1).name("zs2").build());
        personListForGroupAnd.add(Person.builder().age(2).name("zs3").build());
        personListForGroupAnd.add(Person.builder().age(3).name("zs4").build());
        personListForGroupAnd.add(Person.builder().age(3).name("zs5").build());
        personListForGroupAnd.add(Person.builder().age(3).name("-").build());
    }

    /**
     * 统计每个年龄段的人的个数.
     * <p>
     * 实现技术. 先分组，然后计算个数
     */
    @Test
    public void groupAndCount() {
        Map<Integer, Integer> integerMap = personListForGroupAnd.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.collectingAndThen(Collectors.toList(), List::size)));
//        简化版本，因为不需要转成list求size，可以直接求size
        Map<Integer, Long> integerMap1 = personListForGroupAnd.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(integerMap);
        System.out.println(integerMap1);
    }


    /**
     *
     */
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
        String test3 = personList.stream().map(Person::getName).collect(Collectors.joining("&&", "-", "#"));
        System.out.println("test3:" + test3);
    }

    /**
     * Collectors.mapping.
     * 将集合中元素做操作映射.
     */
    @Test
    public void testMapMerger() {
        List test1 = personList.stream().collect(Collectors.mapping(Person::getName, Collectors.toList()));
        System.out.println("test1:" + test1);
    }

    /**
     * Collectors.flatMapping.
     * 将集合中元素的stream做操作，然后返回.
     */
    @Test
    public void testFlatMapping() {
        List<List<Person>> multilayerList = new ArrayList<>();
        multilayerList.add(personList);
        multilayerList.add(personList);
        List test1 = multilayerList.stream().collect(Collectors.flatMapping(people -> people.stream().filter(person -> person.getAge() == 2), Collectors.toList()));
        System.out.println("test1:" + test1 + "size" + test1.size());
    }

    /**
     * Collectors.filtering.
     * 将集合中元素的stream做判断.
     */
    @Test
    public void testFiltering() {
        List test1 = personList.stream().collect(Collectors.filtering(person -> person.getAge() == 2, Collectors.toList()));
        System.out.println("test1:" + test1 + "size" + test1.size());
    }

    /**
     * Collectors.collectingAndThen.
     * 将集合中元素的stream做聚合，然后对整个集合做操作.
     */
    @Test
    public void testCollectingAndThen() {
        int test1 = personList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println("test1:" + test1);
    }

    /**
     * counting
     * 取得聚合集合的数目
     */
    @Test
    public void testCounting() {
        System.out.println("personList的数目" + personList.stream().collect(Collectors.counting()));
        Long a = personList.stream().collect(Collectors.filtering(person -> person.getAge() == 2, Collectors.counting()));
        System.out.println(a);
    }

    /**
     * MinBy
     * 取得聚合集合的最小值
     */
    @Test
    public void testMinBy() {
        Optional<Person> person1 = personList.stream().collect(Collectors.filtering(person -> person.getAge() == 2, Collectors.minBy(Comparator.comparingInt(Person::getAge))));
        Optional<Person> person2 = personList.stream().collect(Collectors.minBy(Comparator.comparingInt(Person::getAge)));
        Optional<Person> person3 = personList.stream().min(Comparator.comparingInt(Person::getAge));
        System.out.println(person1.get());
        System.out.println(person2.get());
        System.out.println(person3.get());
    }

    /**
     * maxBy
     * 取得聚合集合中的最大值
     */
    @Test
    public void testMaxBy() {
        Optional<Person> person1 = personList.stream().collect(Collectors.filtering(person -> person.getAge() == 2, Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
        Optional<Person> person2 = personList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getAge)));
        Optional<Person> person3 = personList.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println(person1.get());
        System.out.println(person2.get());
        System.out.println(person3.get());
    }

    /**
     * summingInt
     * summingLong
     * summingDouble
     * 取得聚合集合中的聚合求和值
     */
    @Test
    public void testSummingInt() {
        Integer SumPerson = personList.stream().collect(Collectors.summingInt(Person::getAge));
//        简化对比
        Integer SumPerson1 = personList.stream().mapToInt(Person::getAge).sum();
        Long SumPerson2 = personList.stream().collect(Collectors.summingLong(Person::getAge));
        Double SumPerson3 = personList.stream().collect(Collectors.summingDouble(Person::getAge));
        System.out.println(SumPerson);
        System.out.println(SumPerson1);
        System.out.println(SumPerson2);
        System.out.println(SumPerson3);
    }

    /**
     * AveragingInt
     * AveragingInt
     * 取得聚合集合中的聚合求和值
     */
    @Test
    public void testAveragingInt() {
        Double SumPerson = personList.stream().collect(Collectors.averagingInt(Person::getAge));
        Double SumPerson2 = personList.stream().collect(Collectors.averagingLong(Person::getAge));
        Double SumPerson3 = personList.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println(SumPerson);
        System.out.println(SumPerson2);
        System.out.println(SumPerson3);
    }

    /**
     * reducing
     * 取得聚合集合中的聚合求和值
     * 思考为什么结果是36
     */
    @Test
    public void testReducing() {
        Person person = new Person();
        Person sum = personList.stream().collect(Collectors.reducing(person, (a, b) -> {
            a.setAge(a.getAge() + b.getAge());
            return a;
        }));
        Person sum1 = personList.stream().reduce(person, (a, b) -> {
            a.setAge(a.getAge() + b.getAge());
            return a;
        });
        Optional<Person> sum2 = personList.stream().collect(Collectors.reducing((a, b) -> {
            a.setAge(a.getAge() + b.getAge());
            return a;
        }));
        Integer sum3 = personList.stream().collect(Collectors.reducing(0, Person::getAge, Integer::sum
        ));
        System.out.println(sum + "||" + sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

    /**
     * 分组
     * 分组成一个map，每个键对应于一个list
     */
    @Test
    public void testGroup() {
        Map map = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(((List) map.get(1)).get(0));
        Map map1 = personList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.toSet()));
        Map map2 = personList.stream().collect(Collectors.groupingBy(Person::getAge, TreeMap::new, Collectors.toSet()));
        System.out.println(map1);
        System.out.println(map.get(1));
        System.out.println(map2);
        Map map3 = personList.stream().collect(Collectors.groupingByConcurrent(Person::getAge));
        Map map4 = personList.stream().collect(Collectors.groupingByConcurrent(Person::getAge, Collectors.toSet()));
        Map map5 = personList.stream().collect(Collectors.groupingBy(Person::getAge, TreeMap::new, Collectors.toSet()));
        System.out.println(map3);
        System.out.println(map4);
        System.out.println(map5);
    }

    /**
     * partitioningBy
     * 满足条件和不满足条件的分组
     */
    @Test
    public void testPartitioningBy() {
        Map map = personList.stream().collect(Collectors.partitioningBy(a -> a.getAge() > 0));
        Map map1 = personList.stream().collect(Collectors.partitioningBy(a -> a.getAge() > 0, Collectors.counting()));
        System.out.println(map);
        System.out.println(map1);
    }

    /**
     * toMap
     * toUnmodifiableMap
     * 转成map
     * 可以相同键的合并
     */
    @Test
    public void TestToMap() {
        Map map = personList.stream().collect(Collectors.toMap(
                Person::getName,
                Person::getAge
        ));
//       不能合并相同键
//        Map erMap = personList.stream().collect(Collectors.toMap(
//                Person::getAge,
//                Person::getAge
//        ));
        Map map1 = personList.stream().collect(Collectors.toUnmodifiableMap(
                Person::getName,
                Person::getAge
        ));
//        能合并键
        Map map2 = personList.stream().collect(Collectors.toMap(
                Person::getAge,
                Person::getAge,
                Integer::sum
        ));
        Map map3 = personList.stream().collect(Collectors.toUnmodifiableMap(
                Person::getAge,
                Person::getAge,
                Integer::sum
        ));
        Map map4 = personList.stream().collect(Collectors.toMap(
                Person::getAge,
                Person::getAge,
                Integer::sum,
                HashMap::new
        ));
        Map map5 = personList.stream().collect(Collectors.toConcurrentMap(
                Person::getAge,
                Person::getAge,
                Integer::sum
        ));
        Map map6 = personList.stream().collect(Collectors.toConcurrentMap(
                Person::getName,
                Person::getAge
        ));
        Map map7 = personList.stream().collect(Collectors.toConcurrentMap(
                Person::getAge,
                Person::getAge,
                Integer::sum,
                ConcurrentHashMap::new
        ));
        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);
//        System.out.println("erMap"+erMap);
        System.out.println("toConcurrentMap" + map5);
        System.out.println("no merger toConcurrentMap" + map6);
        System.out.println("special toConcurrentMap "+map7);
    }

    /**
     * summarizingInt全部统计.
     */
    @Test
    public void testSummarizingInt(){
        IntSummaryStatistics a = personList.stream().collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(a.getMax());
        System.out.println(a.getAverage());
        System.out.println(a.getMin());
        System.out.println(a.getCount());
        DoubleSummaryStatistics a1 = personList.stream().collect(Collectors.summarizingDouble(Person::getAge));
        System.out.println(a1.getMax());
        System.out.println(a1.getAverage());
        System.out.println(a1.getMin());
        System.out.println(a1.getCount());
        LongSummaryStatistics a2 = personList.stream().collect(Collectors.summarizingLong(Person::getAge));
        System.out.println(a2.getMax());
        System.out.println(a2.getAverage());
        System.out.println(a2.getMin());
        System.out.println(a2.getCount());
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