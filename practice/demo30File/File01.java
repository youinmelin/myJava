package demo30File;

import java.io.File;

public class File01 {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        
    }

    public static void show01() {
         File f1 = new File(".");
        System.out.println(f1); 
         System.out.println(f1.exists()); 
         File f2 = new File(".\\files");
         System.out.println(f2.exists()); 
         File f3 = new File(".\\demo30File\\File01.java");
         System.out.println(f3.exists()); 
         
    }
    public static void show02() {
        File f1 = new File("d:\\", "log.txt");
        System.out.println(f1); 
        System.out.println(f1.exists()); 
    }
    public static void show03() {
        File f1 = new File(".");
        File f2 = new File(f1, "\\demo30file");
        System.out.println(f2);
        System.out.println(f2.exists()); 
        
        
    }
}