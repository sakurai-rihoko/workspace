package httpServer;

import java.io.IOException;
import java.net.Socket;
/**
 * 抽象为一个父类
 * @author tokido_saya
 *
 */
public abstract class Servlet {
	public void service(Request request,Response response) throws Exception {
//		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,welcome:");
//		response.addResponseContent(request.getParamterValue("uname"));
//		response.addResponseContent("</body></html>");
		this.doGet(request,response);
		this.doPost(request,response);
	}

	public abstract void doGet(Request request,Response response) throws Exception;
	public abstract void doPost(Request request,Response response) throws Exception;
}
