package com.yzq.hashMap;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo02 {

	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<>();
		exam(stuList);
		
		//统计
		Map<String,ClassRoom> rooms = new HashMap<String,ClassRoom>();
		count(rooms,stuList);
		printScore(rooms);
		
		
		
	}	
	public static void printScore(Map<String, ClassRoom> rooms) {
		//Set<Map.Entry<String, ClassRoom>> es = rooms.entrySet();
		Set<Map.Entry<String, ClassRoom>> es = rooms.entrySet();//快，存放key-value一个整体的set集合
		Set<String> keys = rooms.keySet();//慢，只存放map的key的set集合
		for(Map.Entry temp:es) {
			ClassRoom cl = rooms.get(temp.getKey());
			System.out.println(cl.getNo() + "班的总分为" + cl.getTotal());
			System.out.println(cl.getNo() + "班的平均分为" + (cl.getTotal() / cl.getClassList().size()));
		}
		
	}
	
	
		
		public static void count(Map<String,ClassRoom> rooms,List<Student> list) {
			for(Student stu:list) {
				
				String no = stu.getNo();
				double score = stu.getScore();
//				ClassRoom room = rooms.get(no);
				
				if(!rooms.containsKey(no)){
//				if(null == room) {
					//room = new ClassRoom(no);
					rooms.put(no, new ClassRoom(no));
				}
				rooms.get(no).setTotal(rooms.get(no).getTotal()+score);
				rooms.get(no).getClassList().add(stu);
				
			}
		}
		
		
		
		
		
		
		
	
	
	public static void exam(List<Student> stuList) {
		stuList.add(new Student("a", "001", 80));
		stuList.add(new Student("b","002", 70));
		stuList.add(new Student("c", "003", 60));
		stuList.add(new Student("d", "004", 90));
		
	}
}
