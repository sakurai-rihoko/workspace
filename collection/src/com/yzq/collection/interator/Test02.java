package com.yzq.collection.interator;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test02 {
	
	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("01", "aaa");
		map.put("02","bbb");
		Set keys = map.keySet();
		for(Iterator iter= keys.iterator();iter.hasNext();) {
			String keyStr = (String)iter.next();
			System.out.println(keyStr+"---"+map.get(keyStr)); 
		}
		Set<Entry> set2 = map.entrySet();
		for(Iterator iterator = set2.iterator();iterator.hasNext();) {
			Map.Entry e = (Map.Entry)iterator.next();
			System.out.println(e.getKey()+"----"+e.getValue());
		}
	}
}
