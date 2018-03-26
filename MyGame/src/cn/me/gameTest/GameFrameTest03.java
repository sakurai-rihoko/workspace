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

public class GameFrameTest03 extends Frame{//GUI编程 AWT,SWING等
	/**
	 * 加载窗口
	 * test03实现随机弹
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
	private double degree = 3.14/3;//弧度[0,2pi];
	private double speed = 10;
	
	public void paint(Graphics p) {//Graphics is a paint mothods
//		System.out.println("paint!!!");
		
		p.drawImage(img,(int)xPoint,(int)yPoint,null);
		
		if(speed > 0) {
			speed  = speed -0.05;
		}
		xPoint +=speed*Math.cos(degree);
		yPoint +=speed*Math.sin(degree);
		if(yPoint > 500-30 || yPoint < 30) {
			degree = -degree;
		}
		
		if(xPoint < 0||xPoint > 500-30) {
			degree = Math.PI - degree;
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
		GameFrameTest03 gf = new GameFrameTest03();
		gf.launchFrame();
		
	}

}
