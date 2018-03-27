package com.yzq.hashMap;
/**
 * this is a cat and that is a mice and where is the food?
 * 统计每个单词出现的次数
 * @author tokido_saya
 *存储到Map中
 *key :String 
 *value:自定义类型
 *分拣思路
 *1.为所有的key创建容器，之后容器中存放对应的值value
 *2.第一次创建容器，并存放值value
 *第二次之后，直接使用容器存放至
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class HashMapTest {
	
	
	public static void main(String[] args) {
		
	
	String str = "this is a cat and that is a mice and where is the food ?";
	test01(str);
	test01(str);
	
	
	//分拣思路1：
	
		
	}
	
	public static void test01(String str) {
		String[] strArray = str.split(" ");
		Map<String, Letter> letters = new HashMap<String,Letter>();
		for(String temp:strArray) {
					
					if(!letters.containsKey(temp)) {
						letters.put(temp, new Letter());
					}
					Letter let = letters.get(temp);
					let.setName(temp);
					let.addCount();
				}
		//		for(String temp:strArray) {
		//			Letter let = letters.get(temp);
		//			let.setName(temp);
		//			let.addCount();
		//			//let.setCount(this.getCount()+1);
		//		} 
				
				
				
				//输出Map值
				Set<String> keys = letters.keySet();
				for(String key:keys) {
					Letter let = letters.get(key);
					System.out.println(let.getName() + ":"+let.getCount());
				}
	}
	
	
	public static void test02(String str) {
		String[] strArray = str.split(" ");
		Map<String, Letter> letters = new HashMap<String,Letter>();
		for(String temp:strArray) {
			if(!letters.containsKey(temp)) {
				letters.put(temp, new Letter());
				Letter let = letters.get(temp);
				let.setName(temp);
				let.addCount();
			}else {
				Letter let = letters.get(temp);
				let.addCount();
			}
			
		}
		//Set<String> keys = letters.keySet();
		Set<Map.Entry<String, Letter>> keys = letters.entrySet();
		for(Map.Entry<String, Letter> key:keys) {
			Letter let = letters.get(key);
			System.out.println(let.getName() + ":"+let.getCount());
		}
	}
}
	
	
