package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import annotation.AnnoStudent;

public class genericityReflection {
	public void test01(Map<String, AnnoStudent> map,List<AnnoStudent> list) {
		System.out.println("reflection.genericityReflection.test01");
	}
	public Map<Integer,AnnoStudent> test02(){
		System.out.println("reflection.genericityReflection.test02");
		return null;
	}
	public static void main(String[] args) {
		try {
			Class<genericityReflection> clz = (Class<genericityReflection>) Class.forName("reflection.genericityReflection");
			//获得方法的参数的泛型
			Method m1 = clz.getMethod("test01", Map.class,List.class);
			Type[] t = m1.getGenericParameterTypes();
			for(Type paramType : t) {
				if(paramType instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType : genericTypes) {
						System.out.println("参数泛型类型" + genericType);
					}
				}
			}

			//获得方法的返回参数泛型
			Method m2 = clz.getMethod("test02", null);
			Type returnType = m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType) {
				Type [] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
				for(Type genericType : genericTypes) {
					System.out.println("返回参数泛型类型" + genericType);
				}
			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
