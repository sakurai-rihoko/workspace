package Synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用collections管理同步容器
 * synchronizedList();
 * synchronizedSet();
 * synchronizedMap();
 * @author tokido_saya
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		List<String> synList = Collections.synchronizedList(list);
	}
}
