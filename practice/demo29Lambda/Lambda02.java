package demo29Lambda;

import java.util.Arrays;

public class Lambda02 {
    public static void main(String[] args) {
        Person[] list = {
            new Person("Gandalf", 300),
            new Person("Aragon", 200),
            new Person("Frodo",20),
            new Person("Faramir",100)
        };

       Arrays.sort(list,(o1, o2)->o1.getAge()-o2.getAge());
       for (int i = 0; i < list.length; i++) {
           System.out.println(list[i]);
       }
    }
    
}