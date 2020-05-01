package demo27Thread;

public class Person extends Thread{
    private String name;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           System.out.println(name + ">>" + i); 
        }
    }
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}