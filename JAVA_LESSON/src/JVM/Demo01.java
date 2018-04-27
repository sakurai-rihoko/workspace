package JVM;

public class Demo01 {
	static {
		System.out.println("静态初始化");
	}
	public static void main(String[] args) {
		A a = new A();
		System.out.println(A.width);
	}
}
class  A_Father{
	public A_Father() {

		// TODO Auto-generated constructor stub
		System.out.println("父类初始化");
	}
}





class A extends A_Father{
	public static int width = 10;
	static {
		System.out.println("静态初始化类");
		width= 300;
	}
	public A() {
		System.out.println("创建A类对象");
	}
}