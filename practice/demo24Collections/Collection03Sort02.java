package demo24Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collection03Sort02 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Harry", 11));
        list.add(new Person("Snape", 41));
        list.add(new Person("Dumbledore", 77));
        list.add(new Person("Sirius", 31));

        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person s1, Person s2){
                return s1.getAge() - s2.getAge();
            }
        });
        System.out.println(list);
    }
}