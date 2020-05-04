package demo31Recurrence;

import java.io.File;
import java.util.LinkedList;

public class Recurrence03Mutipath {
    public static void main(String[] args) {
        String path = ".";
        File f = new File(path);
        System.out.println(f.getAbsolutePath());
        LinkedList<File> files = new LinkedList<>();
        files = recurPath(f,files);
        System.out.println(files );
        System.out.println(files.size());
    }

    public static LinkedList<File> recurPath (File dir, LinkedList<File> filesList) {
        File[] files = dir.listFiles();
        for ( File f : files) {
            if (f.isFile()) {
                filesList.add(f);
            }
            if (f.isDirectory()) {
                System.out.println(f);
                recurPath(f, filesList);
            }
        }
        return filesList;
    }
}