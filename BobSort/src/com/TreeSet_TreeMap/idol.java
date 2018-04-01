package com.TreeSet_TreeMap;

public class idol {
	private  final String name;
	private final int height;
	private final int age;
	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getAge() {
		return age;
	}
	
	public idol(String name, int height, int age) {
		super();
		this.name = name;
		this.height = height;
		this.age = age;
	}
	
	
	
	public String toString() {
		return "姓名"+this.getName()+"年龄"+this.getAge()+"身高"+this.getHeight() +"\n";
	}
}
