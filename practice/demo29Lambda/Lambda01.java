package demo29Lambda;

public class Lambda01 {
    public static void main(String[] args) {
        invokeCook(() -> {System.out.println("cooking!");});
        
    }
    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
    
}