package com.yzq.collection;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class Test01 {
	public static void main(String[] args) {
		
		
		List list = new ArrayList();
		//ArrayList底层实现是数组，查询快，修改增加慢
		//LinkedList底层实现是链表，查询慢，增删改快
		//Vector：线程安全的，效率低
		list.add("aaa");
		list.add(new Date());
		list.add(1234);
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		
		List list2 = new ArrayList<>();
		
		list2.add("aaa");
		list2.add("bbb");
		list.add(list2);
		System.out.println(list.size());
		
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(3, "ccc");
		
		
		
	}
}
