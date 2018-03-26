package com.yzq.collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEmploryee {
	public static void main(String[] args) {
		Employee employee01 = new Employee(0301,"高崎",3000,"项目部","2007-03");
		Employee employee02 = new Employee(0301,"马士兵",3500,"教学部","2007-03");
		Employee employee03 = new Employee(0301,"裴新",3600,"项目部","2007-03");
		
		List<Employee> elist =new ArrayList<Employee>();
	    elist.add(employee01);
	    elist.add(employee02);
	    elist.add(employee03);
	    
	
	
 }
	public static void printEmployeeName(List<Employee> list) {
		for(int i = 0;i < list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
