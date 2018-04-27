package JVM;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import httpServer.CloseUtil;

/**
 * 测试简单的加密解密（取反）操作
 * @author tokido_saya
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		int a = 3;
		System.out.println(Integer.toBinaryString(a^0xff));
	}
}
 class EncrptUtil{
	public static void encrpt(File src,File dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);

			int temp = 0;
//			byte[] flush = new byte[1024];
			while((temp = fis.read())!=-1) {
				fos.write(temp^0xff);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CloseUtil.close(fis,fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
 class DecrptClassLoader extends ClassLoader{
	//com.bjsxt.test.User   --> d:/myjava/  com/bjsxt/test/User.class
	 private String rootDir;

	 public DecrptClassLoader(String rootDir){
	 this.rootDir = rootDir;
	 }

	

	 private byte[] getClassData(String classname){   //com.bjsxt.test.User   d:/myjava/  com/bjsxt/test/User.class
	 String path = rootDir +"/"+ classname.replace('.', '/')+".class";

	//  IOUtils,可以使用它将流中的数据转成字节数组
	 InputStream is = null;
	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 try{
	 is  = new FileInputStream(path);



	 int temp = -1;
	 while((temp=is.read())!=-1){
	 baos.write(temp^0xff);  //取反操作,相当于解密
	 }

	 return baos.toByteArray();
	 }catch(Exception e){
	 e.printStackTrace();
	 return null;
	 }finally{
	 try {
	 if(is!=null){
	 is.close();
	 }
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 try {
	 if(baos!=null){
	 baos.close();
	 }
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 }

	 }

	}
 