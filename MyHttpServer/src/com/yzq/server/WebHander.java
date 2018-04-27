package com.yzq.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHander extends DefaultHandler {
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	private Mapping mapping;
	private Entity entity;
	private String beginTag;
	private boolean isMap = true;



	@Override
	//文档解析
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		entityList = new ArrayList<Entity>();
		mappingList = new ArrayList<Mapping>();


	}

	@Override
	//文档解析结束
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();

	}
   //开始元素
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName != null) {
			beginTag = qName;
			if(qName.equals("Servlet")) {
				isMap = false;
				entity = new Entity();
			}else if(qName.equals("Servlet-mapping")) {
				isMap = true;
				mapping = new Mapping();
			}
		}


	}
//结束元素
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName != null) {
			if(qName.equals("Servlet")) {
				entityList.add(entity);
			}else if(qName.equals("Servlet-mapping")){
				mappingList.add(mapping);
			}
		}
		beginTag = null;
	}
//处理内容
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(beginTag != null) {
			String str = new String(ch,start,length);
			if(isMap) {
				if(beginTag.equals("name")) {
					mapping.setName(str);
				}else if(beginTag.equals("url-pattern")) {
					mapping.getUrlPattern().add(str);

				}
			}else {
				if(beginTag.equals("Servlet-name")) {
                     entity.setName(str);
				}else if(beginTag.equals("Servlet-class")) {
					entity.setClz(str);
				}
			}
		}
	}
	
	public List<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Entity> entityList) {
		this.entityList = entityList;
	}

	public List<Mapping> getMappingList() {
		return mappingList;
	}

	public void setMappingList(List<Mapping> mappingList) {
		this.mappingList = mappingList;
	}

	//检查解析
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//		//获取解析工厂
//		SAXParserFactory factory = SAXParserFactory.newInstance();
//		//获取解析器
//		SAXParser sax = factory.newSAXParser();
//		//指定xml+处理器
//		WebHander hander = new WebHander();
//		sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("httpServer/web.xml")
//				,hander);
//
//		for(Entity temp:hander.entityList) {
//			System.out.println(temp.getName()+"----->"+temp.getClz());
//		}
//		for(Mapping temp:hander.mappingList) {
//			System.out.println(temp.getName()+"------>"+temp.getUrlPattern().toString());
//		}
//
//	}

}
