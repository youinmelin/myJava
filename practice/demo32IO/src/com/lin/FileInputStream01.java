package com.lin;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("files//day03-认识微服务2.md");
        byte[] words_bytes = new byte[1024]; // 数组长度一般为1024的整数倍
//        int len = fileInputStream.read(words_bytes);
        int len = 0;
        // 读到末尾时len = -1
        while ((len=fileInputStream.read(words_bytes)) != -1) {
            String str = new String(words_bytes, 0, len);
            System.out.print(str);
        }
        fileInputStream.close();
    }
}
