package demo42Reflection;
// Three ways to get Class object

public class Reflect01 {
    public static void main(String[] args) throws Exception {
        
        // 1.Class.forName
        Class cls1 = Class.forName("demo42Reflection.Person"); 
        System.out.println(cls1);

        // 2.ClassName.class
        Class cls2 = Person.class;
        System.out.println(cls2);

        // 3.obj.getClass()
        Person person = new Person();
        System.out.println(person.getClass());
    }   
}