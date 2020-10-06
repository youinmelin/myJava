package com.xuecheng.test.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFastDFS {
    // fastDFS流程 client--TrackerServer--StorageServer
    // fastDFS文件上传测试
    @Test
    public void testUpload() throws IOException, MyException {
        // 加载配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        // 定义一个TrackerClient,用于请求TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        // 连接Tracker
        TrackerServer trackerServer = trackerClient.getConnection();
        // 获取Storage
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        // 创建StorageClient
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        // upload files to Storage
        String fileName = "E:\\knowledge\\IT\\码农\\黑马Java 57期\\19 微服务项目【学成在线】\\day08 课程图片管理 分布式文件系统\\资料\\分布式文件系统研究\\fastDFS安装\\FastDFS安装教程.pdf";
        String fileId = storageClient1.upload_file1(fileName, "pdf", null);// 参数:文件名,文件后缀,文件摘要信息,返回文件Id
        System.out.println(fileId);  // group1/M00/00/00/wKgUgl98LAOAFxKAAAY497BOQPU146.pdf in /home/fastdfs/fastdfs_storage/data

    }

    // fastDFS文件下载测试
    @Test
    public void testDownload() throws IOException, MyException {
        // 加载配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        // 定义一个TrackerClient,用于请求TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        // 连接Tracker
        TrackerServer trackerServer = trackerClient.getConnection();
        // 获取Storage
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        // 创建StorageClient
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        // download file in loaclpath
        String fileId = "group1/M00/00/00/wKgUgl98LAOAFxKAAAY497BOQPU146.pdf";
        storageClient1.download_file1(fileId, "c:/1.pdf");
//        System.out.println(i);
        byte[] bytes = storageClient1.download_file1(fileId);
         // download as outputstream
        FileOutputStream fileOutputStream = new FileOutputStream(new File("c:/2.pdf"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        FileInfo fileInfo = storageClient1.query_file_info1(fileId);
        System.out.println(fileInfo);
    }
}
