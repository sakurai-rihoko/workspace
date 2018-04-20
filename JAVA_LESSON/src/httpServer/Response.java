package httpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {

	public static final String CRLF = "\r\n";
	public static final String BLANK= " ";

	private StringBuilder headInfo;
	private StringBuilder responseContent;
	private int contentLength;
	private BufferedWriter bw;

	public Response() {
		headInfo = new StringBuilder();
		bw = null;
		this.responseContent =new StringBuilder();
		contentLength = 0;
	}

	public Response(StringBuilder responseContent) {
		this();
		this.responseContent = responseContent;
		contentLength = responseContent.toString().getBytes().length;

	}
	private void createHeadInfo(int code) {
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch (code) {
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("NOT Found");
		case 400:
			headInfo.append("Bad Request");
		default:
			break;
		}
		headInfo.append(CRLF);
		//2.HTTP响应头信息head
		headInfo.append("server:rihoko  Server/1.1.0").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
		//正文长度（重要）
	    headInfo.append("Content-Length:").append(contentLength).append(CRLF);
	    //正文之间的空行
	    headInfo.append(CRLF);
	}
	private String combineResponse() {
		String response = headInfo.append(responseContent).toString();
		return response;
	}
	public void pushToClient(Socket client,int code) throws IOException {
		 createHeadInfo(code);
		 bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		 bw.write(combineResponse());
		 bw.flush();
		 CloseUtil.close(bw);
	}
	public void addResponseContent(String sb) {
		responseContent.append(sb);
		contentLength = responseContent.toString().getBytes().length;
		
	}

}
