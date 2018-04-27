package Javaassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import sun.security.x509.AuthorityInfoAccessExtension;

/**
 * 测试javaAssist API
 * @author tokido_saya
 *
 */
public class Test02 {
	public static void test01() throws NotFoundException, IOException, CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("Javaassist.LoveLiveMember");

		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println(cc.getName());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());
	}
	//添加方法
public static void test02() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	ClassPool pool = ClassPool.getDefault();
	CtClass cc = pool.get("Javaassist.LoveLiveMember");

//	CtMethod m1 = CtNewMethod.make("public void wakai() {\n" +
//			"		this.age --;\n" +
//			"	}", cc);
	CtMethod m1 = new CtMethod(CtClass.intType,"add", new CtClass[] {CtClass.intType},cc);
	m1.setModifiers(Modifier.PUBLIC);//添加方法属性
	m1.setBody("{\n" +
			"		return age + $1;\n" +
			"	}");


	cc.addMethod(m1);
	Class<?> clz = cc.toClass();
	Object obj = clz.newInstance();
	Method m2 = clz.getDeclaredMethod("add", int.class);
	int  temp = (int) m2.invoke(obj, 1);
	System.out.println(temp);
}
//修改方法
public static void test03() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	ClassPool pool = ClassPool.getDefault();
	CtClass cc = pool.get("Javaassist.LoveLiveMember");
	CtMethod cm = cc.getDeclaredMethod("sayHey",new CtClass[] {CtClass.intType});
	cm.insertBefore("System.out.println($1);System.out.println(\"start\");");//在源方法体前添加新语句
	cm.insertAfter("System.out.println(\"end\");");//在源方法体后添加新语句
	cm.insertAt(29, "System.out.println(\"parse\");");//在具体行增加语句
	Class<?> clz = cc.toClass();
	Object obj = clz.newInstance();
	Method m2 = clz.getDeclaredMethod("sayHey", int.class);
	m2.invoke(obj,3);

}
public static void test04() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	ClassPool pool = ClassPool.getDefault();
	CtClass cc = pool.get("Javaassist.LoveLiveMember");
	CtField cf = new CtField(CtClass.intType, "pnum", cc);
	cf.setModifiers(Modifier.PRIVATE);
	cc.addField(cf);

	cc.getDeclaredField("pnum");

}
public static void test05() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException
{
	ClassPool pool = ClassPool.getDefault();
	CtClass cc = pool.get("Javaassist.LoveLiveMember");

	CtConstructor[] cs = cc.getConstructors();
	for (CtConstructor c : cs) {
	System.out.println(c.getLongName());
	}
}
public static void test06() {
//	ClassPool pool = ClassPool.getDefault();
//	CtClass cc = pool.get("Javaassist.LoveLiveMember");
//	Object[] all = cc.getAnnotations();
//	Author a = (Author)all[0];
//	String name = a.name();
//	 int year = a.year();
//	 System.out.println("name: " + name + ", year: " + year);

}

	public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//test01();
		//test02();//javaassist只能同一方法内只能定义调用一次 ,必须解冻cc.deforzen()
		//test03();
		test04();
	}
}
