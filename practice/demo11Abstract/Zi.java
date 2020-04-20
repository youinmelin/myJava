package demo11Abstract;

public class Zi extends Fu{
    
    public Zi() {
        System.out.println("child class constructor method."); 
    }
    @Override
    public void eat() {
        System.out.println("overide method");
    }

}