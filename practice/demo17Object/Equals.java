package demo17Object;
public class Equals {
    public static void main(String[] args) {
        Student one = new Student("ming", 11);
        Student two = new Student("harry", 11);
        System.out.println(one.equals(two));
        two.setName("ming");
        two.setAge(10);
        System.out.println(one.equals(two));
        System.out.println(one.getName());

    }
}
