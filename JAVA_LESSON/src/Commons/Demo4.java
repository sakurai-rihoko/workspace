package Commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * common集合操作
 * 1.并集
 * 2.交集
 * 3.差集
 * @author tokido_saya
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);

		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(9);
		set2.add(2);
		set2.add(3);
		set2.add(5);

		//并集
		Collection<Integer> unionSet = CollectionUtils.union(set1, set2);
		for(Integer temp:unionSet) {
			System.out.println(temp);
		}
		System.out.println("==================================================");
		//交集
		Collection<Integer> intersectionSet = CollectionUtils.intersection(set1, set2);
		for(Integer temp:intersectionSet) {
			System.out.println(temp);
		}
		System.out.println("==================================================");
		//差集
		Collection<Integer> subtractSet = CollectionUtils.subtract(set1, set2);
		for(Integer temp:subtractSet) {
		System.out.println(temp);
		}
	}
}
