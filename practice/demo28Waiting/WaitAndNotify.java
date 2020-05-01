package demo28Waiting;

// thread one: consumer tell vendor type and number to buy,and waiting
// thread two: vendor prepare for goods in five seconds, and notify the consumer
public class WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        Runnable cons = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (obj) {
                        System.out.println("C:I'm " + Thread.currentThread().getName());
                        System.out.println("C:I want to buy something.");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("C:Thank you!");
                    }
                }
            }
        };
        new Thread(cons).start();

        Runnable vendor = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("V:Please wait.");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized(obj) {
                        System.out.println("V:Hello! I'm " + Thread.currentThread().getName());
                        System.out.println("V:Here you are.");
                        obj.notify();
                    }
                }
            }
        };
        new Thread(vendor).start();
    }
}