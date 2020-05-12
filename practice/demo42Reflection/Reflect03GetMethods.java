package demo42Reflection;
// get methods object

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflect03GetMethods{
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

		Method method = personClass.getMethod("eat");
		System.out.println(method);

		Object person = personClass.newInstance();
		// person.setName("Zhenglin");
		method.invoke(person);
		method = personClass.getMethod("eat",String.class);
		method.invoke(person, "Zhenglin");

		Method[] methods = personClass.getMethods();
		System.out.println(Arrays.toString(methods));

    }

}
