package cn.PlaneGame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class GameObject {
	double x,y;
	Image img;
	Boolean left,right,up,down;
	double speed;
	int width,height;
	public GameObject(double x, double y, Image img, double speed, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.img = img;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {
		
	}
	
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	public void move(KeyEvent e) {
		if(left) {
			x -= speed;
		
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	
	 public void addDirection(KeyEvent e) {
		 switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left = true;
				break;
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_RIGHT:
				right = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				default:
					break;
			}
	 }
	 
	 public void minusDirection(KeyEvent e) {
		 switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				default:
					break;
			}
	 }
}
