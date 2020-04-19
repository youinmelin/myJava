package demo05ArrayList;
// 定义一个数组，存储3个person对象

public class ArrayList01 {
    public static void main(String[] args) {
        // build a array, store 3 Person objects
        Person[] array = new Person[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Person();
        }
        array[0].setName("Nasa");
        array[1].setName("Youinme");
        array[2].setName("Nancy");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }
    }
}