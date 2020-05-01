package demo28Waiting;

// thread one: consumer one tell vendor type and number to buy,and waiting
// thread two: consumer two tell vendor type and number to buy,and waiting
// thread three: vendor prepare for goods in five seconds, and notify the consumer
public class WaitAndNotifyAll {
    public static void main(String[] args) {
        Object obj = new Object();
        Runnable cons1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (obj) {
                        System.out.println("C1:I'm consumer one " + Thread.currentThread().getName());
                        System.out.println("C1:I want to buy something.");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("C1:Thank you!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
            }
        };
        new Thread(cons1).start();


        Runnable cons2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (obj) {
                        System.out.println("C2:I'm consumer two" + Thread.currentThread().getName());
                        System.out.println("C2:I want to buy other thing.");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("C2:Thank you!!!!!!!!!!!!!!!!!!!!");
                    }
                }
            }
        };
        new Thread(cons2).start();

        Runnable vendor = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
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
                        obj.notifyAll();
                    }
                }
            }
        };
        new Thread(vendor).start();
    }
}