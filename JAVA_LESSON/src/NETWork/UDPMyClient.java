package NETWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPMyClient {
	public static void main(String[] args) throws IOException {
		//1.创建客户端+端口
		DatagramSocket client = new DatagramSocket(8899);
		//2.准备数据
		String msg = "Hello";
		//3.数据容器数组
		byte[] sendData = msg.getBytes();
		//4.打包（发送数据+数据长度+服务器信息）
		DatagramPacket packet = new DatagramPacket(sendData, sendData.length,new InetSocketAddress("localhost",9988));
		//4.发送
		client.send(packet);
		client.close();
	}
}
