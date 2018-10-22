package com.ys.mongodb.dao;

import com.ys.mongodb.entity.Book;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author HD
 * @date 2018/10/17 9:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoImplTest {

    @Autowired
    private BookDaoImpl bookDaoImpl;

    @Test
    public void connectMongoDB() {
        bookDaoImpl.connectMongoDB();
    }

    @Test
    public void createCollection() {
        bookDaoImpl.createCollection(bookDaoImpl.connectMongoDB(), "data0");
    }

    @Test
    public void getCollection() {
        bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0");
    }

    @Test
    public void insert() {
        Book book = new Book(
                "西游记",
                "师徒四人取经",
                1000,
                "吴承恩"
        );
        bookDaoImpl.insert(bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0"), book);
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
        bookDaoImpl.insertMany(bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0"), Lists.newArrayList(book, book2));
    }

    @Test
    public void find() {
        List<Book> bookList = bookDaoImpl.find(bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0"));
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
        bookDaoImpl.updateMany(bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0"), book);
    }

    @Test
    public void delete() {
        bookDaoImpl.delete(bookDaoImpl.getCollection(bookDaoImpl.connectMongoDB(), "data0"));
    }


}