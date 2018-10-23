package com.ys.mongodb.java;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.ys.mongodb.entity.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HD
 * @date 2018/10/17 9:01
 *
 * 原生Java实现(对应测试包有单元测试类)
 */
@Service
public class BookDaoImpl {

    /**
     * 连接MongoDB
     */
    public MongoDatabase connectMongoDB() {

        //连接到mongodb服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        //连接到数据库（集合）
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mini_program");

        System.out.println("连接到数据库成功！");
        return mongoDatabase;
    }

    /**
     * 创建结合
     * @param mongoDatabase
     */
    public void createCollection(MongoDatabase mongoDatabase, String collectionName) {

        //创建集合
        mongoDatabase.createCollection(collectionName);
        System.out.println("创建集合成功！");
    }

    /**
     * 选择文档
     * @param mongoDatabase
     * @return
     */
    public MongoCollection<Document> getCollection(MongoDatabase mongoDatabase, String collectionName) {

        //选择文档
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        System.out.println("选择集合成功！");

        return collection;
    }

    /**
     * 插入文档
     *
     * @param collection
     */
    public void insert(MongoCollection<Document> collection, Book book) {

        Document document = new Document("title", book.getTitle())
                .append("description", book.getDescription())
                .append("likes", book.getLikes())
                .append("author", book.getAuthor());

        collection.insertMany(Lists.newArrayList(document));
        System.out.println("文档插入成功！");
    }

    /**
     * 插入多个文档
     * @param collection
     */
    public void insertMany(MongoCollection<Document> collection, List<Book> books) {

        List<Document> collections = new ArrayList<>();
        Document document;
        for (Book book : books) {
            document = new Document();
            document.append("name", book.getTitle()).append("author", book.getAuthor());
            collections.add(document);
        }

        collection.insertMany(collections);
    }

    public List<Book> find(MongoCollection<Document> collection) {

//        FindIterable<Document> documents = collection.find(); //查询所有
        FindIterable<Document> documents = collection.find(Filters.eq("author", "吴承恩"));

        Book book;
        List<Book> books = new ArrayList<>();

        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            book = new Book();
            try {
                BeanUtils.populate(book, iterator.next());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            books.add(book);
        }

        return books;
    }

    public void updateMany(MongoCollection<Document> collection, Book book) {
        collection.updateMany(Filters.eq("author", book.getAuthor()), new Document("$set", new Document("name", book.getName())));
    }

    public void delete(MongoCollection<Document> collection) {

//        collection.deleteOne(Filters.eq("author", "八戒")); //删除第一条

        collection.deleteMany(Filters.eq("author", "老沙")); //删除所有查询到的数据
    }

}
