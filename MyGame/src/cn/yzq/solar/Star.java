package cn.yzq.solar;

import java.awt.Graphics;
import java.awt.Image;

public class Star {
	Image img;
	double x,y;
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img,(int)x,(int)y,null);
		
	}
	public Star() {
		
	}
	public Star(Image img,double x,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	public Star(String url,double x,double y) {
		this.img = GameUtil.getImage(url);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
}
