package JVM;

public class Demo05 {
	public static void main(String[] args) {
		ClassLoader loader = Demo05.class.getClassLoader();
		System.out.println(loader);

		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);


		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("/Users/tokido_saya/Downloads/"));
		System.out.println(Thread.currentThread().getContextClassLoader());

//		Thread.currentThread().getContextClassLoader().loadClass("");
	}
}
