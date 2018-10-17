package com.ys.mongodb.service;

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
    public void connectMongo() {
        mongoService.connectMongo();
    }
}