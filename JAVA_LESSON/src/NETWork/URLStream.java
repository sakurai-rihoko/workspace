package NETWork;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 获取资源源代码:URL爬虫
 * @author tokido_saya
 *
 */
public class URLStream {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.bilibili.com/video/av22070506?t=1325");
		InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1) {
			System.out.println(new String(flush,0,len));
		}
		is.close();


		//转码流
		BufferedReader br = new BufferedReader(new  InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/tokido_saya/Downloads/bili.html")),"utf-8"));
		String msg = null;
		while((msg=br.readLine())!=null) {
			System.out.println(msg);
//			bw.write(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
