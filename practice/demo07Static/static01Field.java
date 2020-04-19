package demo07Static;

public class static01Field {
    public static void main(String[] args) {
        Student.room = "101";
        Student one = new Student("Guojing",19);
        Student two = new Student("Huangrong",14);

        System.out.println("id:"+one.getId()+" 姓名:" + one.getName() + ", age:" + one.getAge() + ", room:" + Student.room);
        System.out.println("id:"+two.getId()+" 姓名:" + two.getName() + ", age:" + two.getAge() + ", room:" + Student.room);
        System.out.println("room:"+Student.room);
    }
}