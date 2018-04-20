package NETWork;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*InetAddress类
 * 没有封装端口
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr01 = InetAddress.getLocalHost();//获取本机IP对象
		System.out.println(addr01.getHostAddress());//获取IP值
		System.out.println(addr01.getHostName());//获取计算机名
		System.out.println("======================================");
		InetAddress addr02 = InetAddress.getByName("www.163.com");//通过域名主机获取网络信息
		System.out.println(addr02.getHostAddress());//获取IP值
		System.out.println(addr02.getHostName());//获取计算机名,计算机名根据获取时的get决定
		System.out.println("======================================");
		InetAddress addr03 = InetAddress.getByName("115.239.210.27");//通过IP获取主机网络信息
		System.out.println(addr03.getHostAddress());//获取IP值
		System.out.println(addr03.getHostName());//获取计算机名

	}
}
