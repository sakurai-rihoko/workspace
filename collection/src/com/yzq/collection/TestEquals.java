package com.yzq.collection;

import java.util.ArrayList;
import java.util.List;

public class TestEquals {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new String("aaa"));
		list.add(new String("aaa"));
		
		System.out.println(list.size());
		
	}
}
