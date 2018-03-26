
import acm.graphics.*;
import acm.program.*;
import java.awt.Color;

public class drawclass extends GraphicsProgram{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int NROWS = 20;
    private static final int NCOLUMNS = 20;
    public void run(){
    	int sqSize = getHeight() / NROWS ;
        for (int i=0;i < NROWS;i++){
        	for (int j=0;j < NCOLUMNS;j++){
        		int x =  j * sqSize;
        		int y =  i * sqSize;
        		//坐标x，y
        		GRect CLASS = new GRect(x,y,sqSize,sqSize);
        		CLASS.setFilled((i+j) % 2 != 0);
                add(CLASS);        		
        	}
        
        }
     
    

    }
}
