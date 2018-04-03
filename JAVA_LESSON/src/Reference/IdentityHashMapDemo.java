package Reference;
/**
 * 键比较地址去重
 */
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
	public static void main(String[] args) {
		IdentityHashMap<String, String> iMap = new IdentityHashMap<String,String>();
		
		//常量地址相同去重
		iMap.put("a","a1");
		iMap.put("a","a2");
		System.out.println(iMap.size());
		
		//对象地址不同
		iMap.put(new String("a"),"a3");
		
		iMap.put(new String("a"), "a4");
		System.out.println(iMap.size());
		
	}
}
