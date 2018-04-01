package com.yzq.refType;
/**
 * 价格排序
 * @author tokido_saya
 *
 */
import java.util.*;
public class GoodsPriceCompare implements Comparator<Goods>{
	@Override
	public int compare(Goods o1,Goods o2) {
		// TODO Auto-generated method stub
		double result =-( o1.getPrice()-o2.getPrice());
		return result>0?1:result == 0?0:-1;
	}

	

}
