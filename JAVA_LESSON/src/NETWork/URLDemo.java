package NETWork;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
		public static void main(String[] args) throws MalformedURLException {
			URL url = new URL("http://bangumi.bilibili.com/22/");

			System.out.println("协议"+url.getProtocol());
			System.out.println("主机"+url.getHost());
			System.out.println("端口"+url.getPort());
			System.out.println("资源"+url.getFile());
			System.out.println("相对路径"+url.getPath());
			System.out.println("锚点"+url.getRef());//#之后的参数
			System.out.println("参数"+url.getQuery());//?之后的参数：存在锚点返回null，不存在返回正确



			URL url2 = new URL("https://www.bilibili.com/bangumi/");
			URL url3 = new URL(url2,"play/ep200012/");//相对路径
			System.out.println(url3.toString());

		}

}
