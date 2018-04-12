package BufferIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedChar {
public static void main(String[] args) {

}
public static void copyFileChar(File src,File dest) throws IOException {
	BufferedReader is = null;//新增方法不能使用多态，必须是原类
	BufferedWriter os = null;
	is =new  BufferedReader(new FileReader(src));
	os =new BufferedWriter( new FileWriter(dest));
	char[] ch = new char[1024];
	int len = 0;
	/**while((len = is.read(ch))!= -1) {
		String sb = new String(ch, 0, len);
		System.out.println(sb);
		os.write(ch, 0, len);
		os.flush();
	}**/
	String line = null;
	while((line = is.readLine())!=null) {
		os.write(line);
		os.newLine();//换行
	}
	os.flush();
	os.close();
	is.close();

}
}
