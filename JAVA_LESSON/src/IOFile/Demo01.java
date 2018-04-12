package IOFile;

import java.io.File;

/**
 * 两个常用常量
 *
 * 路径分隔符: File.pathSeparator
 * 文件分割符： File.separator
 * @author tokido_saya
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径的表现形式,动态调整
		String path ="/Users/tokido_saya/Desktop/curl.py";
		String path2 = File.separator+"Users"+File.separator+"tokido_saya"+File.separator+"Desktop"+
				File.separator+"curl.py";
		
		System.out.println(path);
		System.out.println(path2);

	}
}
