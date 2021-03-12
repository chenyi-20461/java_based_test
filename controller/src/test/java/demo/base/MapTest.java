package demo.base;

import com.example.demo.student.model.Student;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
