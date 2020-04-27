package demo21Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection01 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        
        coll.add("Nancy");
        coll.add("Golin");
        coll.add("Youinme");
        Object[] objArray = coll.toArray();
        System.out.println(objArray[0]);
        System.out.println(coll);
        boolean ret = coll.remove("Youinme");
        System.out.println(ret);
        System.out.println(coll);
        boolean ret2 = coll.contains("Golin");
        System.out.println(ret2);
        int count = coll.size();
        System.out.println(count);
        coll.clear();
        boolean empty = coll.isEmpty();
        System.out.println(empty);

    }
}