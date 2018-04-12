package IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * 1.建立联系File对象
 * 2.选择流，文件输入流 InputStream FileInputStream
 * 3.操作：byte[] car = new byte[1024] + read读取大小
 *   查看输出
 * 4.释放资源关闭
 *
 * @author tokido_saya
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		String path = "/Users/tokido_saya/Desktop/curl.py";
		inputRead(path);
	}
	public static void inputRead(String path) {
		File src = new File(path);
		InputStream is = null;//提升作用域
		try {
			 is = new FileInputStream(src);
			 //操作不断读取缓冲数组
			 byte[] car = new byte[10];
			 //实际接收读取大小；
			 int len = 0;
			 StringBuilder sb = new StringBuilder();
			 while((len = is.read(car)) != -1) {
				 String info = new String(car, 0, len);
				 System.out.println(info);
				 sb.append(info);
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读取失败");
		}finally {
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件关闭失败");
				}
			}
		}
	}
}
