package com.ys.mongodb;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.jongo.Jongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    @Autowired
    private Jongo jongo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void demo() {
        List<String> strings = Lists.newArrayList("0", "1", "6", "7", "8", "9", "2", "3", "4", "5");
        System.out.println(strings);
        strings.sort(Comparator.comparing(s -> s));
        System.out.println(strings);
    }

    @Test
    public void demo01() {
        System.out.println(new Date(1540374550000L));
    }

    @Test
    public void demo02() {

    }
}
