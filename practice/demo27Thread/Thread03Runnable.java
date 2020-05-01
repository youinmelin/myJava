package demo27Thread;


public class Thread03Runnable {
    public static void main(String[] args) {
        RunnableImpl runImpl = new RunnableImpl();
        Thread th = new Thread(runImpl);
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread());
        }
    }
}