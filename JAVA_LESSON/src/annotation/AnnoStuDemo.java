package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author tokido_saya
 *
 */
public class AnnoStuDemo {
	 public static void main(String[] args) {
		 try {
			Class<?> clz = Class.forName("annotation.AnnoStudent");
			//获得类的所有注解
			Annotation[] annotations =  clz.getAnnotations();
			for(Annotation temp:annotations) {
				System.out.println(temp);
			}
			//获得指定注解
			AnnoTable at = (AnnoTable)clz.getAnnotation(AnnoTable.class);
			System.out.println(at.value());

			/*
			 * 获得类的属性注解
			 */
			//获取类反射
			Field f1 = clz.getDeclaredField("stuName");
		    AnnoField  af = f1.getAnnotation(AnnoField.class);
		    System.out.println(af.columnName()+"----"+af.type()+"----"+af.length());


		    //根据获得的表名信息，拼出DDL语句，然后，使用JDBC执行相关数据库操作


 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
