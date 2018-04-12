package Convert;

import java.io.UnsupportedEncodingException;

public class Demo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//解码
		String str = "梨穂子";
		//编码
		byte[] data = str.getBytes();
		//编码与解码字符集相同
		System.out.println(new String(data));
		//字节数不完整，出现乱码
		System.out.println(new String(data,0,4));
		
		//不统一出现乱码
		data = str.getBytes("utf-8");
		System.out.println(new String(data));
		
		//指定解码编码
		byte[] data2 = str.getBytes("utf-8");
		str = new String(data2,"utf-8");
	}
}
