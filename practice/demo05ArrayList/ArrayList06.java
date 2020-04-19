package demo05ArrayList;
/* 建立包含多个随机整数的集合，
将集合传参到函数中，函数筛选出所有偶数，
以集合的形式返回 */

import java.util.Random;
import java.util.ArrayList;

public class ArrayList06 {
    public static void main(String[] args) {
        int times = 20;
        ArrayList<Integer> ramList = createRandum(times);
        ArrayList<Integer> newList = evenOddList(true, ramList);
        System.out.println(newList.size()+":"+newList);
    }
    
    public static ArrayList<Integer> createRandum(int times) {
        Random ram = new Random();
        ArrayList<Integer> randumList = new ArrayList<>();
       for (int i = 0; i < times; i++) {
           randumList.add(ram.nextInt(100));
       } 
       return randumList;
    }

    public static ArrayList<Integer> evenOddList(boolean even, ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (even){
                if (list.get(i) % 2 == 0){
                    newList.add(list.get(i));
                } 
            }else{
                if (list.get(i) % 2 != 0){
                    newList.add(list.get(i));
                }

            }
            
        }        
        return newList;
    }
}