package demo25Map;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class Map04For{
	public static void main(String[] args) {
	 show();
	 }

	 public static void show() {
		 Map<String, Integer> map = new LinkedHashMap<>();
		 Integer v1 = map.put("Zhenglin", 99);
		 map.put("Zhengjuntian", 92);
		 map.put("Zhengxiaolin", 98);
		 map.put("Zhengdalin", 78);
		 map.put("Zhenglaolin", 88);

		 for(String key : map.keySet()) {
			
			 System.out.println(key + ">>" + map.get(key));
		 }
	 }
}
