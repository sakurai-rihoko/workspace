package Reference;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

/**
 * EnumMap要求key为枚举、常量
 * @author tokido_saya
 *
 */
public class EnumMapDemo {
	public static void main(String[] args) {
		
		EnumMap<Season, String>  emap = new EnumMap<Season,String>(Season.class);
		emap.put(Season.SPRING, "春");
		emap.put(Season.SUMMER, "夏");
		emap.put(Season.AUTUMN, "aki");
		emap.put(Season.WINNER, "fuyou");
		Set keys = emap.keySet();
		for(Iterator iter = keys.iterator();iter.hasNext();) {
			Enum<Season> f = (Enum<Season>) iter.next();
			System.out.println("key:"+f + "value:"+emap.get(f));
		}
		System.out.println(emap.size());
		
	}
	
	enum Season{
		SPRING,SUMMER,AUTUMN,WINNER
	}
}
