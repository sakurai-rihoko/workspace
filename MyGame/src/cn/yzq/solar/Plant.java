package cn.yzq.solar;

import java.awt.Graphics;
import java.awt.Image;

public class Plant extends Star{
	//坐标，图片。行星沿椭圆方向运行：长轴，短轴，速度。绕着Star飞
	double longAxis;
	double shortAxis;
	double speed;
	Star center;
	double degree;
	
	
	public Plant(String url, double longAxis, double shortAxis, double speed, Star center) {
		this.img = GameUtil.getImage(url);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y + shortAxis;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public void draw(Graphics g) {
		g.drawImage(img,(int)x,(int)y,null);
		x = (center.x+center.width/2) + longAxis*Math.cos(degree);
		y = (center.y+center.height/2) + shortAxis*Math.sin(degree);
		degree += speed;
		
	}

	public Plant(Image img,double x,double y) {
		super(img, x, y);
	}
	
	public Plant(String url,double x,double y) {
		super(url, x, y);
	}
	
	
}
