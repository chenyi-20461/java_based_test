package demo.base;

import com.alibaba.fastjson.JSON;
import com.example.demo.school.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MapTest {

    List<Student> students;

    @BeforeEach
    public void load1() {
        students = new ArrayList<>();
        students.add(Student.builder().sid("1111").score(80).build());
        students.add(Student.builder().sid("1111").score(70).build());
        students.add(Student.builder().sid("2222").score(90).build());
        students.add(Student.builder().sid("2222").score(100).build());
        students.add(Student.builder().sid("3333").score(60).build());
        students.add(Student.builder().sid("3333").score(90).build());
        System.out.println(students);
    }

    @Test
    public void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("name", 1);
        map.merge("name", 1, (oldValue, newValue) -> oldValue + newValue);
        map.merge("count", 1, (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
    }

    /**
     * 传统统计分数
     */
    @Test
    public void testMapMerger() {
        Map<String, Integer> map = new HashMap<>();
        for (Student studentScore : students) {
            if (map.containsKey(studentScore.getSid())) {
                map.put(studentScore.getSid(),
                        map.get(studentScore.getSid()) + studentScore.getScore());
            } else {
                map.put(studentScore.getSid(), studentScore.getScore());
            }
        }
        System.out.println(map);
    }

    /**
     * 新的传统统计分数
     */
    @Test
    public void testMapMerger1() {
        Map<String, Integer> map = new HashMap();
        students.forEach(student -> map.merge(student.getSid(), student.getScore(), Integer::sum));
        Map<String, Integer> map1 = new HashMap();
        students.forEach(student -> map1.merge(student.getSid(), student.getScore(), (a, b) -> a + b));
        System.out.println("map:" + map + "map1" + map1);
    }


    /**
     * 新的传统统计分数
     */
    @Test
    public void testMapMerger2() {
        String[] a={"1","2"};
        Map<String,String> map = new HashMap<>();
        map.put(a[0],"1");
        System.out.println(map);
        System.out.println(JSON.toJSONString(map));
    }
}