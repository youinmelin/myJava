package demo42Reflection;
// Methods in the Class object

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflect02 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        // get fields
        Field[] fields1 = personClass.getFields();
        System.out.println(Arrays.toString(fields1));

        Field publicName = personClass.getField("publicName");
        Person person = new Person("privareNasa", 8);
        System.out.println(publicName);
        System.out.println(publicName.get(person));
        publicName.set(person, "Nasa");
        System.out.println(person);

        Field privateName = personClass.getDeclaredField("name");
        privateName.setAccessible(true);
        System.out.println(privateName.get(person));  

        Field[] fields2 = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields2));

        Constructor<Person>[] cons = personClass.getConstructors();
        System.out.println(Arrays.toString(cons));
    }

}