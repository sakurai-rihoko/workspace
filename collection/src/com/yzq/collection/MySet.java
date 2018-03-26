package com.yzq.collection;

import java.util.HashMap;

public class MySet {
	HashMap map;
	private static final Object PRESENT = new Object();
	int size;
	
	public MySet() {
		map = new HashMap();
	}
	public int size() {
		return map.size();
	}
	public void add(Object obj) {
		map.put(obj, PRESENT);//set的不可重复就是利用了map里key的不可重复
		size++;
	}
	public void remove(Object obj) {
		
	}
	
	public static void main(String[] args) {
		MySet set = new MySet();
		set.add(new String("aaa") );
		set.add("aaa" );
		System.out.println(set.size());
	}
}
