package com.yzq.refType;

public class Goods {
	private String name;
	private double price;
	private int fav;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public Goods(String name, double price, int fav) {
		this();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "商品名称"+this.getName()+"商品价格"+this.getPrice()+"人气"+this.getFav();
	}
	
	
	
	
}
