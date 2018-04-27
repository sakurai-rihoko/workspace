package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//加载时反射读取
public @interface annotationDemo01 {
	String studentName() default "";//返回参数定义
	int age() default 0;
	int id() default -1;//-1表示不存在


	String[] schools() default{"lx","lv"};
	//String value();//只有一个参数是建议使用value
}
