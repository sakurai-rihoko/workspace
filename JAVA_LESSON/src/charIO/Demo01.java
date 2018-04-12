package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		File src = new File("/Users/tokido_saya/Desktop/curl.py");
		File dest = new File("/Users/tokido_saya/Desktop/curl2.py");
		copyFileChar(src, dest);
	}
	public static void copyFileChar(File src,File dest) throws IOException {
		FileReader is = null;
		FileWriter os = null;
		is = new FileReader(src);
		os = new FileWriter(dest);
		char[] ch = new char[1024];
		int len = 0;
		if((len = is.read(ch))!= -1) {
			String sb = new String(ch, 0, len);
			System.out.println(sb);
			os.write(ch, 0, len);
			os.flush();
		}

	}
}
