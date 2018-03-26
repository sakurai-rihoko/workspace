package cn.PlaneGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	double x,y;
	int speed = 3;
	double degree;
	int width;
	int height;
	
	public Bullet() {
		this.width = 10;
		this.height = 10;
		this.degree = Math.random()*Math.PI*2;
		this.x = Constant.GAME_WIDTH/2;
		this.y = Constant.GAME_HEIGHT/2;
	}
	
	
	public void draw(Graphics g) {
		Color originColor = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y > Constant.GAME_HEIGHT -10 || y< 10) {
			degree = -degree;
		}
		if(x > Constant.GAME_WIDTH -10||x <10) {
			degree = Math.PI-degree;
		}
		
		
		g.setColor(originColor);
	}
	
}
