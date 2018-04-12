package otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * 文件--程序->字节数组
 * 文件输入流
 * 字节数组输出流
 *
 * 字节数组--程序-文件
 * 字节数组输入流
 * 文件输出流
 * @author tokido_saya
 *
 */
public class Demo02 {
	public static void main(String[] args) throws IOException {
		File src = new File("/Users/tokido_saya/Desktop/curl.py");
		String str = new String(FileToByteArray(src), 0, FileToByteArray(src).length);
		System.out.println(str);
	}

	public static byte[] FileToByteArray(File src) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(src));//文件读取流
		ByteOutputStream bos = new ByteOutputStream();//字节数组输出流
		byte[] dest;

		//读取处理
		byte[] flush = new byte[10];
		StringBuilder sb = new StringBuilder();
		int len = 0;
		while((len = is.read(flush))!=-1) {
			sb.append(new String(flush,0,len));
		}

		//输出字节处理
		byte[] info = sb.toString().getBytes();
		bos.write(info,0,info.length);
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
       OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(destPath)));
       InputStream is = new BufferedInputStream(new ByteInputStream(src, src.length));
       byte[] flush = new byte[1024];
       int len = 0;
       while((len = is.read(flush))!=-1) {
    	   os.write(flush, 0, len);

       }
       os.flush();
       os.close();


 }
}
