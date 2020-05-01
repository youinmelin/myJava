package demo27Thread;


public class Thread02 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        System.out.println(Thread.currentThread());
    }
}