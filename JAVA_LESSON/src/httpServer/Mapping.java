package httpServer;

import java.util.ArrayList;
import java.util.List;

/*
 * <Servlet-mapping>
	<name>login</name>
	<url-pattern>/login</url-pattern>
   </Servlet-mapping>
 */
public class Mapping {
	private String name;
	private List<String> urlPattern;

	public  Mapping() {
		urlPattern = new ArrayList<String>();
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}


}
