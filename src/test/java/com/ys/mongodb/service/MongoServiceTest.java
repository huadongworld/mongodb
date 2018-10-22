package com.ys.mongodb.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author HD
 * @date 2018/10/17 9:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceTest {

    @Autowired
    private MongoService mongoService;

    @Test
    public void connectMongoDB() {

        //连接服务器
        MongoDatabase mongoDatabase = mongoService.connectMongoDB();
        //创建集合
        mongoService.createCollection(mongoDatabase);
        //获取集合
        MongoCollection<Document> documents = mongoService.getCollection(mongoDatabase);
        //插入文档
        mongoService.insertMany(documents);
    }
}