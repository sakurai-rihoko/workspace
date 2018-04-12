package Commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

import javafx.beans.binding.StringBinding;



/**
 * bag包允许重复
 * 1.HashBag 无序
 * 2.TreeBag 有序
 * @author tokido_saya
 *
 */


public class Demo8 {
	public static void main(String[] args) {
		
	}
	
	//uniqueSet统计
	public static void uniqueSet1() {
		//包，分割字符 uniqueSet
		String str = "More information can be found on the Apache Commons Collections homepage. The JavaDoc can be browsed"
				+ ". Questions related to the usage of Apache Commons Collections should be posted to the user mailing list.";
		String[] strArray = str.split(" ");
		Bag<String> bag = new HashBag<String>();
		for(int i = 0;i < strArray.length;i++) {
			bag.add(strArray[i]);
		}
		Set<String> letter = bag.uniqueSet();

		for(String temp:letter) {
			System.out.println(temp+"\n"+"count"+bag.getCount(temp));
		}
	}
//有序包
	public static void TreeBag() {
		Bag<String> bag = new TreeBag<String>();
		bag.add("b",4);
		bag.add("e",3);
		bag.remove("e",2);
		bag.add("a",5);
		Iterator<String> it = bag.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 无序包
	 */
	public static void HashBag() {
		Bag<String> bag = new HashBag<String>();
		bag.add("a",5);
		Iterator<String> it = bag.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
