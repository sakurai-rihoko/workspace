import java.lang.reflect.Array;

public class BobSort {
	public static void main(String[] args) {
		int arr[] = {9,8,7,6,5,4,3,2,1};
		bobSort(arr);
		printArr(arr);
		
	}
	public static void bobSort(int arr[]){
		boolean sorted = true;
		for(int i = arr.length -1;i > 0;i--) {
			
				sorted =true;//交换参数
					for(int j = 0;j <i ;j++) {		
						if(arr[j] > arr[j+1]) {
							int temp = arr[j+1];
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
	public static void printArr(int arr[]) {
		for(int i = 0;i < arr.length;i ++) {
			System.out.println(arr[i]);
		}
	}
}
