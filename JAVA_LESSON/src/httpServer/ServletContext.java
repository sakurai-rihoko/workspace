package httpServer;

import java.util.Map;

public class ServletContext {
	//为每个servlet取一个别名
	//login-->loginServlet
	private Map<String,Servlet> servlet;
	//url-->login
	//映射资源路径，多个如：log-->login,login-->login
	private Map<String, String> mapping;

	public ServletContext() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, Servlet> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}

}
