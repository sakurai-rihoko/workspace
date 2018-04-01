package com.yzq.refType;

import java.util.Comparator;

public class GoodsFavCompare implements Comparator<Goods> {
	public int compare(Goods o1,Goods o2) {
		// TODO Auto-generated method stub
		return o1.getFav() - o2.getFav();
	}
}
