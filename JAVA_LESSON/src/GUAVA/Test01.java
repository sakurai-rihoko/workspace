package GUAVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.ImmutableList;;
public class Test01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		List<String> readOnlyList = Collections.unmodifiableList(list);
//		readOnlyList.add("e");
		//改变原有的List 视图也一起改变,不够安全，任可以改变list
		list.add("e");
		System.out.println(readOnlyList.size());

		//Guava ImmutableList 不可再改变 对只读设置安全可靠，简单
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("e");








	}
}
