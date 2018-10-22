package com.ys.mongodb.service;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 * @author HD
 * @date 2018/10/17 9:01
 */
@Service
public class MongoService {

    public MongoDatabase connectMongoDB() {

        //连接到mongodb服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        //连接到数据库（集合）
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mini_program");

        System.out.println("连接到数据库成功！");
        return mongoDatabase;
    }

    public void createCollection(MongoDatabase mongoDatabase) {

        //创建集合
        mongoDatabase.createCollection("mini_program");
        System.out.println("创建集合成功！");
    }

    public MongoCollection<Document> getCollection(MongoDatabase mongoDatabase) {

        //选择文档
        MongoCollection<Document> collection = mongoDatabase.getCollection("mini_program");
        System.out.println("选择集合成功！");

        return collection;
    }

    public void insertMany(MongoCollection<Document> collection) {

        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("by", "Fly");

        collection.insertMany(Lists.newArrayList(document));
        System.out.println("文档插入成功！");
    }
}
