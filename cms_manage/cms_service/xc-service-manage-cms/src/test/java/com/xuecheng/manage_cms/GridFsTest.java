package com.xuecheng.manage_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * GridFs 存储读取文件测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTest {

    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;

    // save files into mongodb
    @Test
    public void testGridFsStore() throws FileNotFoundException {
        // define file
        File file = new File("E:\\knowledge\\IT\\my_git\\myJava\\practice\\demo57spring_boot02\\" +
                "springboot_freemarker\\src\\main\\resources\\templates\\index_banner.ftlh");
        // define inputstream
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "index_banner.ftlh");
        System.out.println(objectId);
    }

    // get files, 要先Mongodb的配置类 定义GridFSBucket用于打开下载流对象
    @Test
    public void testGridFsGetFiles() throws IOException {
        // 根据文件id(从fs.files集合中)查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is("5f7471d975c0181e20a9a65f")));// 输入查询条件
        if (gridFSFile == null) {
            System.out.println("-------- not existed. --------");
        }else {
            // 打开一个下载流对象
            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
            // 创建GridFsResouce对象,用来获取流
            GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
            // 从流中取数据
            String s = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
            System.out.println(s);

        }


    }


}
