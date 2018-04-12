package Commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * 双向MAP，要求键和值都不能重复
 * BidMap
 * 1.DualTreeBidMap:有序
 * 2.DualHashBidMap:无序 inverseBidiMap(),值查找
 * @author tokido_saya
 *
 */
public class Demo7 {
	public static void main(String[] args) {
		hashMap();
		treeMap();
	}
	/**
	 * 有序双向Map,按key排序
	 */
	public static void treeMap() {
		BidiMap<String, String> b1Map = new DualTreeBidiMap<String,String>();
		b1Map.put("chika", "riko");
		b1Map.put("hanamaru", "ruby");
		b1Map.put("dia", "mari");
		System.out.println(b1Map.inverseBidiMap().get("riko"));
		//inverseBidiMap() value当做key
		MapIterator<String, String> mapIter = b1Map.inverseBidiMap().mapIterator();
		while(mapIter.hasNext()) {
			String key = mapIter.next();
			String value = mapIter.getValue();
			System.out.println(key +"--"+value);
		}
	}



	/**
	 * 无序双向Map
	 */
	public static void hashMap() {
		BidiMap<String, String> b1Map = new DualHashBidiMap<String,String>();
		b1Map.put("chika", "riko");
		b1Map.put("hanamaru", "ruby");
		System.out.println(b1Map.inverseBidiMap().get("riko"));
		//inverseBidiMap() value当做key
		MapIterator<String, String> mapIter = b1Map.inverseBidiMap().mapIterator();
		while(mapIter.hasNext()) {
			String key = mapIter.next();
			String value = mapIter.getValue();
			System.out.println(key +"--"+value);
		}


	}
}
