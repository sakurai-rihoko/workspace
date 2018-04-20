package httpServer;

import java.util.Map;

public class WebApp {
private static ServletContext context;
static {
	context = new ServletContext();
	Map<String,String> mapping = context.getMapping();
	mapping.put("/login", "login");
	mapping.put("/Log", "login");
	mapping.put("/reg", "login");

	Map<String,Servlet> servlet = context.getServlet();
//	servlet.put("login", new )
	

}

}
