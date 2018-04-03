package Reference;

import java.lang.ref.WeakReference;

/**
 * 引用分类：强，软，弱，虚
 * 强与弱引用
 * 
 * @author tokido_saya
 *
 */
public class refDEmo {
	public static void main(String[] args) {
		//字符串常量池共享不能回收
//		String str = "bjsxt is very good";
		//弱引用管理对象可回收
		String str  = new String("bjsxt is very good");
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前"+wr.get());
		str = null;
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后"+wr.get());
	}
}
