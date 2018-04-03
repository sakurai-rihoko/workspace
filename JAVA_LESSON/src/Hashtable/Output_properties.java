package Hashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * 使用Properties 读取，输出文件
 * 资源配置文件：
 * @author tokido_saya
 *
 */
public class Output_properties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro1 = new Properties();
		
		 pro1.setProperty("driver","oracle.jdbc.driver.OracleDriver");
		 pro1.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
		 pro1.setProperty("user", "scott");
		 pro1.setProperty("pwd", "tiger");
		 
		 
		String url= pro1.getProperty("url", "test");
		System.out.println(url);
		
		pro1.store(new FileOutputStream(new File("/Users/tokido_saya/Downloads/test.properties")), "DB配置");
		pro1.store(new FileOutputStream(new File("/Users/tokido_saya/Downloads/test.xml")), "DB配置");
		pro1.store(new FileOutputStream(new File("src/test.properties")), "DB配置");
		
		
		
		Properties proload = new Properties();
		proload.load(new FileReader("/Users/tokido_saya/Downloads/test.properties"));
		System.out.println(proload.getProperty("url"));
	}
}
