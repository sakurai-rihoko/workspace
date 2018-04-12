package Convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流：字节转为字符
 * 1.输出流：OutputStreamWriter编码
 *
 * 2.输入流：InputStreamReader 解码
 * @author tokido_saya
 *
 */
public class Demo02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("/Users/tokido_saya/Desktop/curl.py")
								)
						)
				);

		String info = null;
		while((info=br.readLine())!= null) {
			System.out.println(info);
		}
		br.close();
	}
}
