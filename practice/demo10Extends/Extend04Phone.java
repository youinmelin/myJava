package demo10Extends;

public class Extend04Phone {
    public static void main(String[] args) {
        Phone moto = new Phone();
        moto.call();
        moto.text();
        moto.showTel();
        System.out.println("++++++++++++++++++++++++++++");
        NewPhone apple = new NewPhone();
        apple.call();
        apple.text();
        apple.showTel();
    }
}