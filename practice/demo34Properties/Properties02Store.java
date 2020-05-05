package demo34Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties02Store {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("key", "value");
        prop.setProperty("name", "age");
        prop.setProperty("Nancy", "19");
        System.out.println(prop);

        try 
        (FileWriter writer = new FileWriter("demo34Properties\\files\\1.txt");
){
            prop.store(writer, "comments");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}