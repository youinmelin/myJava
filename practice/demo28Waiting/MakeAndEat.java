package demo28Waiting;

public class MakeAndEat {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("big", 10);
        Maker maker = new Maker(pizza);
        Eater eater1 = new Eater(pizza, "one");
        Eater eater2 = new Eater(pizza, "two");
        new Thread(maker).start();
        new Thread(eater1).start();
        new Thread(eater2).start();

    } 
}