package com.yzq.collection.interator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i));
		}
		
		Set set = new HashSet<>();
		set.add("高崎");
		set.add("内田");
		set.add("井上");
		
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.println(str);
		}
	}
}
