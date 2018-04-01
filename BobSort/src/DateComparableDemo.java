import java.util.Date;

public class DateComparableDemo {
	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);
//		DateSort(arr);
//		UtilComparableTool.sort(arr);
		UtilComparableTool.sort(arr);
		printArr(arr);
	}
	
	public static void DateSort(Date arr[]){
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
							Date temp = arr[j+1];
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
	public static void printArr(Date arr[]) {
		for(int i = 0;i < arr.length;i ++) {
			System.out.println(arr[i]);
		}
	}
}
