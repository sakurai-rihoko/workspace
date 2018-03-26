import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
public class fullCricle extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run(){
	
		add(filledcricle(300,400,100,Color.RED));
		
	}
	
	private GOval filledcricle(int x,int y,int r,Color color){
		GOval circle = new GOval(x-r,y-r,2*r,2*r);
		circle.setFilled(true);
		circle.setColor(color);
		return circle;
		
	}
	
}
