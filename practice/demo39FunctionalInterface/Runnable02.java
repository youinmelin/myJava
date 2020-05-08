package demo39FunctionalInterface;

public class Runnable02 {
    public static void startThread(Runnable task) {
        // task is a implement class
        new Thread(task).start();
    }

    public static void main(String[] args) {
        startThread(() -> System.out.println(Thread.currentThread()));
    }
}