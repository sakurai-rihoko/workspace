package com.yzq.collection;

import java.util.Date;

/**
 * 自己编写的ArrayList帮助理解
 * @author tokido_saya
 *
 */
public class MYArrayList {
	
	private Object elementData[];
	private int size;
	
	
	
	public MYArrayList() {
		this(10);
	}
	
	public MYArrayList(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity:"+initialCapacity);
		}
		
		
		this.elementData = new Object[initialCapacity];
	}
	
	public void add(Object obj) {
		
		//数组扩容
		
		if(size == elementData.length) {
			Object newArrayList[] = new Object[size * 2 +1];
			System.arraycopy(elementData, 0, newArrayList, 0, elementData.length);
			elementData = newArrayList;
		}
		elementData[size++] = obj;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public Object get(int index) {
		RangeCheck(index);
			
		return elementData[index];
	}
	
	
	public void remove(int index) {
		
		RangeCheck(index);
		int numMoved = size -index -1;
		System.arraycopy(elementData, index+1, elementData, index, numMoved);
		elementData[--size] = null;
		
		
		
		
	}
	public void remove(Object obj) {
		
		for(int index = 0; index < size;index++) {
			if(elementData[index].equals(obj)) {
				remove(index);
			}
		}
	}
	
	private void RangeCheck(int index) {
		 if (index >= size) {
	            throw new IndexOutOfBoundsException("error:out of size");
	    }
	}
	
	public Object set(int index,Object obj) {
		RangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	
	public void add(int index,Object obj) {
		RangeCheck(index);
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index +1, size -index);
		elementData[index] = obj;
		size ++ ;
	}
	private void ensureCapacity(int size) {
		if(size == elementData.length) {
			Object newArrayList[] = new Object[size * 2 +1];
			System.arraycopy(elementData, 0, newArrayList, 0, elementData.length);
			elementData = newArrayList;
		}
	}
	
	public static void main(String[] args) {
		MYArrayList ml = new MYArrayList(3);
		ml.add(333);
		ml.add("nihao");
		ml.add(123);
		ml.add(456);
		ml.add(new Date());
		ml.remove((Object)333);
		ml.remove(1);
		System.out.println(ml.size);
		System.out.println(ml.get(2));
		
	}
	
	
	
	
	
	
	
}
