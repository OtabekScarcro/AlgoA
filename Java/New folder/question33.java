
import java.util.Arrays;

class  question33
{
	public static void main(String[] args) 
	{
		int[] arr =  {6, 22, 68, 5, 14, 62, 55, 27, 60, 45, 3, 3, 7, 85};
		int a = 22;
		int b = 64;
		
		threeWayPartition(arr, a, b);
		

	}
	
	private static void threeWayPartition(int[] arr, int a, int b) {
		int len = arr.length;
		
		int st = 0, mid = 0, end = len-1;
		System.out.println(Arrays.toString(arr));
		System.out.println(a + " " + b);
		while(mid <= end) {
			if(arr[mid] < a){
				int k = arr[st];
				arr[st] = arr[mid];
				arr[mid] = k;
				st++;
				mid++;
			}
			else if(arr[mid] >= a && arr[mid] < b){
				mid++;
			}
			else if(arr[mid] >= b){
				int k = arr[mid];
				arr[mid] = arr[end];
				arr[end] = k;
				end--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
