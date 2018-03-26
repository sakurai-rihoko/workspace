import acm.program.*;
import acm.graphics.*;

public class factorial extends ConsoleProgram {

	private int factorial(int n){
		int result = 1;
		for (int i = 1;i<= n;i++){
			result = result * i;
			
		}
		return result;
	}
	public void run(){
		 int x = 10;
		 println("x! = "+ factorial(x) );
		
	}
}
