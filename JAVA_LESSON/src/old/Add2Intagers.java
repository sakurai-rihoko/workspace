package old;
import acm.program.*;
import java.lang.Math;
public class Add2Intagers extends ConsoleProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static  final double PI =3.14;
	boolean p = (3>5);
	private static final int SENTINEL = 0;
	
	
     public void run (){
    	 println("this program adds two numbers"); 
    	 int n1 = readInt("Enter n1:");
    	 int n2 = readInt("Enter n2:");
    	 double avg = (double)n1 /n2;
    	 println("the avg is "+ avg + ".");
    	 
         int total = 0;
         
         while (true){
        	 int val = readInt("Enter your value:");
        	 if (val==SENTINEL)break;
        	 total = total + val ;
        	
        	
         }
    	 println("the total is "+ total+".");
    	 double num1 = 5.5;
         double sqrtnum = Math.sqrt(num1);	
         	println(sqrtnum);
    	 
    	 
     }
}
