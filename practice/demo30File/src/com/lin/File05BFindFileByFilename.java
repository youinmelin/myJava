package com.lin;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class File05BFindFileByFilename {

    public static List<File> findFileByName(File file, String filename) {
        List<File> files = new ArrayList<>();
        if (file.isFile())
            files.add(file);

        /**
         * 将子文件夹和查找到的文件存入列表
         */
        File[] subFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return true;
                if (pathname.getName().contains(filename))
                    return true;
                return false;
            }
        });

        for (File item : subFiles) {
            if (item.isDirectory()) {
                files.addAll(findFileByName(item, filename));
            }
            if (item.isFile())
                files.add(item);
        }
        return files;
    }

    public static void main(String[] args) {

        String filename = "txt";
//        String path = "D:\\testing_tools\\my_git\\myJava\\practice\\demo30File";
        String path = "D:\\testing_tools\\my_git\\myJava";
        File file = new File(path);
        List<File> filesList = findFileByName(file, filename);
        System.out.println(filesList);
        System.out.println("共找到文件数量: " + filesList.size());

    }
}
