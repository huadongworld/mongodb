package com.ys.mongodb.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Service;

/**
 * @author HD
 * @date 2018/10/17 9:01
 */
@Service
public class MongoService {

    public void connectMongo() {
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mini");

        System.out.println("Connect to mongodb successfully !");
    }
}
