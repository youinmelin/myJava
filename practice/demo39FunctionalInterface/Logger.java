package demo39FunctionalInterface;

public class Logger {
    public static void showLog(int level, String message) {
        // normal function
        if ( level == 1) {
            System.out.println(message);
        }
    }

    public static void showLog2(int level, MessageBuilder mb) {
        // implement class object is an argument of the function
        if ( level == 1) {
            System.out.println(mb.buildMessage()); 
        }
    }
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = " the ";
        String str3 = "world";
        showLog(2, str1 + str2 + str3);

        showLog2(2, new MessageBuilder(){
        
            @Override
            public String buildMessage() {
                return str1 + str2 + str3;
            }
        });

        showLog2(1, () -> str1 + str2 + str3);
    }
}