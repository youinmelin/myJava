package demo31Recurrence;

import java.io.File;
import java.util.Scanner;

public class Recurrence04FindFiles {
    public static void main(String[] args) {
        String path = ".";
        File file = new File(path);
		System.out.println(file);
        System.out.println("Please input filename to search: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        sc.close();
        int number = 0;
        number = search(file, filename, number);
        System.out.println("find " + number + " files");
    }

    static int search(File f, String filename, int number) {
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                number = search(file, filename, number);
            }else if (file.isFile()) {
                if (file.getName().endsWith(filename )) {
                    number++;
                    System.out.println(file);
                }
            }
        }
        return number;
    }
}
