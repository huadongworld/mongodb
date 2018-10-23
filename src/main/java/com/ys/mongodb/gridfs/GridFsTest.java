package com.ys.mongodb.gridfs;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author HD
 * @date 2018/10/23 10:02
 *
 * gridFsTemplate实现大文件的上传下载(对应测试包有单元测试类)
 */
@Component
public class GridFsTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    /**
     * 上传图片文件
     */
    public void uploadFile() {
         Resource file = new FileSystemResource("C:\\Users\\85176\\Desktop\\43d31c66ee9dc1ae30b4a42995795b37.png");
        try {
            gridFsTemplate.store(file.getInputStream(), file.getFilename(), "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找指定文件
     * @throws IOException
     */
    public void findFile() {
        GridFSFile gridFSDBFile = gridFsTemplate.findOne(Query.query(Criteria.where("filename").is("43d31c66ee9dc1ae30b4a42995795b37.png")));
    }

    /**
     * 查找所有文件
     */
    public void findAllFiles() {
        GridFsResource[] txtFiles = gridFsTemplate.getResources("*");
        for (GridFsResource txtFile : txtFiles) {
            System.out.println(txtFile.getFilename());
        }
    }
}
