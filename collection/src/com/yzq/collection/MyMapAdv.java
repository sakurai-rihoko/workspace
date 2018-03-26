package com.yzq.collection;

import java.util.LinkedList;

/**
 * 高级map，查询效率高
 * @author tokido_saya
 *
 */
public class MyMapAdv {
	LinkedList arr[] = new LinkedList[999];
	int size;
	
	
	public void  put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		int hash = key.hashCode();
		hash = hash < 0?-hash:hash;
		int a = key.hashCode()%arr.length;
		//a:1000 --->1 b:10000-->13
		if(arr[a] == null) {
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);
		}else {
			LinkedList list = arr[a];
			for(int i = 0;i < list.size();i++) {
				MyEntry e2 = (MyEntry)list.get(i);
				if(e2.key.equals(key)) {
					e2.value = value;
					return;
				}
			}
			list.add(e);
		}
	}
	
	public Object get(Object key) {
		int a = key.hashCode()%arr.length;
		if(arr[a] != null) {
			LinkedList list = arr[a];
			for(int i = 0;i < list.size();i++) {
				MyEntry e = (MyEntry)list.get(i);
				if(e.key.equals(key)) {
					return e.value;
				}
			}
		}
			return null;
		
		
	}
	
	public static void main(String[] args) {
		MyMapAdv adv = new MyMapAdv();
		adv.put("001","tokyo");
		adv.put("002", "kyoto");
		adv.put("003", "osaka");
		adv.put("003","naryo");
		
		System.out.println(adv.get("003"));
	}
}
