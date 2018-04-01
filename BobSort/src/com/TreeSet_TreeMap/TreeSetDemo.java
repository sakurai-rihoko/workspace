package com.TreeSet_TreeMap;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		//依次存放到TreeSet容器中，使用排序的业务类（匿名内部类）
		
		
		TreeSet<idol> set = new TreeSet<idol>(new Comparator<idol>() {
			public int compare(idol person1,idol person2) {
				return person1.getName().compareTo(person2.getName());
			}
		});
		
		
		idol dia = new idol("小宫有纱", 160, 17);
		idol chika = new idol("伊波杏树", 165, 16);
		idol riko = new idol("逢田梨香子", 160, 16);
		idol kanan = new idol("诹访七香", 160, 17);
		idol you = new idol("齐藤朱夏", 160, 16);
		idol yoshiko = new idol("小林爱香", 160, 15);
		idol mari = new idol("铃木爱奈", 160, 17);
		idol ruby = new idol("降幡爱", 160, 15);
		idol hanamaru = new idol("高槻加奈子", 160, 15);
		
		//TreeSet在添加时排序
		set.add(dia);
		set.add(chika);
		set.add(riko);
		set.add(kanan);
		set.add(you);
		set.add(yoshiko);
		set.add(mari);
		set.add(ruby);
		set.add(hanamaru);
		
		
		System.out.println(set);
		
	}
	
}
