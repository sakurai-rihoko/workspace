package NETWork;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPMySocket {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建客户端
		Socket client = new Socket("localhost", 9988);
		//2.双向处理数据
		//接收
//		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//		System.out.println(br.readLine());
		DataInputStream dr = new DataInputStream(client.getInputStream());
		System.out.println(dr.readUTF());

	}
}
