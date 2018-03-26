package cn.me.gameTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrameTest02 extends Frame{//GUI编程 AWT,SWING等
	/**
	 * 加载窗口
	 */
	Image img = GameUtil.getImage("images/sun.png");
	public void launchFrame() {
		setSize(500,500);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private double xPoint = 100,yPoint = 100;
	private boolean left;
	private boolean up;
	
	public void paint(Graphics p) {//Graphics is a paint mothods
//		System.out.println("paint!!!");
		
		p.drawImage(img,(int)xPoint,(int)yPoint,null);
		
	if(left) {
		xPoint -=3;
	}else {
		xPoint +=3;
	}
		if(xPoint > 500 -30) {
			left = true;
		}
		if(xPoint < 30) {
			left = false;
		}
		
		if(up) {
			yPoint -=3;
		}else {
			yPoint +=3;
		}
			if(yPoint > 500 -30) {
				left = true;
			}
			if(yPoint < 30) {
				left = false;
			}
		//yPoint +=1;
		
	}
	/**
	 * 重画窗口的线程类，内部类
	 * @author tokido_saya
	 *
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		GameFrameTest02 gf = new GameFrameTest02();
		gf.launchFrame();
		
	}

}
