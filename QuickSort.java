// Single Pivot QuickSort
public class QuickSort 
{
	public static void sort(int[] arr) {qSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr, boolean rev) {qSort(arr,0,arr.length-1,rev);}

	private static void qSort(int[] arr, int start, int end, boolean rev)
	{
		if(start < end)
		{
			int index = partition(arr, start, end, rev);

			qSort(arr,start,index-1,rev); // Sort left side
			qSort(arr,index+1,end,rev);   // Sort right side
		}
	}

	private static int partition(int[] arr, int low, int high, boolean reverse)
	{
		int mid = low + (high-low)/2, val = arr[mid], index = low-1;

		arr[mid] = arr[high];
		arr[high] = val;

		if(reverse)
		{
			for(int i = low; i < high; i++)
			{
				if(arr[i] > val)
				{
					index++;
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}
		else
		{
			for(int i = low; i < high; i++)
			{
				if(arr[i] < val)
				{
					index++;
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}
		
		arr[high] = arr[index+1];
		arr[index+1] = val;
		return index+1;
	}
}
