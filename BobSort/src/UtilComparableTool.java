import java.util.Comparator;
import java.util.List;

public class UtilComparableTool {
	public static void sort(Object arr[]){
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
							Object temp = arr[j+1];
							arr[j +1] = arr[j];
							arr[j] = temp;
							sorted = false;
						}			
					}
					if(sorted) {//检查是否交换
						break;
					}
				}
		
	}
	
	
	//泛型方法
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
							T temp = arr[j+1];
							arr[j +1] = arr[j];
							arr[j] = temp;
							sorted = false;
						}			
					}
					if(sorted) {//检查是否交换
						break;
					}
				}
	}
	
	//容器排序
	
	public static <T extends Comparable<T>> void listSorted(List<T> list) {
		//第一步：转成数组
		Object[] arr = list.toArray();
		sort(arr);
		//第二步，返回值给容器
		for(int i = 0;i < arr.length;i++) {
			list.set(i, (T) arr[i]);
		}
		
	}
	
	
	/**
	 * 数组降序+compare接口
	 */
	public static void sortbydescend(Object[] arr,Comparator com) {
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(com.compare(arr[j+1],arr[j]) < 0) {
							Object temp = arr[j+1];
							arr[j +1] = arr[j];
							arr[j] = temp;
							sorted = false;
						}			
					}
					if(sorted) {//检查是否交换
						break;
					}
				}
	}
	
	
}
