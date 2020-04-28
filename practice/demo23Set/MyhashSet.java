package demo23Set;
import java.util.HashSet;

public class MyHashSet extends HashSet{
	@Override
	public E add(E e) {
		if (this.name == e.name) {
			System.out.println("This set has "+ this.name +"already, failed to add");
			return e;
		}else{
//			addLast(E e);
			Syetem.out.println("add successfully!");
			return e;
		}
	}

}
