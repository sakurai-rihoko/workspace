package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.AnnoStudent;

/**
 * 应用反射API，获取类的信息
 * 通过反射API动态的操作类
 * @author tokido_saya
 *
 */
public class TestReflection {
	 public static void main(String[] args) {
		String path = "annotation.AnnoStudent";
		try {
			Class<AnnoStudent> clz =  (Class<AnnoStudent>) Class.forName(path);
			System.out.println(clz.getName());//获取包名+类名
			System.out.println(clz.getSimpleName());//获取类名
			//获取属性信息
     		Field f = clz.getDeclaredField("stuName");
     		Field[] fs = clz.getFields(); //只能获取public属性
     		Field[] afs = clz.getDeclaredFields();
     		System.out.println(f);
     		for(Field temp:afs) {
     			System.out.println(temp);
     		}
			//获取方法信息
            Method m1 = clz.getDeclaredMethod("getAge");
            Method m2 = clz.getDeclaredMethod("setAge",int.class);//重载寻找，paramType指参数类型
            Method[] ms = clz.getDeclaredMethods();
            for(Method temp:ms) {
     			System.out.println(temp);
     		}
			//获取构造器
            Constructor c1 = clz.getDeclaredConstructor();
            Constructor<AnnoStudent>[] c2 = (Constructor<AnnoStudent>[]) clz.getDeclaredConstructors();
            //动态操作
            //动态反射API调用构造方法
            AnnoStudent as = (AnnoStudent) clz.newInstance();//通过反射对象直接创建对象，实际是调用了无参构造方法
//            System.out.println(as);

            Constructor<AnnoStudent> annoC = clz.getDeclaredConstructor(int.class,String.class,int.class);
            AnnoStudent as2 = annoC.newInstance(1001,"rihoko",17);
            System.out.println(as2.getStuName());

            //反射API调用方法
            Method m3 = clz.getDeclaredMethod("getStuName");
            Method m4 = clz.getDeclaredMethod("setAge",int.class);
            System.out.println(m3.invoke(as2));
            m4.invoke(as2, 18);
            System.out.println(as2.getAge());

            //通过反射API获取属性
            Field af2 = clz.getDeclaredField("stuName");
            af2.setAccessible(true);//跳过属性安全检查访问private属性
            af2.set(as2, "sakurai_rihoko");//反射直接设置属性
            System.out.println(m3.invoke(as2));
            System.out.println(af2.get(as2));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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

	}
}
