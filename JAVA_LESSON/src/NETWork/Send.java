package NETWork;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {

	 private BufferedReader console;
     //管道输出流
     private DataOutputStream dos;

     //用户姓名
     private String userName;

     //控制线程
     private boolean isRunning =true;
     public Send() {
            console =new BufferedReader(new InputStreamReader(System.in));
     }
     public Send(String userName,Socket client){
            this();
            this.userName = userName;
            send(this.userName);
            try {
                   dos =new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                   //e.printStackTrace();
                   isRunning =false;
                   CloseUtil.closeAll(dos,console);

            }
     }
     //1、从控制台接收数据
     private String getMsgFromConsole(){
            try {
                   return console.readLine();
            } catch (IOException e) {
                   //e.printStackTrace();
            }
            return "";
     }
     /**
      * 1、从控制台接收数据
      * 2、发送数据
     * @throws IOException
      */
     public void send(String tempMsg) {
            String msg = tempMsg;
            try {
                   if(null!=msg&& !msg.equals("")){
                          dos.writeUTF(msg);
                          dos.flush(); //强制刷新
                   }
            } catch (IOException e) {
                   //e.printStackTrace();
                   isRunning =false;
                   CloseUtil.closeAll(dos,console);
            }
     }


     @Override
     public void run() {
            //线程体
            while(isRunning){
                   send(getMsgFromConsole());
            }
     }



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
//
//				console.close();
//				chatDos.close();
//
//
//		}
//
//
//	}
//	//从控制台接受数据
//	private String getMsgFromConsole(){
//
//		try {
//			return console.readLine();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "";
//	}
//	public void chatSend() throws IOException {
//		String msg = getMsgFromConsole();
//
//		try {
//			if(msg!=null&&!msg.equals("")) {
//			chatDos.writeUTF(msg);
//			chatDos.flush();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			isRunning = false;
//			console.close();
//			chatDos.close();
//
//		}
//
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(isRunning) {
//
//		try {
//			chatSend();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		}
//
//	}

}
