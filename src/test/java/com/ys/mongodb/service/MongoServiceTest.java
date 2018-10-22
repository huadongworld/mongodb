package com.ys.mongodb.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ys.mongodb.document.Book;
import org.assertj.core.util.Lists;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        mongoService.connectMongoDB();
    }

    @Test
    public void createCollection() {
        mongoService.createCollection(mongoService.connectMongoDB(), "data0");
    }

    @Test
    public void getCollection() {
        mongoService.getCollection(mongoService.connectMongoDB(), "data0");
    }

    @Test
    public void insert() {
        Book book = new Book(
                "西游记",
                "师徒四人取经",
                1000,
                "吴承恩"
        );
        mongoService.insert(mongoService.getCollection(mongoService.connectMongoDB(), "data0"), book);
    }

    @Test
    public void insertMany() {
        Book book = new Book(
                "西游记",
                "师徒四人取经",
                1000,
                "吴承恩"
        );
        Book book2 = new Book(
                "水浒传",
                "108梁山好汉起义",
                100,
                "施耐庵"
        );
        mongoService.insertMany(mongoService.getCollection(mongoService.connectMongoDB(), "data0"), Lists.newArrayList(book, book2));
    }

    @Test
    public void find() {
        List<Book> bookList = mongoService.find(mongoService.getCollection(mongoService.connectMongoDB(), "data0"));
        Assert.assertEquals(2, bookList.size());
    }

    @Test
    public void updateMany() {
        Book book = new Book(
                "西游记",
                "师徒四人取经，啦啦啦啦啦啦",
                1000,
                "吴承恩",
                "name123"
        );
        mongoService.updateMany(mongoService.getCollection(mongoService.connectMongoDB(), "data0"), book);
    }

    @Test
    public void delete() {
        mongoService.delete(mongoService.getCollection(mongoService.connectMongoDB(), "data0"));
    }


}