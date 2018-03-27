package com.yzq.hashMap;
/**
 * 班级对象
 * @author tokido_saya
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

public class ClassRoom {
	private String no;
	private List<Student> classList;
	private double total;
	
	
	
	
	public ClassRoom() {
		
		classList = new ArrayList<Student>();
	}
	public ClassRoom(String no) {
		this();
		this.no = no;
		
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getClassList() {
		return classList;
	}
	public void setClassList(List<Student> classList) {
		this.classList = classList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
}
