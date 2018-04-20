package NETWork;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 在InetAddress基础上封装端口
 * @author tokido_saya
 *
 */
public class InetSocketDemo {
		public static void main(String[] args) throws UnknownHostException {
			InetSocketAddress adds01 = new InetSocketAddress(InetAddress.getLocalHost(), 22);
			System.out.println(adds01.getHostName());
			System.out.println(adds01.getAddress());
			System.out.println(adds01.getPort());

			System.out.println("======================================");

			InetSocketAddress adds02 = new InetSocketAddress("www.qq.com", 80);
			System.out.println(adds02.getHostName());
			System.out.println(adds02.getAddress());
			System.out.println(adds02.getPort());

		}
}
