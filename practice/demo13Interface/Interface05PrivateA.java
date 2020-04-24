package demo13Interface;
public interface Interface05PrivateA {
    public default void methodDefault1() {
        System.out.println("default method 1");
        methodStaticCommon();
    }
    public default void methodDefault2() {
        System.out.println("default method 2");
        methodStaticCommon();
    }
    private void methodStaticCommon() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}