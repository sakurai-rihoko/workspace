package httpServer;

public class LoginServlet extends Servlet{
	
	@Override
	public void doGet(Request request,Response response) throws Exception {
		
		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,welcome:");
		response.addResponseContent(request.getParamterValue("uname"));
		response.addResponseContent("</body></html>");
	}

	@Override
	public void doPost(Request request,Response response) throws Exception {
		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,welcome:");
		response.addResponseContent(request.getParamterValue("uname"));
		response.addResponseContent("</body></html>");
		
	}

}
