import java.io.File;

public class File02Get {
    public static void main(String[] args) {
        show01();
    }

    public static void show01() {
        File f1 = new File(".");
        System.out.println("------f1------");
        System.out.println(f1.getAbsolutePath()); 
        System.out.println(f1.getName()); 
        System.out.println(f1.length()); 
        File f2 = new File(".\\src\\File01.java");
        System.out.println("------f2------");
        System.out.println(f2.getParent());
        System.out.println(f2.getAbsolutePath()); 
        System.out.println(f2.getName()); 
        System.out.println(f2.getPath()); 
        System.out.println(f2.getParent() + "\\" + f2.getName());
        System.out.println(f2.isFile()); 
        System.out.println(f2.isDirectory()); 
        System.out.println(f2.length()); 
        File f3 = new File("");
        System.out.println("------f3------");
        System.out.println(f3.exists()); 
        System.out.println(f3.getPath()); 
        System.out.println(f3.getAbsolutePath()); 
        System.out.println(f3.length()); 

         
    }
}