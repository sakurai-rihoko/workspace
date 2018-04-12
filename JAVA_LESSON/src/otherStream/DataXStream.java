package otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型（基本+String）处理流
 * 1.输入流DataInputStream
 * 2.输出流DataOutputStream
 * @author tokido_saya
 *
 */
public class DataXStream {
 public static void main(String[] args) throws IOException {
	// write("/Users/tokido_saya/Downloads/data.txt");
	 read("/Users/tokido_saya/Downloads/data.txt");
}
 //写入数据类型
 public static void write(String destpath) throws IOException {
	 File dest = new File(destpath);
	 double point =2.5;
	 long num=100L;
	 String str ="数据类型";
	 DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
	 dos.writeDouble(point);
	 dos.writeLong(num);
	 dos.writeUTF(str);
	 dos.flush();
	 dos.close();
 }
 //从文件读取数据类型
 public static void read(String srcPath) throws IOException {
	 File src = new File(srcPath);
	 DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(src)));
	 double num1 = is.readDouble();
	 Long num2 = is.readLong();
	 String str = is.readUTF();

	 System.out.println(num1);
	 System.out.println(num2);
	 System.out.println(str);
 }
}
