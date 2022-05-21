/*
A Dual Pivot QuickSort Algorithm
*/
public class ImprovedQSort 
{
	public static void sort(int[] arr) {qSort(arr,0,arr.length-1);}

	private static void qSort(int[] arr, int start, int end)
	{
		if(start < end)
		{
			int[] indices = partition(arr, start, end);

			qSort(arr,start,indices[0]); // Sort left side
			qSort(arr,indices[0]+1,indices[1]-1); // Sort middle
			qSort(arr,indices[1],end);   // Sort right side
		}
	}

	/*
	Index is used to keep track of middle index since the location of the index will shift
	Continuosly swap data on left or right side of pivot location until all data is sorted
	Then return to main recursive function with index of mid point and sort for left and right sides
	*/
	private static int[] partition(int[] arr, int low, int high)
	{
		if(arr[low] > arr[high])
			swap(arr,low,high);

		int lowVal = arr[low], highVal = arr[high], lowIndex = low, highIndex = high;

		for(int i = low+1; i < high; i++)
		{
			if(i == highIndex) 
				return new int[]{lowIndex,highIndex};
			if(arr[i] < lowVal)
				swap(arr,i,lowIndex++);
			else if(arr[i] > highVal)
				swap(arr,i,highIndex--);
		}
		return new int[]{lowIndex,highIndex};
	}

	private static void swap(int[] arr, int i1, int i2)
	{
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
}
