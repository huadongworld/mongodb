package com.ys.mongodb.gridfs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author HD
 * @date 2018/10/23 10:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GridFsTestTest {

    @Autowired
    private GridFsTest gridFsTest;

    @Test
    public void uploadFile() {
        gridFsTest.uploadFile();
    }

    @Test
    public void findAllFiles() {
        gridFsTest.findAllFiles();
    }

    @Test
    public void findFile() {
        gridFsTest.findFile();
    }
}