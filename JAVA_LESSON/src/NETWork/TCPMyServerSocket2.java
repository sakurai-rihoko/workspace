package NETWork;
/**
 * 一对多Socket
 */
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMyServerSocket2 {
	public static void main(String[] args) throws IOException {
		//1.创建服务器端指定端口
		ServerSocket ms = new ServerSocket(9988);
		//2.接受阻塞式的链接
		while(true) {//循环接听
		Socket socket = ms.accept();
		System.out.println("link Start!");
		//3.双向处理数据
		 //发送
		String msg = "hello";
		//也可以使用Data流
		DataOutputStream dw = new DataOutputStream(socket.getOutputStream());
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//		bw.write(msg);
//		bw.newLine();
//		bw.flush();
		dw.writeUTF(msg);
		dw.flush();
		}

	}
}
