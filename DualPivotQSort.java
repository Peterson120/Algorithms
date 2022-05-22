// A Dual Pivot QuickSort Algorithm
public class DualPivotQSort 
{
	public static void sort(int[] arr) {qSort(arr,0,arr.length-1);}

	private static void qSort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int[] indices = partition(arr, l, r);

			qSort(arr,l,indices[0]-1); // Sort left side			
			qSort(arr,indices[0]+1,indices[1]-1); // Sort middle
			qSort(arr,indices[1]+1,r);   // Sort right side
		}
	}

	/*
	Index is used to keep track of middle index since the location of the index will shift
	Continuously swap data on left or right side of pivot location until all data is sorted
	Then return to main recursive function with index of mid point and sort for left and right sides
	*/
	private static int[] partition(int[] arr, int low, int high)
	{
		if(arr[low] > arr[high])
			swap(arr,low,high);

		int lowVal = arr[low], highVal = arr[high], lowIndex = low + 1, highIndex = high - 1;
		
		for(int i = lowIndex; i < highIndex; i++)
		{
			if(arr[i] < lowVal)
			{
				swap(arr,lowIndex,i);
				lowIndex++;
			}
			else if(arr[i] >= highVal)
			{
				while (arr[highIndex] > highVal && i < highIndex)
                	highIndex--;

				swap(arr,i,highIndex);
				highIndex--;

				if(arr[i] < lowVal)
				{
					swap(arr,i,lowIndex);
					lowIndex++;
				}
			}
		}
		lowIndex--;
		highIndex++;
		swap(arr,lowIndex,low);
		swap(arr,highIndex,high);
		return new int[]{lowIndex,highIndex};
	}

	private static void swap(int[] arr, int i1, int i2)
	{
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
}
