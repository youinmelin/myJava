package demo34Properties;

import java.util.Properties;
import java.util.Set;

public class Properties01 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("key", "value");
        prop.setProperty("name", "age");
        prop.setProperty("Nancy", "19");
        System.out.println(prop);
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + ": " + prop.getProperty(key))  ;
        }
    }
}