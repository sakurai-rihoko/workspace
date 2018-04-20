package NETWork;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPMyClient2 {
	public static void main(String[] args) throws IOException {
		//1.创建客户端+端口
		DatagramSocket client = new DatagramSocket(8899);
		//2.准备数据
		double ll = 89.12;
		//3.数据容器数组
		byte[] sendData = convert(ll);
		//4.打包（发送数据+数据长度+服务器信息）
		DatagramPacket packet = new DatagramPacket(sendData, sendData.length,new InetSocketAddress("localhost",9988));
		//4.发送
		client.send(packet);
		client.close();
	}
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data = bos.toByteArray();
		return data;

	}
}

