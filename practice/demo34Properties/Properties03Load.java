package demo34Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Properties03Load {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("demo34Properties\\files\\1.txt"));
        System.out.println(prop);
        System.out.println(prop.getClass().getName());
        Set<String> set = prop.stringPropertyNames();
        System.out.println(set.getClass());
    }
}
