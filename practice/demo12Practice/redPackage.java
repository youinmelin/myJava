package demo12Practice;

import java.util.ArrayList;

public class redPackage {
    public static void main(String[] args) {
        Master master = new Master("Lord", 1000);
        ArrayList<Integer> retList = new ArrayList<>();
        retList = master.send(101, 5);
        System.out.println(retList);
        Member one = new Member("one", 10);
        one.receive(retList);
        Member two = new Member("two", 80);
        two.receive(retList);
    }
}
