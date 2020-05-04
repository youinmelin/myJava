package demo28Waiting;

import java.util.Random;

public class Eater implements Runnable {
    private final String name;
    private Pizza obj;

    @Override
    public void run() {
        int count;
        while (true) {
            synchronized (obj) {
                count = obj.getNum();
                if (count < 1) {
                    try {
                        System.out.println("Eater " + this.name + ":I want to eat Pizza.");
                        this.obj.wait();
                    } catch (final InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                count = obj.getNum();
                count--;
                obj.setNum(count);
                System.out.println(
                        "Eater " + this.name + Thread.currentThread().getName() + ": eating Pizza. " + count + "left.");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // Random r = new Random();
                // System.out.println(r.nextInt(9));
                this.obj.notify();
            }
        }
    }

    public Eater(Pizza obj, String name) {
        this.name = name;
        this.obj = obj;
    }

}