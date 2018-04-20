package httpServer;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response res;
	private int code = 200;

	public Dispatcher(Socket client) {
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			res= new Response();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			code = 500;

		}

	}

	public Request getReq() {
		return req;
	}

	public void setReq(Request req) {
		this.req = req;
	}

	public Response getRes() {
		return res;
	}

	public void setRes(Response res) {
		this.res = res;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		Servlet s1 = new LoginServlet();
		try {
			s1.service(req, res);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			res.pushToClient(client, code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				res.pushToClient(client, 500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		CloseUtil.close(client);
	}

}
