package demo32Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile03 {
    public static void main(String[] args) throws Exception {
        String path = ".";
        int filesNum = 0;
        filesNum = searchFile(path, filesNum);
        System.out.println(filesNum);
    }

    static void copyFile(String filename, String newFilename) throws Exception {
        // copy filename to a new file called newFilename
        // functions readFile and writeFile use the byte[] b to transmit data
        byte[] b = new byte[1024];
        FileInputStream fis = new FileInputStream(filename);
        FileOutputStream fos = new FileOutputStream(newFilename, true);
        while (true) {
            int len = readFile(fis, b);
            // if read the end of the file(len == -1), jump out the loop
            if (len == -1) {break;}
            writeFile(fos, b, len);
        }
    }

    static int readFile(FileInputStream fis, byte[] b) throws IOException {
        // len is a variable returning from read(), to tell writeFile how many bytes to write and to tell the while loop the time to stop 
        int len = fis.read(b);
        System.out.println( len);
        return len;
    }

    static void writeFile(FileOutputStream fos, byte[] b, int len) throws IOException {
        fos.write(b, 0, len);
    }

    static int searchFile(String path, int num) throws Exception {
        // String filename = "demo32Stream\\files\\1.jpg";
        String newFilePath= "c:\\temp\\";
        File file = new File(path);
        for (File f: file.listFiles(pathname -> true)) {
            if (f.isDirectory()) {
                if (f.getParent() !=  newFilePath) { 
                searchFile(f.getPath(), num++);}
            }else if (f.isFile()) {
                String filePath = f.getParent() + "\\";
                String filename = filePath + f.getName();
                String newFilename = newFilePath + f.getName();
                // String newFilename = newFilePath + "new" + f.getName();
                copyFile(filename, newFilename);
                num++;
            }
        }
        return num;
    }
}