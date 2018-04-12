package BufferIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo01 {
	public static void main(String[] args) {

	}
	public static void copyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
        if(src.isDirectory()) {//添加些判断优化

        	throw new IOException();

        }
		InputStream is = null;
		OutputStream os = null;

		is =new BufferedInputStream( new FileInputStream(src));
		os = new BufferedOutputStream(new FileOutputStream(dest));

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
