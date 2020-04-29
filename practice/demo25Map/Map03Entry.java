package demo25Map;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Map03Entry{
	public static void main(String[] args) {
	 show();
	 }

	 public static void show() {
		 Map<String, Integer> map = new HashMap<>();
		 Integer v1 = map.put("Zhenglin", 99);
		 map.put("Zhengjuntian", 92);
		 map.put("Zhengxiaolin", 98);
		 map.put("Zhengdalin", 78);
		 map.put("Zhenglaolin", 88);

		 Set<Map.Entry<String, Integer>> set = map.entrySet();
		 System.out.println(set);
		 for(Map.Entry<String, Integer> kv: set) {
			 String key = kv.getKey();
			 Integer value = kv.getValue();
			 System.out.println("key:" + key + "--> value:" + value);
		 }
	 }
}
