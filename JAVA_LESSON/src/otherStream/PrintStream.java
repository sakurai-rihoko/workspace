package otherStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PrintStream {
/**
 * 打印流PrintStream
 * @throws IOException 
 */
	public static void main(String[] args) throws IOException {
		System.out.println("test");
		java.io.PrintStream ps = System.out;
		ps.println(false);
		InputStream  is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入");
		String msg = br.readLine();
		System.out.println(msg);
	}
}
