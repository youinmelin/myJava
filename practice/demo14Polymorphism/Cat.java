package demo14Polymorphism;

public class Cat extends Animal {
    @Override
    public void eat () {
        System.out.println("Cats eat fish.");
    }
    public void run() {
        System.out.println("Cats can run.");
        
    }
}