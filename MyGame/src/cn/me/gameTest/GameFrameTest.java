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

public class GameFrameTest extends Frame{//GUI编程 AWT,SWING等
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
	
	double xPoint = 100;
	double yPoint = 100;
	
	public void paint(Graphics p) {//Graphics is a paint mothods
//		System.out.println("paint!!!");
		p.drawLine(100, 100, 200, 200);
		p.drawRect(200,200, 100, 100);
		p.drawOval(20, 40, 50, 50);
		p.drawOval(90, 60, 100, 200);
		Font f = new Font("宋体", Font.BOLD, 100);
		p.setFont(f);
		p.drawString("leile", 300, 400);
		p.fillRect(100, 200, 100, 200);
		Color c = p.getColor();
		p.setColor(Color.BLUE);
		p.fillOval(100, 100, 50, 50);
		p.drawImage(img,(int)xPoint,(int)yPoint,null);
		xPoint +=1;
		yPoint +=1;
		
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
		GameFrameTest gf = new GameFrameTest();
		gf.launchFrame();
		
	}

}
