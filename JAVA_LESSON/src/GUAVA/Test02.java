package GUAVA;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.base.Function;
import com.google.common.base.Functions;
/**
 * 函数式编程
 * Predicate
 * Funtion
 * 工具：Collections2.filter（）过滤器
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.corba.se.spi.orbutil.fsm.Input;


public class Test02 {
	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("njsxt","good","iriya","rin","sakura","arutoriya");
		//限定长度
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				return input.length() > 5?input.substring(0, 5):input;
			}

		};
		//转大写
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				// TODO Auto-generated method stub
				return input.toUpperCase();
			}
		};
        //组合使用
		Function<String, String> f = Functions.compose(f1,f2);

		Collection<String> col = Collections2.transform(list, f);
		for(String temp:col) {
			System.out.println(temp);
		}

	}


/*
 * 过滤器
 */
	public static void test01() {
//创建List 静态初始化
		List<String> list = Lists.newArrayList("moom","son","dad","bjsxt","refer");
		//找出回文palindrome backwords mirrors words
		//匿名内部类对象：匿名内部类，同时创建对象
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String arg0) {
				// TODO Auto-generated method stub
				return new StringBuilder(arg0).reverse().toString().equals(arg0);
			}
		});

		for(String temp:palindromeList) {
			System.out.println(temp);
		}

	}

	/*
	 * 类型转换器
	 */
	public static void test02() {
		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(100000000L);
		timeSet.add(9999999999999L);
		timeSet.add(2000000000L);
		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {
		@Override
		public String apply(Long input) {
			// TODO Auto-generated method stub
			return new SimpleDateFormat("YYYY-MM-dd").format(input);
		}
	});
	   for (String temp:timeStrCol) {
		System.out.println(temp);
	}
	}
}
