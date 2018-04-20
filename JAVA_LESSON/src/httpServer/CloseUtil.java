package httpServer;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	public static void close(Closeable...IO) {
		for(Closeable temp:IO) {
			if(temp!=null) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
