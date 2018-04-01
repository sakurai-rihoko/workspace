import javax.swing.text.Utilities;

public class ComparableDemo {
	public static void main(String[] args) {
		String str[] = {"aab","aad","adas","apax","ddd"};
		StringSort(str);
		printArr(str);
		System.out.println("==============================================");
		String str2[] = {"aab","aad","adas","apax","ddd"};
		UtilComparableTool.sortbydescend(str2, new ComparaOverrideString());
		printArr(str2);
		
	}
	public static void StringSort(String arr[]){
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
							String temp = arr[j+1];
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
	public static void printArr(String arr[]) {
		for(int i = 0;i < arr.length;i ++) {
			System.out.println(arr[i]);
		}
	}
}
