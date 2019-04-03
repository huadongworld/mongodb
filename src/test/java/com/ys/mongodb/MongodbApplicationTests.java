package com.ys.mongodb;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.ys.mongodb.spring.data.mongodb.model.Address;
import com.ys.mongodb.spring.data.mongodb.model.PersonInfo;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    @Autowired
    private MongoCollection personCollection;

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
    public void jongoFind() {

        @SuppressWarnings("unchecked")
        Iterator<PersonInfo> all = personCollection.find().as(PersonInfo.class);
        while (all.hasNext()) {
            PersonInfo personInfo = all.next();
            System.out.println("all:" + personInfo);
        }

        PersonInfo one = personCollection.findOne("{id:1}").as(PersonInfo.class);
        System.out.println("one:" + one);
    }

    @Test
    public void jongoSave() {
        PersonInfo personInfo = new PersonInfo(
                1,
                "八戒",
                "男",
                "隔壁老王"
        );
        personCollection.save(personInfo);
        PersonInfo personInfo1 = new PersonInfo(
                1,
                "小明",
                "男",
                "朋友"
        );
        personCollection.save(personInfo1);
        PersonInfo personInfo2 = new PersonInfo(
                1,
                "小红",
                "女",
                "朋友"
        );
        personCollection.save(personInfo2);
    }

    @Test
    public void jongoUpdate() {
        personCollection.update("{person_name : '八戒'}").with(new PersonInfo(10, "猪八戒", "Man", "隔壁小王"));
        personCollection.update("{person_name : '八戒'}").with("{$set:{address:#}}", new Address("0755", "深圳"));
        personCollection.update("{person_name : '小红'}").with("{$set:{person_name:'小红红'}}");
        personCollection.update(new ObjectId("53cb7d99b963ac657273328c")).with("{$inc: {id: 2}}");
        jongoFind();
    }

    @Test
    public void jongoInsert() {
        personCollection.insert("{person_name:'Insert Demo'}");
        jongoFind();
    }

    @Test
    public void jongoRemove() {
        personCollection.remove("{person_name:'Insert Demo'}");
        personCollection.remove("{person_name : '八戒'}");
    }

    @Test
    public void jongoQuery() {

        PersonInfo personInfo = personCollection.findOne("{person_name:'小明'}").as(PersonInfo.class);
        System.out.println(personInfo);

        personInfo = personCollection.findOne("{person_name:'小明'}").projection("{person_name:1}").as(PersonInfo.class);
        System.out.println(personInfo);

        Object id = personCollection.findOne("{person_name:'小明'}").projection("{id:1}").as(Object.class);
        System.out.println(id);
    }
}
