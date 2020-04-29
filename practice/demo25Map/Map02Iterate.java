package demo25Map;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Map02Iterate {
	public static void main(String[] args) {
	 show02();
	 }

	 public static void show02() {
		 Map<String, Integer> map = new HashMap<>();
		 Integer v1 = map.put("Zhenglin", 99);
		 map.put("Zhengjuntian", 92);
		 map.put("Zhengxiaolin", 98);
		 map.put("Zhengdalin", 78);
		 map.put("Zhenglaolin", 88);

		 Set<String> set = map.keySet();
		 System.out.println(set);
		 for(String key: set) {
			 int value = map.get(key);
			 System.out.println(value);
		 }
	 }
}
