package com.yzq.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK= " ";
	private boolean isRunning = true;
	//主线程
	public static void main(String[] args) {
		MyServer server01 = new MyServer();
		server01.start();

	}
//端口启动
	public void start(int port) {
		try {
	        server = new ServerSocket(port);
	        this.receive();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			stop();
		}
	}
	//启动
	public void start()  {

		start(9880);

	}
	//接受
	private void receive() {
		try {
			while(isRunning) {
			Socket client = server.accept();
			new Thread(new Dispatcher(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
		}
	}
	public void stop() {
       isRunning = false;
       CloseUtil.close(server);
	}
}
