package com.yzq;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebApp {
private static ServletContext context;
static {

	try {
		context = new ServletContext();
		//获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//获取解析器
		SAXParser sax = factory.newSAXParser();
		//指定xml+处理器
		WebHander hander = new WebHander();
		sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("httpServer/web.xml")
		,hander);
		Map<String, String> map = context.getMapping();
		Map<String,String> servlet = context.getServlet();

		for(Entity temp:hander.getEntityList()) {
			//servlet-name  servlet-class
			servlet.put(temp.getName(), temp.getClz());
		}
		for(Mapping temp:hander.getMappingList()) {
			//url-pattern servlet-name
			List<String> urls = temp.getUrlPattern();
			for(String url:urls) {
				map.put(url, temp.getName());
			}

		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static Servlet getServlet(String url) {
	if((url==null)||(url.trim().equals(""))) {
		return null;
	}
	String mapServlet = context.getMapping().get(url);
	//反射机制-动态创建对象
	try {
		Class<?> clz = Class.forName(context.getServlet().get(mapServlet));
		Servlet ser = (Servlet)clz.newInstance();
		return ser;
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

}
