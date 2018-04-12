package IOFile;

import java.io.File;
import java.io.IOException;

/**
 * 常用的方法
 * 1.文件名
 * getName()文件名，路径名
 * getPath()路径名
 * getAbsolueFile()绝对路径所对应的File对象
 * getAbsolutePath()绝对路径名
 * getParent()父目录，相对路径父目录，可能为null如，删除本身后的结果
 * 2.判断信息
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute():消除平台差异，ie以盘符开头，其他以/开头
 *3.长度
 *length()//不能读取文件夹长度
 *4.创建文件，文件夹
 *createNewFile();
 *5.删除文件delete();
 * @author tokido_saya
 *
 */
public class Demo03 {
	public static void main(String[] args) throws InterruptedException {
		test1();
		test02();
		try {
			test03();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件操作失败");
		}
	}
	public static void test1() {
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
		System.out.println(src3.getAbsolutePath());
		System.out.println(src3.getParent());//无父路径
	}
	//判断信息
	public static void test02() {
		String parentPath = "/Users/tokido_saya/Desktop/curl.py";
		File py = new File(parentPath);
		System.out.println("文件是否存在:" +py.exists());
		System.out.println("文件是否可读可写"+py.canWrite()+"\t" + py.canRead());
		//判断文件还是文件夹
		if(py.isFile()) {
			System.out.println("该对象是文件isFile！");
		}else if(py.isDirectory()){
			System.out.println("该对象是文件夹isDiretory");//没有真实存在的默认为文件夹
		}
		System.out.println(py.isAbsolute());
		System.out.println(py.length());
	}
	public static void test03() throws IOException, InterruptedException {
		//createNewFile()不存在创建新文件
		String path = "/Users/tokido_saya/Desktop/test.py";
		File src = new File(path);

		if(!src.exists()) {
			boolean flag = src.createNewFile();//存在返回false
			System.out.println(flag?"成功":"失败");
		}
		//删除文件
		boolean flag2 = src.delete();
		System.out.println(flag2?"成功":"失败");

		File temp = File.createTempFile("tes", ".py",new File("/Users/tokido_saya/Desktop/"));
		Thread.sleep(1000);
		temp.deleteOnExit();//程序退出删除

	}
}
