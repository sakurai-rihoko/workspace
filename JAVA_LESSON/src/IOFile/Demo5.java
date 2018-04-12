package IOFile;

import java.io.File;
import java.util.Arrays;



/**
 * 输出子孙级目录|文件的名称（绝对路径）
 * 1.listFiles()
 * 2.递归
 * @author tokido_saya
 *
 */
public class Demo5 {
	public static void main(String[] args) {
		String path = "/Users/tokido_saya/Desktop/";
		File parent = new File(path);
		//printName(parent);

		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		for(File temp:roots) {
			printName(temp);
		}
	}
	public static void printName(File src) {
		if(src ==null || !src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) {
			for(File sub:src.listFiles())
			printName(sub);
		}
	}
}
