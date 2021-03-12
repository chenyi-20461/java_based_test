package demo.Dates;

import com.example.demo.constant.TestEnum;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesTests {

    /**
     * 测试时间撮.
     * <p>
     * 直接输出定义字符串
     */
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2021-04-08 14:18:30");
        System.out.println(date.getTime());
        System.out.println(date.getTime()>new Date().getTime());
        System.out.println(new Date().getTime());
    }

}
