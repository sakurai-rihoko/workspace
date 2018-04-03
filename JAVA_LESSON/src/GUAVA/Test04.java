package GUAVA;
/**
 * 集合的操作：交集，差集，并集
 * @author tokido_saya
 *Sets.intersection
 *Sets.difference
 *Sets.union
 */

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class Test04 {
	public static void main(String[] args) {
		Set<Integer> set1 = Sets.newHashSet(15,34,55,33,67);
		Set<Integer> set2 = Sets.newHashSet(25,15,55,100,99);
		//交集

		System.out.println("交集为:");
		SetView<Integer> intersection = Sets.intersection(set1, set2);

		for(Integer temp:intersection) {
			System.out.println(temp);
		}
		//差集
		System.out.println("差集为:");
		SetView<Integer> diff = Sets.difference(set1, set2);

		for(Integer temp:diff) {
			System.out.println(temp);
		}
		//并集
		System.out.println("并集集为:");
		SetView<Integer> union = Sets.union(set1, set2);

		for(Integer temp:intersection) {
			System.out.println(temp);
		}

	}



}
