package cn.yzq.solar;
/*
 * 太阳系主窗口
 */

import java.awt.Graphics;
import java.awt.Image;

public class SolarFrame extends MyGameFrame {
      Image bg = GameUtil.getImage("images/bg.jpg");
      Star sun = new Star("images/sun.png", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
      Plant earth = new Plant("images/earth.jpg", 400, 300, 0.1, sun);
      
      
      public void paint(Graphics g) {
    	   g.drawImage(bg, 0, 0, null);
    	   sun.draw(g);
    	   earth.draw(g);
      }
      public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
