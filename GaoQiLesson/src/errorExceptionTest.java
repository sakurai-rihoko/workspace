import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.security.action.OpenFileInputStreamAction;

public class errorExceptionTest {
	public static void main(String[] args) {
//		FileReader fr = null;
//		try {
//		fr = new FileReader("/Users/tokido_saya/Downloads/test.txt");
//		
//		char temp = (char)fr.read();
//		 System.out.println(temp);
//		
//		}catch(FileNotFoundException e) {
//			System.out.println("no found the file!");
//			e.printStackTrace();
//		}catch(IOException e) {
//			System.out.println("IO ERROR!");
//		
//		}finally {
//			System.out.println("finished");
//			try {
//				if(fr != null) {
//				fr.close();
//				}
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
		char ch;
	
			try {
				ch = new errorExceptionTest().openFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	char openFile() throws FileNotFoundException,IOException {
		FileReader fr = null;
		
		fr = new FileReader("/User/tokido_saya/Downloads/test.txt") ;
		char temp = (char)fr.read();
		System.out.println(temp);
		return temp;
	}
	
}
