package com.yzq.refType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("I7",3200,5000));
		list.add(new Goods("GTX-1060-3G",2000,6000));
		list.add(new Goods("GTX-1080TI",6800,300));
		System.out.println("排序前：" + list);
		Collections.sort(list,new GoodsPriceCompare());
		System.out.println("排序后：" + list);
		Collections.sort(list,new GoodsFavCompare());
		System.out.println("人气排序后：" + list);
	}
	
}
