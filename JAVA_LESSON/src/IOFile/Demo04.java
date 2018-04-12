package IOFile;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5.操作目录
 * mkdir()创建目录，必须确保父目录存在，如果不存在，则创建失败
 * mkdirs()如果父目录不存在一同创建
 * list()文件|目录字符串形式,列出文件
 * listFiles()子文件，子目录
 * static listRoots根路径
 * @author tokido_saya
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		testListDir();


	}
	public static void testMkdir() {
		String path = "/Users/tokido_saya/Desktop/test";//确保父路径存在
		File srcDir = new File(path);
		srcDir.mkdir();
		srcDir.mkdirs();
	}
	public static void testListDir() {
		String path = "/Users/tokido_saya/Desktop/";
		File src = new File(path);
		File srcFile[] = src.listFiles();
		if(src.isDirectory()) {
			String subNames[] = src.list();
			for(String str:subNames) {
			System.out.println(str);
			}
		}
		for(File temp:srcFile) {
			System.out.println(temp.getAbsolutePath());
		}
		
		//提供过滤器
		File srcFile2[] = src.listFiles(new FilenameFilter() {
			//dir代表src
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				//return name.endsWith(".py");
				return new File(dir,name).isFile()&&name.endsWith(".py");
			}
		});
		for(File temp:srcFile2) {
			System.out.println(temp.getAbsolutePath());
		}

	}
}
