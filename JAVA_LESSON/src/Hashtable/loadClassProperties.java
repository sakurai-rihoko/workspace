package Hashtable;

import java.io.IOException;
import java.util.Properties;

public class loadClassProperties {
	public static void main(String[] args) throws IOException {
		Properties pro1 = new Properties();
		//类相对路径，当前指向bin目录
		pro1.load(loadClassProperties.class.getResourceAsStream("/test.properties"));
		pro1.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/test.properties"));
		System.out.println(pro1.getProperty("url"));
	}
}
