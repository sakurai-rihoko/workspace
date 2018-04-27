package reflection;

public class TestReflection01 {
	public static void main(String[] args) {
		String path = "annotation.AnnoStudent";
		try {
			Class<?> clz = Class.forName(path);
			//对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构会放到对应的Class对象中。
			//这个Class对象就像一面镜子一样，通过这面镜子可以看到对应类的全部信息
			System.out.println(clz);
			System.out.println(clz.hashCode());//反射对象只有一个

			Class<?> clz2 = Class.forName(path);
			System.out.println(clz2.hashCode());

			Class<?> clz3 = path.getClass();

			Class strClz = String.class;
			Class intClz = Integer.class;



			int[] arr01 = new int[10];
			int[] arr02 = new int[30];
			int[][] arr03 = new int[10][20];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());//一维数组与二维不同


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
