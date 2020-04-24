package demo14Polymorphism;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dogs eat shit.");
    }

    public void walk() {
        System.out.println("Dogs can walk.");
    }

}