package com.yzq.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewsTypeApp {
	public static void main(String[] args) {
		List<NewsItem> newsList = new ArrayList<NewsItem>();
		newsList.add(new NewsItem("樱花开了",100000,new Date()));
		newsList.add(new NewsItem("大盘狂跌",400000,new Date()));
		newsList.add(new NewsItem("外交部密集回应十个涉朝鲜问题",100000,new Date()));
		newsList.add(new NewsItem("美贸易代表称6月前或不会对华开征关税 中方回应",100000,new Date(System.currentTimeMillis()-60*60)));
		
		System.out.println("排序前" + newsList);
		Collections.sort(newsList);
		System.out.println("排序后" + newsList);
		
	}
}
