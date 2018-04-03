package Synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读设置
 * emptyXxx();空的不可变的集合
 * 1.emptyList() 2.emptyMap 3.emptySet
 * singletonXxx()一个元素不可变集合
 * singleton(T o) --->set
 * singletonList(T o)
 * singletonMap(K key,V value)
 * 
 * unmodifiableXxx()不可变容器
 * unmodifiableList​(List<? extends T> list)
 * unmodifiableMap​(Map<? extends K,? extends V> m)
 * unmodifiableSet​(Set<? extends T> s)
 * @author tokido_saya
 *
 */
public class onlyRead {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "a1");
		map.put("b", "b1");
		Map<String, String> map2 = Collections.unmodifiableMap(map);
		//map2.put("c", "c1");//不可再被修改了
		
		
		//单元素容器
		List<String> list = Collections.singletonList(new String());
		list.add("e");
		list.add("f");
		
	}
	
	public static Set<String> oper(Set<String> set){
		if(set == null) {
			return Collections.EMPTY_SET;
		}
		return set;
	}
}
