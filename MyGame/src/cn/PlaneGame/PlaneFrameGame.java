package cn.PlaneGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Date;

public class PlaneFrameGame extends MyGameFrame {
	Image bgImage = GameUtil.getImage("images/bg.png");
	Plane p = new Plane("images/plane.jpg",50,50);
	Date StartTime;
	Date OverTime;
	ArrayList bulletList = new ArrayList();
	 Explode exp ;
	
	public void paint(Graphics g) {
		g.drawImage(bgImage, 0, 0, null);
		p.draw(g);
		for(int i = 0; i < bulletList.size();i++) {
			Bullet b = (Bullet)bulletList.get(i);
		 boolean peng = b.getRect().intersects(p.getRect());
		   if(peng) {
			   
			   p.setLive(false);
			   
			  if(exp == null) {
			   OverTime = new Date();
			   exp = new Explode(p.x, p.y);
			  
			  }
			  exp.draw(g);
			   break;
		   }
		   if(!p.isLive()) {
			   long period = (OverTime.getTime() - StartTime.getTime())/1000;
			   printMessage(g, "GAME OVER", 50,100,150);
			   printMessage(g, "时间"+period+"秒", 50, 0, 0);
			   
		   }
		}
	}
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		StartTime = new Date();
		  
		
	}
	public static void main(String[] args) {
		new PlaneFrameGame().launchFrame();
	}
	class KeyMonitor extends KeyAdapter{
		@Override
		
		public void keyPressed(KeyEvent e) {
			System.out.println("按下：" + e.getKeyCode());
			p.addDirection(e);
				
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放：" + e.getKeyCode());
			p.minusDirection(e);
		}
	}
	
	public void printMessage(Graphics g,String str,int size,double x,double y) {
		   System.out.println(str);
		   Color orginColor = g.getColor();
		   g.setColor(Color.white);
		   Font f = new Font("宋体",Font.BOLD,size);
		   g.setFont(f);
		   g.drawString("GAME OVER",(int)x,(int)y);
		   g.setColor(orginColor);
	}
}
