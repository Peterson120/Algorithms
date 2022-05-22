// SelectionSort
public class SelectionSort
{
	public static void sort(int[] arr) 				{sSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr, boolean rev) {sSort(arr,0,arr.length-1,rev);}

	private static void sSort(int[] arr, int start, int end, boolean reverse)
	{
		if(reverse)
		{
			for(int i = end; i > start; i--)
			{
				int smallest = 1000, index = 0;
				for(int j = i; j >= 0; j--)
				{
					if(arr[j] < smallest)
					{
						smallest = arr[j];
						index = j;
					}
				}
				int temp = arr[i];
				arr[i] = smallest;
				arr[index] = temp;
			}
			return;
		}

		for(int i = start; i <= end; i++)
		{
			int smallest = arr[i], index = i;
			for(int j = i; j <= end; j++)
			{
				if(arr[j] < smallest) 
				{
					smallest = arr[j];
					index = j;
				}
			}			
			int temp = arr[i];
			arr[i] = smallest;
			arr[index] = temp;
		}
	}
}
