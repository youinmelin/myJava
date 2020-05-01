package demo27Thread;
public class Thread01 {
    public static void main(String[] args) {
        Person one = new Person("Nasa");
        one.start();
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread.");
        }
    }

}