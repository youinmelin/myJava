package demo25Map;
import java.util.Map;
import java.util.HashMap;
public class Map01 {
	public static void main(String[] args) {

	 show01();
	 show02();
	 }

	 public static void show01() {
		 Map<String, String> map = new HashMap<>();
		 String v1 = map.put("Zhenglin", "1");
		 String v2 = map.put("Zhengjuntian", "2");
		 String v3 = map.put("Zhengxiaolin", "3");
		 System.out.println(map);
		 String v4 = map.put("Zhenglin", "4");
		 System.out.println(v4);
		 System.out.println(map);
		 if (map.containsKey("Zhenglin")) {
			 System.out.println("Zhenglin is existed, put failed.");
		 }else{
			 map.put("Zhenglin", "good");
		 }
	}

	 public static void show02() {
		 Map<String, Integer> map = new HashMap<>();
		 Integer v1 = map.put("Zhenglin", 99);
		 map.put("Zhengjuntian", 92);
		 map.put("Zhengxiaolin", 98);
		 System.out.println(map);
		 Integer v2 = map.get("Zhengjuntian");
		 System.out.println(v2);

	 }
}
