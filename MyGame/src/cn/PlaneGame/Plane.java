package cn.PlaneGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	double x,y;
	Image img;
	boolean left,right,up,down;
	double speed;
	int width,height;
	private boolean live = true;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g) {
		g.drawImage(img,(int)x,(int)y,null);
	}
	
	public Plane(String url,double x,double y) {
		super();
		this.img = GameUtil.getImage(url);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	
	
	
}
