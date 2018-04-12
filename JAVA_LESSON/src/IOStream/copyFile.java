package IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyFile {
	public static void main(String[] args) throws IOException {
      String srcPath = "/Users/tokido_saya/Desktop/销户证明.docx";
      String destPath = "/Users/tokido_saya/Desktop/销户证明2.docx";
      copyFile(srcPath, destPath);
	}
	public static void copyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
        if(src.isDirectory()) {//添加些判断优化

        	throw new IOException();

        }
		FileInputStream is = null;
		FileOutputStream os = null;

		is = new FileInputStream(src);
		os = new FileOutputStream(dest);

		byte[] car = new byte[1024];
		int len = 0;
		while((len=is.read(car)) != -1) {
			os.write(car, 0, len);//读出多少个写多少个
			os.flush();
		}
		os.close();
		is.close();

	}
}
