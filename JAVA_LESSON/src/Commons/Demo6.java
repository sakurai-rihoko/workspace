package Commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 迭代器扩展
 * 1.MapInteator不用再使用map.keySet.entry
 * IterableMap HashedMap
 *2.UniqueFilterIterator 去重迭代器
 *3.filterIterator自定义过滤器
 *4.LoopingIterator循环过滤器
 *5.ArrayListIterator数组迭代器
 * @author tokido_saya
 *
 */
public class Demo6 {
	public static void main(String[] args) {
			mapIt();
			uniqueIt();
			filterIt();
			loopingIt();
			arrayListIter();
	}

	public static void arrayListIter() {
		int[] s = {1,2,3,4,5};

		//数组迭代器
		//Iterator<Integer> it = new ArrayListIterator<>(s);
		//指定范围
		Iterator<Integer> it = new ArrayListIterator<>(s,1,3);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
/**
 * 循环迭代器
 */
	public static void loopingIt() {
		List<Idol> list = new ArrayList<Idol>();
		list.add(new Idol("TakamiChika", 16));
		list.add(new Idol("SakurauchiRiko",16));
		list.add(new Idol("MatsuuraKanan",17));
		list.add(new Idol("KurosawaDia",17));
		list.add(new Idol("KurosawaRuby",15));
		list.add(new Idol("WatanabeYou",16));
		list.add(new Idol("TsushimaYoshiko",15));
		list.add(new Idol("KunikidaHanamaru",15));
		list.add(new Idol("OharaMari",17));

		Iterator<Idol> iter = new LoopingIterator(list);
		//有限循环
		for(int i = 0;i < 15 ;i++) {
			System.out.println(iter.next());
		}

//		//无限循环
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}

	}
	public static void  filterIt() {
		List<Idol> list = new ArrayList<Idol>();
		list.add(new Idol("TakamiChika", 16));
		list.add(new Idol("SakurauchiRiko",16));
		list.add(new Idol("MatsuuraKanan",17));
		list.add(new Idol("KurosawaDia",17));
		list.add(new Idol("KurosawaRuby",15));
		list.add(new Idol("WatanabeYou",16));
		list.add(new Idol("TsushimaYoshiko",15));
		list.add(new Idol("KunikidaHanamaru",15));
		list.add(new Idol("OharaMari",17));


		Predicate<Idol> pre = new Predicate<Idol>() {

			@Override
			public boolean evaluate(Idol arg0) {
				// TODO Auto-generated method stub
				return arg0.getAge() > 16;
			}

		};

		Iterator<Idol> iter = new FilterIterator(list.iterator(),pre);

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}




	/**
	 * 去重迭代器
	 */
	public static void uniqueIt() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("c");
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}
	public static void mapIt() {
		System.out.println("==========map迭代器============");
		IterableMap<String, String> iterMap = new HashedMap<String,String>();
		iterMap.put("youshiko","c");
		iterMap.put("dia", "c");
		iterMap.put("ruby", "a");
		MapIterator<String, String> mapIter = iterMap.mapIterator();
		while(mapIter.hasNext()) {
			System.out.println(mapIter.next() +"/"+mapIter.getValue());
		}

	}
}
