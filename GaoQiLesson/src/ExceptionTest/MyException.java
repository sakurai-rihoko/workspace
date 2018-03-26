package ExceptionTest;

public class MyException extends Exception{
	
	public MyException() {
		
	}
	
	public MyException(String message) {
		super(message);
	}
}
class TestMyException{
	void test() throws MyException{
		
	}
}
