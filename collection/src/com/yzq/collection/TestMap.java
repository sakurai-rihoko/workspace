package com.yzq.collection;

import java.util.*;

public class TestMap {
	public static void main(String[] args) {
		
		Map map = new HashMap<>();
		
		map.put("yzq", new Wife("马文婷"));
		map.put("ll", new Wife("gakki"));
		
		Wife w = (Wife)map.get("yzq");
		System.out.println(w.name);
		map.remove("ll");
		map.containsKey("yzq");
		map.isEmpty();
		
		
	}
}
class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
}