package demo30File;

import java.io.File;

public class File03Iterate {
    public static void main(String[] args) {
        File f1 = new File(".");
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.isDirectory());
        if (f1.isDirectory()) {
            String[] files = f1.list();
            for (String filename : files)
                {System.out.println(filename);}
        }
    }
}