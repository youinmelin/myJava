package demo01AbstractClass;

public class Run {
    public static void main(String[] args) {
        AnimalOperator animalOperator = new AnimalOperator();
        animalOperator.operator(new Animal() {
            @Override
            public void eat() {
                System.out.println("animal eat animal");
            }
        });
        Animal animal = new AnimalDemo();
        animalOperator.operator(animal);
    }
}
