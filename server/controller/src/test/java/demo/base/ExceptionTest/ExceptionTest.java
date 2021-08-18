package demo.base.ExceptionTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class ExceptionTest {

    /**
     * 测试异常的属性
     */
    @Test
    public void testRunningException() {
        RuntimeException runtimeException = new RuntimeException("基础异常测试");
        System.out.println(runtimeException.getMessage());
        throw runtimeException;
    }

    /**
     * 多重catch,一重一重拿，先拿子异常
     * 日志输出可以完全的输出异常
     */
    @Test
    public void testCatch() {
        try {
            RuntimeException runtimeException = new RuntimeException("基础异常测试");
            System.out.println(runtimeException.getMessage());
            throw runtimeException;
        } catch (NullPointerException nullPo) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("捕获到大异常");
            log.info("大异常:" + e); //日志的写法，这样不会打出异常信息
            log.info("输出异常信息:", e); //日志的写法，这样可以打出异常
        }
    }

    @Test
    public void testCheck() throws Exception {
        String a = "1";
        if ("1".equals(a)) {
            throw new RuntimeException("测试异常");
        }
    }

    @Test
    public void getInt() throws Exception {
        testCheck();
        System.out.println(1);
    }

    @Test
    public void get1() {
        String a ="11";
        List<Person> people = null;
        try {
            people = JSON.parseArray(a,Person.class);
        } catch (Exception e) {
        }
        System.out.println(people);
    }

    @Test
    public void get2() {
        String a ="11";
        String b = null;
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(a);
            System.out.println(jsonObject+"111");
            b = JSON.parseObject(JSON.toJSONString(jsonObject), String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Person person = Person.builder().name("1").build();
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(person);
            System.out.println(jsonObject+"111");
            Person person1  = JSON.parseObject(JSON.toJSONString(jsonObject), Person.class);
            System.out.println(person1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }



}
