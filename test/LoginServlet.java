package com.yzq;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request request,Response response) throws Exception {

//		response.addResponseContent("<html><head><title>HTTP Response</title></head><body>it works,welcome:");
//		response.addResponseContent(request.getParamterValue("uname"));
//		response.addResponseContent("</body></html>");
		String name = request.getParamterValue("uname");
		String pwd = request.getParamterValue("pwd");

		if(loginCheck(name, pwd)) {
			response.addResponseContent("<html><head><title>HTTP Response</title></head><body>登入成功!欢迎回来:");
			response.addResponseContent(request.getParamterValue("uname"));
			response.addResponseContent("</body></html>");
		}
		else {
			response.addResponseContent("<html><head><title>HTTP Response</title></head><body>未知用户:");
			response.addResponseContent(request.getParamterValue("uname"));
			response.addResponseContent("</body></html>");
		}
	}

	@Override
	public void doPost(Request request,Response response) throws Exception {
		String name = request.getParamterValue("uname");
		String pwd = request.getParamterValue("pwd");

		if(loginCheck(name, pwd)) {
			response.addResponseContent("<html><head><title>HTTP Response</title></head><body>登入成功!欢迎回来:");
			response.addResponseContent(request.getParamterValue("uname"));
			response.addResponseContent("</body></html>");
		}
		else {
			response.addResponseContent("<html><head><title>HTTP Response</title></head><body>未知用户:");
			response.addResponseContent(request.getParamterValue("uname"));
			response.addResponseContent("</body></html>");
		}

	}
	//登录验证
	public boolean loginCheck(String name,String pwd) {
		return name.equals("yzq991328@gmail.com") && pwd.equals("123456");
	}

}
