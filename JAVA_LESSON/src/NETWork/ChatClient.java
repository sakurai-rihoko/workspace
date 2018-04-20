package NETWork;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 创建客户端
 * 写出数据
 * 读取数据
 *
 * 输入流与输出流在同一线程内应该独立处理
 * @author tokido_saya
 *
 */
public class ChatClient {
	public static void main(String[] args) throws UnknownHostException, IOException {


		System.out.println("请输入名称:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String yourName = br.readLine();
		Socket client01 = new Socket("localhost",9998);
		//单线程处理
//		DataOutputStream chatDos = new DataOutputStream(client01.getOutputStream());
//		DataInputStream chatDis = new DataInputStream(client01.getInputStream());
//		while(true) {
//		//键盘输入
//		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//		chatDos.writeUTF(console.readLine());
//		chatDos.flush();
//
//
//		String result = new String (chatDis.readUTF());
//		System.out.println(result);
//		}


		//多线程处理
		new Thread(new Send(yourName,client01)).start();
		new Thread(new Receive(client01)).start();

	}
}
//class Send implements Runnable{
//	private BufferedReader console;
//	private DataOutputStream chatDos;
//	private boolean isRunning = true;
//	public Send() {
//		console = new BufferedReader(new InputStreamReader(System.in));
//	}
//
//	public Send(Socket client) throws IOException {
//		this();
//		try {
//			chatDos = new DataOutputStream(client.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			isRunning = false;
//			if(!isRunning) {
//				console.close();
//				chatDos.close();
//			}
//
//		}
//
//
//	}
//	//从控制台接受数据
//	private String getMsgFromConsole(){
//		try {
//			return console.readLine();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "hello";
//	}
//	public void chatSend() {
//		if(getMsgFromConsole()!=null&&getMsgFromConsole().equals("")) {
//		try {
//			chatDos.writeUTF(getMsgFromConsole());
//			chatDos.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			isRunning = false;
//		}
//		}
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(isRunning) {
//
//		chatSend();
//
//		}
//
//	}
//
//}
//class Receive implements Runnable{
//	private DataInputStream chatDis;
//
//	private boolean isRunning = true;
//	public Receive() {
//
//	}
//	 public Receive(Socket client) throws IOException {
//		// TODO Auto-generated constructor stub
//		this();
//		try {
//			chatDis = new DataInputStream(client.getInputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			isRunning = false;
//			if(!isRunning) {
//				chatDis.close();
//
//			}
//		}
//
//
//	}
//
//	 public String chatReceive() {
//		 String msg = " ";
//		 try {
//			msg = chatDis.readUTF();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			isRunning = false;
//		}
//     return msg;
//	 }
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true) {
//
//			System.out.println(chatReceive());
//
//		}
//
//	}
//
//}
