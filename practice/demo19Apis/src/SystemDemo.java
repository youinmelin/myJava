public class SystemDemo {

    /*
    测试System类的常用方法
     */
    public static void main(String[] args) {
        System.out.println("begin");
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        // public static void exit(int status); 终止当前运行的java虚拟机,非零表示异常终止
//        System.exit(0);
        long count = 1L;
        for (int i = 1; i < 10000; i++) {
            System.out.println(i);
        }
        System.out.println("end");
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - begin);

    }
}
