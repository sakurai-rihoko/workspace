package IOFile;

import java.io.File;

/**
 * 相对路径和绝对路径构造File对象
 * 1.相对路径
 * File(String parent,String Child)
 * File(File parent,String Child)
 * 2.绝对路径
 * File(String name)
 * @author tokido_saya
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "/Users/tokido_saya/Desktop";
		String childPath = "curl.py";
		File src1 = new File(parentPath,childPath);
		File src2 = new File(new File(parentPath),childPath);
		System.out.println(src1.getName());
		System.out.println(src1.getPath());
		//如果没有加父路径则调用当前工作环境
		File src3 = new File("curl.py");
		System.out.println(src3.getName());
		System.out.println(src3.getPath());
		System.out.println(src1.getAbsolutePath());


	}

}
