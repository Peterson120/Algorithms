/* Original TimSort.java with improvements to InsertionSort and MergeSort*/
public class ImprovedTSort
{
	final static int MAX_MERGE = 63;

   	public static void sort(int[] arr)						{tSort(arr,0,arr.length-1);}
	public static void sort(int[] arr, int end) 			{tSort(arr,0,end);}
	public static void sort(int[] arr, int start, int end) 	{tSort(arr,start,end);}

	private static void tSort(int[] arr, int l, int r)
	{
		if(r-l <= MAX_MERGE)	// If range is less than maximum run size
			inSort(arr,l,r);	// Insertion sort for run
		else					// Break into smaller runs
		{
			int mid = l + (r-l)/2;	// Mid index
			
			tSort(arr,l,mid);	// Recur for left side of array
			tSort(arr,mid+1,r);	// Recur for right side of array
			merge(arr,l,mid,r);	// Merge the two arrays together while sorting
		}
	}

	private static void inSort(int[] arr, int start, int end)
    {
		for(int i = start+1; i <= end; i++)
		{
			int temp = arr[i]; 								// Get number at i in array
			int loc = binarySearch(arr,start,i-1,temp); 	// Find insertion location using binary search

			System.arraycopy(arr,loc,arr,loc+1,i-loc); 		// Move array after indexed location right one space
			arr[loc] = temp; 								// Set value at indexed location to selected value
		}
    }

	private static int binarySearch(int[] arr, int l, int r, int key)
	{
		while(l <= r)				// Recur while range is valid
		{
			int mid = l + (r-l)/2;

			if(arr[mid] == key) 	// If key is at the mid
				return mid;
			else if(arr[mid] < key) // If mid value of range is smaller than key, recur for right side
				l = mid + 1;
			else if(arr[mid] > key) // If mid value of range is larger than key, recur for left side
				r = mid - 1;
		}
		return l;					// If value is not found return index to insert value into
	}

	private static void merge(int[] arr, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;					// Find array lengths
		int[] temp1 = new int[len1], temp2 = new int[len2];	// Initialize temp arrays

		// Create copies of left and right arrays
		System.arraycopy(arr,l,temp1,0,len1);
		System.arraycopy(arr,m+1,temp2,0,len2);

		int i = 0, j = 0, main = l;
		while(i < len1 && j < len2)
		{
			if(temp1[i] < temp2[j]) // Sort values
				arr[main++] = temp1[i++];
			else				
				arr[main++] = temp2[j++];
		}

		// Copy remaining values over to main array
		if(i < len1 - 1) 	
			System.arraycopy(temp1,i,arr,main,len1-i);
		if(j < len2 - 1) 	
			System.arraycopy(temp2,j,arr,main,len2-j);
	}
}
