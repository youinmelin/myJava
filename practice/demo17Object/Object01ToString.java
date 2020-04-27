package demo17Object;

public class Object01ToString {
    public static void main(String[] args) {
        Person one = new Person("Dumbledore", 60, true);
        System.out.println(one.toString());
        Integer oneAge = one.getAge();
        System.out.println( oneAge.equals(60));
        
    }
}