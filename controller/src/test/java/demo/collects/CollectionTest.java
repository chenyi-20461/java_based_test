package demo.collects;

import com.example.demo.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionTest {
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
}