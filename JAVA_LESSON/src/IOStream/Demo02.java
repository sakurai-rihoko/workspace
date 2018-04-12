package IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
 * 1.建立联系 File对象 目的地
 * 2.选择流 文件输出流 OutputStream FileOutputStream
 * 3.操作：write()+flush
 * 4
 * @author tokido_saya
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "/Users/tokido_saya/Desktop/curl.py";
		output(path);
	}
	public static void output(String path) {
		File dest = new File(path);
		OutputStream os = null;
		try {
			//追加内容true 覆写false
			os = new FileOutputStream(dest,true);
			String str = "test the outputStream \r \n";
			//字符串转字节输出
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();//强制刷新弹出
 		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件关闭失败");
				}
			}
		}
	}
}
