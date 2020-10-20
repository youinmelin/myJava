import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 递归查找所有文件
 * 参考：https://blog.csdn.net/weixin_37770023/article/details/80561854
 */
public class File05AFindAllFile {

    public static List<File> getFilename(File file) {
        ArrayList<File> files = new ArrayList<>();
        if (file.isFile())
            files.add(file);

        // 利用过滤函数将所有子文件夹和文件存入列表
        File[] subFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return true;
                return true;
            }
        });

        if (subFiles != null) {
            for (File subFile: subFiles) {
                if (subFile.isFile()) {
//                    System.out.println(subFile.getName());
                    files.add(subFile);
                }
                else {
                    files.addAll(getFilename(subFile));
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        File file = new File("e:\\课程");
        boolean exists = file.exists();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        String name = file.getName();
        File[] files = file.listFiles();
        int length = files.length;

        List<File> filename = getFilename(file);
        System.out.println(filename);
        System.out.println(filename.size());

    }

}
