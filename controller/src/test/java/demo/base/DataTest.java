package demo.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class DataTest {
    @Test
    public void testDate(){

        Date date = new Date();
        List list = new ArrayList();
        list.add(date);
    }
}
