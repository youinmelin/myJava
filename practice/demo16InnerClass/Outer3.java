package demo16InnerClass;

public class Outer3 {
    public void methodOuter() {
        int num =10;
         
        class Inner {
            public void methodInner() {
                System.out.println(num);
            }
        }
    }
}