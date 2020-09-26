package cat_dog;

public class Cat extends Animal implements JumpingApi{
    @Override
    public void jumping() {
        System.out.println("I can jump. cat.");
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("I can eat. cat.");
    }
}
