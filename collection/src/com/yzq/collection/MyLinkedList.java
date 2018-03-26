package com.yzq.collection;

import java.util.Date;

public class MyLinkedList {
	private Node first;
	private Node last;
	
	private int size;
	
	public void add(Object obj) {
		Node n = new Node();
		if(this.first == null) {
			
			n.setPrev(null);
			n.setObj(obj);
			n.setNext(null);
			this.first = n;
			this.last = n;
		}else {
			
			n.setPrev(this.last);
			n.setObj(obj);
			n.setNext(null);
			this.last.setNext(n);
			this.last=n;
		}
		size++;
	}
	public Object get(int index) {
		rangeCheck(index);
		if(first == null) {
			return null;
		}else {
		Node n = first;
		for(int i = 0;i < index;i++ ) {
			n= n.getNext();
		}
		return n.getObj();
		}
		
	}
	public void rangeCheck(int index) {
		if(index >= size) {
		    throw new IndexOutOfBoundsException("error:out of size");
		}
	}
	public Node node(int index) {//优化链表遍历算法，判断index在size的前半段还是后半段
		
		
		if(index < (size >> 1)) {
			Node n = first;
			for(int i = 0;i < index;i++ ) {
				n= n.getNext();
			}
			return n;
		}else {
			Node n = last;
			for(int i = 0;i < index;i++ ) {
				n= n.getPrev();
			}
			return n;
		}
		
	}
	
	public void remove(int index) {
		rangeCheck(index);
		
		if(node(index)!=null) {
		Node nPrev =node(index).getPrev();
		Node nNext = node(index).getNext();
		nNext.setPrev(nPrev);
		nPrev.setNext(nNext);
		
		}
		size--;
		
	}
	
	public void set(int index,Object obj) {
		rangeCheck(index);
		Node newNode = new Node(node(index-1), obj, node(index+1));
		node(index-1).setNext(newNode);
		node(index+1).setPrev(newNode);
		size++;
	}
	
	
	
	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();
		list.add(new Date());
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("dd1");
		list.add("dd2");
		list.add("dd3");
		list.add("dd4");
		list.add("dd5");
		list.add("dd6");
		list.add("dd7");
		list.add("dd8");
		list.add("dd9");
		
		list.add("dd10");
		list.add("dd11");
		list.add("dd12");
		list.add("dd13");
		list.add("dd14");
		list.add("dd15");
		list.add(123123);
		list.remove(3);
		
		list.set(3, "new");
		
		System.out.println(list.get(3));
		System.out.println(list.get(2));
	}
	
}

