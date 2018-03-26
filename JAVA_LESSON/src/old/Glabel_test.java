package old;

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;


public class Glabel_test extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run(){
		GLabel label = new GLabel("hello,bob",100,75);
		label.setFont("SanSerif-36");
		label.setColor(Color.RED);
		add(label);
		GLabel label2 = new GLabel("New,world",150,175);
		label2.setColor(Color.BLUE);
		add(label2);
		
	    GRect rect = new GRect(100,98,200,200);
        rect.setFilled(true);
        rect.setFillColor(Color.RED);
	
	    add(rect);
	      
	    GOval oval = new GOval(100,98,200,200);
	    oval.setFilled(true);
        oval.setFillColor(Color.green);
	    add(oval);
	
	}
	
	
	

}
