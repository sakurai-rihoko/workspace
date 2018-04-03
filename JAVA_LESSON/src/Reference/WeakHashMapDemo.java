package Reference;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱引用，gc运行立即回收
 * 
 * @author tokido_saya
 *
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<String,String>();
		//字符串常量不能被回收
		map.put("abc","a");
		map.put("d", "test");
		//弱引用管理被回收
		map.put(new String("ll"), "c");
		map.put(new String("dsf"), "f");
		System.gc();
		System.runFinalization();
		System.out.println(map.size());
	}
}
