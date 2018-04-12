package IO.Util;

import com.sun.xml.internal.ws.Closeable;

public class FileUtil {
	/*
	 * 工具类关闭
	 * 可变参数：.....只能形参最后一个位置,处理方式与数组一致
	 */
	public static void close(Closeable ... io) {
		for(Closeable temp:io) {

			try {
				if(temp != null) {
					temp.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//泛型方法
public static <T extends Closeable> void closeAll(Closeable ... io) {
for(Closeable temp:io) {

			try {
				if(temp != null) {
					temp.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
