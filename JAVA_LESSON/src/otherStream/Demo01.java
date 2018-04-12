package otherStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组，节点流
 * 数组的长度有线，数据量不高
 * 1.文件-->程序->字节数组
 * 2.字节数组-》程序-》文件
 * @author tokido_saya
 *
 */
public class Demo01 {
	public static void main(String[] args) throws IOException {
		ByteArrayRead();
	}
	/**
	 * 输入流操作与文件输入流操作一致
	 * 读取字节数组
	 * @throws IOException
	 */
	public static void ByteArrayRead() throws IOException {
		String msg = "输入流操作与文件输入流操作一致";
		byte [] src = msg.getBytes();//-->byte化替代File化
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));

		byte[] flush = new byte[1024];
		int len = 0;
		while((len=is.read(flush))!= -1){
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}
	/**
	 * 输出流操作与文件输出流有所不同，有新增方法，不能使用OutputStream多态
	 * @throws IOException 
	 */
	public static byte[] ByteArrayWrite() throws IOException {
		byte[] dest;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "输入流操作与文件输入流操作一致";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
		dest = bos.toByteArray();
		bos.close();
		return dest;
	}
}
