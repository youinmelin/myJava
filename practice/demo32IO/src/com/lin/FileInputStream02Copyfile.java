package com.lin;

import java.io.*;

/**
 * 拷贝文件
 */
public class FileInputStream02Copyfile {
    public static void main(String[] args) throws IOException {
        String filenameRead = "files//day03-认识微服务2.md";
        String filenameWrite = "files//day03-认识微服务2_copy.md";
        FileInputStream fileInputStream = new FileInputStream(filenameRead);
        FileOutputStream fileOutputStream = new FileOutputStream(filenameWrite);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
