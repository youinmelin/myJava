package demo06String;

import java.util.Scanner;

// 键盘输入一个字符串，统计其中个字符出现的次数
// 大写字母，小写字母，数字，其他
public class String09Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a String");
        String str = sc.nextLine();
        sc.close();
        char[] strArray = str.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countDigital = 0;
        int countOther = 0;
        for (int i = 0; i < strArray.length; i++) {
            char ch = strArray[i];
            if (ch >= 'A' && ch <= 'Z') {
                countUpper++;
            }else if (ch >= 'a' && ch <= 'z'){
                countLower++;
            }else if (ch >= '0' && ch <= '9'){
                countDigital++;
            }else{
                countOther++;
            }
        }
        System.out.println("The length of the string is:" + str.length());
        System.out.println("Upper number is:" + countUpper);
        System.out.println("Lower number is:" + countLower);
        System.out.println("Digital number is:" + countDigital);
        System.out.println("Other number is:" + countOther);


    }
}