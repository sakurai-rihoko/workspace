package httpServer;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	//为每个servlet取一个别名
	//login-->loginServlet，包名+类名完整地址
	private Map<String,String> servlet;
	//url-->login
	//映射资源路径，多个如：log-->login,login-->login
	private Map<String, String> mapping;



	public ServletContext() {
		super();
		this.servlet = new HashMap<String,String>();
		this.mapping = new HashMap<String,String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}

}
