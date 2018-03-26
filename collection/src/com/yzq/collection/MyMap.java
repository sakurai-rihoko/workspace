package com.yzq.collection;

public class MyMap {
	
	MyEntry entryArr[] = new MyEntry[999];
	int size;
	
	public void put(Object key,Object value) {
		
		MyEntry e = new MyEntry(key,value);
		
		for(int i = 0;i < size;i++) {
			if(entryArr[i].key.equals(key)) {
				entryArr[i].value = value;
				return;
			}
			
		}
		
		entryArr[size++] = e;
	}
	
	
	
	public Object get(Object key) {
		for(int i = 0;i < size;i++) {
			if(entryArr[i].key.equals(key)) {
				return entryArr[i].value;
			}
			
		}
		return null;
	}
	
	
	public boolean containsKey(Object key) {
		for(int i = 0;i < size;i++) {
			if(entryArr[i].key.equals(key)) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean containsValue(Object value) {
		for(int i = 0;i < size;i++) {
			if(entryArr[i].value.equals(value)) {
				return true;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyMap m = new MyMap();
		m.put("001", "千代田区");
		m.put("002", "中央区");
		m.put("003", "港区");
		m.put("003", "目黑区");
		System.out.println(m.get("002"));
		System.out.println(m.get("003"));
	}
}

class MyEntry{
	 Object key;
	 Object value;
	
	public MyEntry() {
		
	}
	public MyEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
}