package httpServer;
/*
 * <Servlet>
	<Servlet-name>login</Servlet-name>
	<Servlet-class>httpServer.LoginServlet</Servlet-class>
   </Servlet>
 */
public class Entity {
	private String name;
	private String clz;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	
}
