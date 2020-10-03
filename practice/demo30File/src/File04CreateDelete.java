import java.io.File;
import java.io.IOException;

public class File04CreateDelete {
    public static void main(String[] args) {
        File f1 = new File("demo30File\\new.txt");
        boolean ret = false;
        try {
            ret = f1.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            System.out.println("create new file: " + ret);
        }
        ret = f1.delete();
        System.out.println("delete file: " + ret);

        f1 = new File(".\\demo30File\\newDir1\\level 1");
        ret = f1.mkdirs();
        System.out.println("make dir: " + ret);
        ret = f1.delete();
        System.out.println("del dir: " + ret);
    }
}