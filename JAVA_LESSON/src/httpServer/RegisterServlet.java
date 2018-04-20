package httpServer;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,注册成功:");
		response.addResponseContent(request.getParamterValue("uname"));
		response.addResponseContent("</body></html>");
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,注册成功:");
		response.addResponseContent(request.getParamterValue("uname"));
		response.addResponseContent("</body></html>");
	}

}
