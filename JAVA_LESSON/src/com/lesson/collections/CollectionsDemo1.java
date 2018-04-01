package com.lesson.collections;

import java.util.*;

/**
 * collections算法
 * binarySearch​(List<? extends Comparable<? super T>> list, T key)容器有序，必须先排序
 * sort()
 * reverse()
 * shuffle()
 * swap​(List<?> list, int i,int j)
 * @author tokido_saya
 *
 */
public class CollectionsDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<= 54;i++) {
			list.add(i);
		}
		List<Integer> player1 = new ArrayList<Integer>();
		List<Integer> player2 = new ArrayList<Integer>();
		List<Integer> player3 = new ArrayList<Integer>();
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		
		for(int i = 0;i <= 51;i+=3) {
			player1.add(list.get(i));
			player2.add(list.get(i+1));
			player3.add(list.get(i + 2));
		}
		
		
		
		
		
		System.out.println("allCards"+list);
		System.out.println("player1 get cards:"+player1);
		System.out.println("player2 get cards:"+player2);
		System.out.println("player3 get cards:"+player3);
		
		
		
		
	}
}
