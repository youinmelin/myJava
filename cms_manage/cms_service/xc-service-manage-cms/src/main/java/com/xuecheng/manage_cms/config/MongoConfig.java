package com.xuecheng.manage_cms.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
在config包中定义Mongodb的配置类，GridFSBucket用于打开下载流对象
 */
@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.database}")  // 从application文件中读取database信息
    String db;
    @Bean
    public GridFSBucket getGridFSBucket(MongoClient mongoClient){
        // 创建GridFSBucket ,在项目其他地方可以注入GridFSBucket
        MongoDatabase database = mongoClient.getDatabase(db);
        GridFSBucket bucket = GridFSBuckets.create(database);
        return bucket;
    }

}
