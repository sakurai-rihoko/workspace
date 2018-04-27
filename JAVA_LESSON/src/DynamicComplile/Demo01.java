package DynamicComplile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.google.common.collect.ImmutableList;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		//文件编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "/Users/tokido_saya/Downloads/Test01.java");
		System.out.println(result == 0?"编译成功":"编译失败");
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp /Users/tokido_saya/Downloads  Test01");
		InputStream in = process.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		String strp ="";
		while((strp = read.readLine())!=null) {
			System.out.println(strp);
		}
//反射加载


		try {
			URL[] urls = new URL[] {new URL("file:"+"/Users/tokido_saya/Downloads/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("Test01");
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[] {});//main方法传多个参数时需要传递数组
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//字符串编译
		//通过IO流存成临时文件
		String str = "public class Test01 {\n" +
				"	public static void main(String[] args) {\n" +
				"		List<String> list = new ArrayList<String>();\n" +
				"		list.add(\"a\");\n" +
				"		list.add(\"b\");\n" +
				"		list.add(\"c\");\n" +
				"		list.add(\"d\");\n" +
				"		List<String> readOnlyList = Collections.unmodifiableList(list);\n" +
				"//		readOnlyList.add(\"e\");\n" +
				"		//改变原有的List 视图也一起改变,不够安全，任可以改变list\n" +
				"		list.add(\"e\");\n" +
				"		System.out.println(readOnlyList.size());\n" +
				"\n" +
				"		//Guava ImmutableList 不可再改变 对只读设置安全可靠，简单\n" +
				"		List<String> immutableList = ImmutableList.of(\"a\",\"b\",\"c\");\n" +
				"		immutableList.add(\"e\");\n" +
				"	}\n" +
				"}";
	}
}
