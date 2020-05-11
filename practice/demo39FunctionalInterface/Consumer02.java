package demo39FunctionalInterface;

import java.util.function.Consumer;

public class Consumer02 {
    public static void main(String[] args) {
        // get and split String
        String[] people = {
            "Nasa:8", "Golin:40", "Nancy:38", "Harry: 11"
        };
        for (String person : people) {
            splitStr(person, (str) -> {
                String[] message = str.split(":");
                String name = "name: " + message[0];
                String age = " age: " + message[1];
                System.out.println(name + age);
            });
        }
    }

    public static void splitStr (String str, Consumer<String> con) {
        con.accept(str);        
    }
}