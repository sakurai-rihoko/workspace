package com.yzq.iterator;
/**
 * 简化迭代器遍历
 * @author tokido_saya
 *
 */
public class MyArrayList {
	private String[] elem = {"a","b","c","d","e"};
	int size = elem.length;
	private int cursor = -1;
	public boolean hasNext() {
		
		return cursor + 1 < size;
	}
	
	public String Next() {
		cursor++;
		return elem[cursor];
	}
	
	public void remove(){
		
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()) {
			System.out.println(list.Next());
		}
	}
}
