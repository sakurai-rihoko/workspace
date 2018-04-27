package JVM;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

/**
 * 测试自定义的FileSystemClassLoader
 * @author tokido_saya
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader fsc = new FileSystemClassLoader("/Users/tokido_saya/Downloads");
		FileSystemClassLoader fsc2 = new FileSystemClassLoader("/Users/tokido_saya/Downloads");
		Class<?> cc = fsc.loadClass("test.test");
		Class<?> cc2 = fsc.loadClass("test.test");
		Class<?> cc3 = fsc2.loadClass("test.test");
		System.out.println(cc);
		System.out.println(cc.hashCode());
		System.out.println(cc2.hashCode());
		System.out.println(cc3.hashCode());//当同一个类被不同的类加载器加载时视为不同的类
	}
}
