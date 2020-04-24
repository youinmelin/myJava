package demo14Polymorphism;

public class Multi03 {
    public static void main(String[] args) {
        Animal animal= new Cat();
        animal.eat();
        Cat cat = (Cat) animal;
        cat.run();

        System.out.println(animal instanceof Cat);

    }
}