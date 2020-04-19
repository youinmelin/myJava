package demo10Extends;

public class NewPhone extends Phone{
    @Override
    public void showTel() {
        super.showTel();
        System.out.println("show name");
        System.out.println("show icon");
    }
}