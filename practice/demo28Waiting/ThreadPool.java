package demo28Waiting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("big", 10);
        Maker maker = new Maker(pizza);
        Maker maker2 = new Maker(pizza);
        Eater eater1 = new Eater(pizza, "one");
        Eater eater2 = new Eater(pizza, "two");
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(maker);
        pool.submit(maker2);
        pool.submit(eater1);
        pool.submit(eater2);
        
    }

}