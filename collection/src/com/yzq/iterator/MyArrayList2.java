package com.yzq.iterator;

import java.util.Iterator;

public class MyArrayList2 {
	private String[] elem = {"a","b","c","d","e"};
	int size = elem.length;
	
	private class MyIt implements Iterator<String>{
	
	
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

		@Override
		public String next() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public Iterator<String> iterator(){
		return new MyIt();
	}
	 
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()) {
			System.out.println(list.Next());
		}
	}
}
