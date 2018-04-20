package NETWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;



/**
 * 创建会话服务器
 * @author tokido_saya
 *
 */
public class ChatServer {
	private java.util.List<MyChannel> channelList = new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {

		new ChatServer().start();
//		DataInputStream chatDis = new DataInputStream(server.getInputStream());
//		DataOutputStream chatResponse = new DataOutputStream(server.getOutputStream());
//		while(true) {
//			String msg = new String(chatDis.readUTF());
//
//			chatResponse.writeUTF(msg+"\t"+"i have received your message");
//			chatResponse.flush();
//		}
	}
	public void start() throws IOException {
		ServerSocket ms = new ServerSocket(9998);
		while(true) {
		Socket server = ms.accept();
		MyChannel channel = new MyChannel(server);
		channelList.add(channel);
		new Thread(channel).start();
		}
	}
private	class MyChannel implements Runnable{
	private DataInputStream chatDis;
	private DataOutputStream chatResponse;
	private boolean isRunning = true;
	private String name;

	public MyChannel(Socket server) {
		super();
		try {
			chatDis = new DataInputStream(server.getInputStream());
			chatResponse = new DataOutputStream(server.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CloseUtil.closeAll(chatDis,chatResponse);
			isRunning = false;
			channelList.remove(this);
		}

	}
	//读取数据
	private String receive() {
		String msg = "";

		try {
			msg = new String(chatDis.readUTF());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(chatDis,chatResponse);
			channelList.remove(this);

		}
		return msg;
	}

	//发送数据
	private void send(String msg) {
		String sendMsg = msg;
		try {
			if(sendMsg!=null&&!sendMsg.equals("")) {
			chatResponse.writeUTF(sendMsg+"\t"+"i have received your message");
			chatResponse.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(chatDis,chatResponse);
			channelList.remove(this);
		}

	}
//群转发
private void sendOther() {
	String msg = this.receive();
	//判断私聊
if(msg.startsWith("@")&&msg.indexOf(":")>-1) {
	String name = msg.substring(1,msg.indexOf(":"));
	String content = msg.substring(msg.indexOf(":")+1);
	for(MyChannel other:channelList) {
		if(other.name.equals(name)) {
			other.send(this.name+"对你说"+content);
		}
	}
	}else {


	//遍历容器寻找其他主机
	for(MyChannel other:channelList) {
		if(other == this) {
			return;
		}
		//发送给其他主机
		other.send(msg);
	}
  }
}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				send(receive());
				sendOther();

			}
		}

	}
}
