import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Demo5 {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add("ff");
		list.add("new");
		list.add("livelice");
		list.add("pro");
		list.add("cpc");
		
		Collections.sort(list);
		printArr(list);
		
	}
	public static void printArr(List list) {
		for(Iterator iter=list.iterator();iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
}
