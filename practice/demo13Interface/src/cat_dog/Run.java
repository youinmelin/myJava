package cat_dog;

public class Run {

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.setAge(2);
        cat.setName("tom");
        cat.eat();

        JumpingApi jCat = new Cat();
        jCat.jumping();

        Cat c = new Cat("cat", 5);
        c.eat();
        c.jumping();


    }
}
