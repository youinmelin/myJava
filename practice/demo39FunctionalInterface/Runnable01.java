package demo39FunctionalInterface;

import java.util.Scanner;

public class Runnable01 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while(true) {
                String sendMes = send();
                reply(sendMes);
                if (sendMes.endsWith("bye")) { 
                    System.out.println("the end!");
                    break;}
            }
        });
        thread.start();
    }
     public static String send() {
         Scanner sc = new Scanner(System.in);
         System.out.println("what do you want to say: ");
         return sc.next();
     }

     public static void reply(String sendMes) {
         System.out.println("you say: " + sendMes);
     }


}