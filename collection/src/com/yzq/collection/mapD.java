package com.yzq.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapD {
	public static void main(String[] args) {
		Map hashmap = new HashMap();
		hashmap.put("id", 0301);
		hashmap.put("name","高崎");
		hashmap.put("salary",3000);
		hashmap.put("department","项目部");
		hashmap.put("hireDate","2007-10");
		
		
		Map hashmap2 = new HashMap();
		hashmap2.put("id", 0302);
		hashmap2.put("name","内田");
		hashmap2.put("salary",3500);
		hashmap2.put("department","项目部");
		hashmap2.put("hireDate","2007-10");
		
		
		Map hashmap3 = new HashMap();
		hashmap3.put("id", 0303);
		hashmap3.put("name","山田");
		hashmap3.put("salary",3600);
		hashmap3.put("department","内务组");
		hashmap3.put("hireDate","2007-10");
		
		
		
		List<Map> list = new ArrayList<Map>();
		list.add(hashmap);
		list.add(hashmap2);
		list.add(hashmap3);
		
		printEmployee(list);
		
	}
	
	public static void printEmployee(List<Map> list) {
		for(int i = 0; i < list.size();i ++) {
			System.out.println(list.get(i).get("id"));
			System.out.println(list.get(i).get("name"));
			System.out.println(list.get(i).get("salary"));
			System.out.println(list.get(i).get("department"));
			System.out.println(list.get(i).get("hireDate"));
			
		}
	}
}
