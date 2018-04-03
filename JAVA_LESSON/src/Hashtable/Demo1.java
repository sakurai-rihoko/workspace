package Hashtable;

import java.util.Properties;

/**
 * properties资源文件的读写
 * @author tokido_saya
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		Properties pro1 = new Properties();
		
		 pro1.setProperty("driver","oracle.jdbc.driver.OracleDriver");
		 pro1.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
		 pro1.setProperty("user", "scott");
		 pro1.setProperty("pwd", "tiger");
		 
		 
		String url= pro1.getProperty("url", "test");
		System.out.println(url);
		
		
	}
}
