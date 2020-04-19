package demo05ArrayList;
/* 自定义4个学生对象，添加到集合，并遍历 */

import java.util.ArrayList;

public class ArrayList05Students {
    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stuList.add(new Student());
        }
        stuList.get(0).setName("zhenglin");
        stuList.get(1).setName("songjie");
        stuList.get(2).setName("pengrui");
        stuList.get(3).setName("liuxiangyu");
        System.out.print("{");
        for (int i = 0; i < stuList.size(); i++) {
            System.out.print(stuList.get(i).getName()); 
            if (i < stuList.size() - 1){
                System.out.print("@");
            }
        }
        System.out.print("}");
    }
}