import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
public class Glabel_mid extends GraphicsProgram {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run(){
    	 GLabel label = new GLabel("吔屎啦，梁非凡");
    	 label.setFont("SansSerif-36");
    	 label.setColor(Color.RED);
    	 double x =(getWidth() - label.getWidth()) / 2;
    	 double y = (getHeight() - label.getAscent()) / 2;
    	 add(label,x,y);
    	 double d =30;
    	 double cx = 100;
    	 double cy = 100;
    	 GArc a1 = new GArc(d,d,0,245);
    	 a1.setFilled(true);
    	 a1.setFillColor(Color.BLUE);
    	 add(a1,cx-d/2,cy-d/2);
     }
}
