package demo42Reflection;
// get constructor object

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflect03GetConstructor {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

		Constructor[] cons = personClass.getConstructors();
		System.out.println(Arrays.toString(cons));
		
		// get constructor object
		Constructor con1 = personClass.getConstructor(String.class,int.class);
		System.out.println(con1);
		// create a new Person objcet
		Object person = con1.newInstance("Nasa", 10);
		System.out.println(person);
		
		Object person2 = personClass.newInstance();
		System.out.println(person2);

    }

}
