package NETWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 *
 */
public class UDPMyServer {
	public static void main(String[] args) throws IOException {
		//1.创建服务端+端口
		DatagramSocket server = new DatagramSocket(9988);
		//2.创建准备接受的容器
		byte[] container = new byte[1024];
		//3.封装容器为包DatagramPacket（byte[] buf,buf.length)
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//4.接收数据
		server.receive(packet);
		//5.分析数据
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		server.close();

	}
}
