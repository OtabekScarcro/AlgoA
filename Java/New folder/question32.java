class question32 
{
	public static void main(String[] args) 
	{
		
		int arr[] = {6, 3, 4, 5, 4, 3, 7, 9};
		int x = 16;
		int n = arr.length;
		smallestSubWithSum(arr, n, x);
	}

	private static void smallestSubWithSum(int[] arr, int len, int x){
		int sum = 0;
		int st = 0;
		int end = 0, temp=0;

		for(int i=0;i<len;i++)
		{
			sum += arr[i];
			if(sum > x)
			{
				if(end == 0){
					end = i;
				}
				temp = 0;
				while (sum > x)
				{
					sum -= arr[st];
					st++;
					temp++;
				}
				st--;
				temp--;
				if(i-end < temp){
					end = i;
				}
			}
		}
		System.out.println(end - st + 1);

	}
}
