package demo.base;

import com.example.demo.model.Person;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

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
    public void testMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("name", 1);
        map.merge("name", 1, (oldValue, newValue) -> oldValue + newValue);
        map.merge("count", 1, (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
    }

    /**
     *传统统计分数
     */
    @Test
    public void testMapMerger(){
        Map<Integer, Integer> map = new HashMap<>();
        for (StudentScore studentScore : list) {
            if (map.containsKey(studentScore.getSid())) {
                map.put(studentScore.getSid(),
                        map.get(studentScore.getSid()) + studentScore.getScore());
            } else {
                map.put(studentScore.getSid(), studentScore.getScore());
            }
        }
        return map;
    }
}
