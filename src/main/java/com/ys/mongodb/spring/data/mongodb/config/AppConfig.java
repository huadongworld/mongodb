package com.ys.mongodb.spring.data.mongodb.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.ys.mongodb.spring.data.mongodb.model.PersonInfo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaDong
 * @date 2019/4/3 14:00
 */
@Configuration
public class AppConfig {

    @Autowired
    private MongoDbProperties mongoDbProperties;

    @Bean
    public Jongo jongo() {
        DB db = mongoClient().getDB(mongoDbProperties.getDatabase());
        return new Jongo(db);
    }

    @Bean
    public GridFS gridFS() {
        return new GridFS(mongoClient().getDB(mongoDbProperties.getDatabase()));
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(mongoDbProperties.getHost(), mongoDbProperties.getPort());
    }

    @Bean
    public MongoCollection personCollection() {
        //得到名称为PersonInfo的集合
        return jongo().getCollection(PersonInfo.COLLECTION_NAME);
    }
}
