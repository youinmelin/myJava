public interface Interface05PrivateA {
    public static void methodDefault1() {
        System.out.println("default method 1");
        methodStaticCommon();
    }
    public static void methodDefault2() {
        System.out.println("default method 2");
        methodStaticCommon();
    }

    private static void methodStaticCommon() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}