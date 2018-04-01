package Enumeration;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public class EnumerationDemo {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()) {
		System.out.println(en.nextElement());
		
		
		
		String emailStr = "yzq991328@cloud.com;yzq991328@gmial.com;294994874@qq.com";
		StringTokenizer tokenizer = new StringTokenizer(emailStr, ";");
		while(tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}
		}
	}
}
