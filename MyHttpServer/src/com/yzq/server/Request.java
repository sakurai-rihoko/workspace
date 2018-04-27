package com.yzq.server;
/**
 * 接受请求信息
 * @author tokido_saya
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class Request {
	private String method;
	private String URL;
	//请求参数
	private Map<String, List<String>> param;
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;


	public Request() {
		method = "";
	    URL = "";
		param = new HashMap<String,List<String>>();
		is = null;
		requestInfo = "";
	}
	public Request(InputStream is) {
		this();
		this.is = is;
		byte[] data = new byte[2048000];
		try {
			int len = is.read(data);
			requestInfo = new String(data,0,len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		parseRequestInfo();

	}
	private void parseRequestInfo() {
		/**
		 * 分解request信息：首行分解请求方式，请求路径，请求参数（get）
		 */
		if(null == requestInfo || ((requestInfo = requestInfo.trim()).equals(""))){
			return;

		}
		String paramString = "";
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int end_idxofMethod = firstLine.indexOf("/");
		this.method = firstLine.substring(0,end_idxofMethod).trim();
	    String strURL = firstLine.substring(end_idxofMethod,firstLine.indexOf("HTTP")).trim();
	    URL = strURL;

		if(method.equalsIgnoreCase("POST")) {
			URL = strURL;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}else if(method.equalsIgnoreCase("GET")){
			//是否存在参数
			if(strURL.contains("?")) {
				String[] urlArray = strURL.split("\\?");
				URL = urlArray[0];
				paramString = urlArray[1];
			}
		}else {

		}
	    System.out.println("strURL:"+strURL+CRLF);
		System.out.println("URL:"+URL+CRLF);
		System.out.println("paramString:"+paramString+CRLF);
		System.out.println("method:"+method+CRLF);


		//2.将请求参数paramString封装到map param
		if(paramString.equals("")) {
			return;
		}

		parseParams(paramString);

	}
	private void parseParams(String paramString) {
		StringTokenizer token = new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()) {
			String keyValueStr = token.nextToken();
			String[] tempArray = keyValueStr.split("=");
			if(tempArray.length == 2) {
				String key = tempArray[0].trim();
				String value = (tempArray[1]==null)?null:decode(tempArray[1].trim(), "UTF-8");
				if(!param.containsKey(key)) {
			         param.put(key,new ArrayList<String>());
				}
				List<String> values = param.get(key);
				values.add(value);
			}else //其他格式参数，单一或多个
				{

			}
		}
	}
	/**
	 * 根据页面的name获取对应的值
	 */
	public String getParamterValue(String key) {
		List<String> values = null;
		if((values = param.get(key)) == null) {
			return null;
		}else {
			return new String(values.get(0));
		}
	}
	/**
	 * 根据页面的name获取对应的多个值
	 */
   public String[] getParamterValues(String key) {
	  List<String> values = null;
	  if((values = param.get(key)) == null) {
		return null;
	 }else {
		return values.toArray(new String[0]);
	 }
	 }
  //获取url
   public String getUrl() {
	   return URL;
   }
//获取method类型
   public String getMethod() {
	   return method;
   }


   //解码 code解码模式
   private String decode(String value,String code) {
	   try {
		return URLDecoder.decode(value, code);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
   }
}
