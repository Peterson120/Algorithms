// Forward and Reverse TimSort
public class TimSort 
{
	final static int MAX_MERGE = 64;

   	public static void sort(int[] arr)									{tSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr, int end) 						{tSort(arr,0,end,false);}
	public static void sort(int[] arr, int start, int end) 				{tSort(arr,start,end,false);}
	public static void sort(int[] arr, boolean rev)						{tSort(arr,0,arr.length-1,rev);}
	public static void sort(int[] arr, int end, boolean rev)			{tSort(arr,0,end,rev);}
	public static void sort(int[] arr, int start, int end, boolean rev)	{tSort(arr,start,end,rev);}

	private static void tSort(int[] arr, int l, int r, boolean rev)
	{
		if(r-l <= MAX_MERGE)		// If range is less than maximum run size
			inSort(arr,l,r,rev);	// Insertion sort for run
		else						// Break into smaller runs
		{
			int mid = l + (r-l)/2;	// Find mid index
			
			// Merge Sort
			tSort(arr,l,mid,rev);	// Recur for left side of array
			tSort(arr,mid+1,r,rev);	// Recur for right side of array
			merge(arr,l,mid,r,rev);	// Merge the two arrays together while sorting
		}
	}

	private static void inSort(int[] arr, int start, int end, boolean reverse)
    {
		if(reverse)
		{
			for(int i = start+1; i <= end; i++)
			{
				int temp = arr[i]; 											// Get number at i in array
				int location = rBinarySearch(arr,start,i-1,temp); 			// Find insert sort location using binary search

				System.arraycopy(arr,location,arr,location+1,i-location); 	// Move array after indexed location back one space
				arr[location] = temp; 										// Set value at indexed location to selected value
			}
			return;
		}

		for(int i = start+1; i <= end; i++)
		{
			int temp = arr[i]; 											// Get number at i in array
			int location = binarySearch(arr,start,i-1,temp); 			// Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); 	// Move array after indexed location right one space
			arr[location] = temp; 										// Set value at indexed location to selected value
		}
    }

	private static int binarySearch(int[] arr, int start, int end, int key)
	{
		int left = start, right = end, mid;
		while(left <= right)		// Recur while range is valid
		{
			mid = left + (right-left)/2;

			if(arr[mid] == key) 	// If value is found at mid return mid
				return mid + 1;
			else if(arr[mid] < key) // If mid value of range is smaller than key, recur for right side
				left = mid + 1;
			else if(arr[mid] > key) // If mid value of range is larger than key, recur for left side
				right = mid - 1;
		}
		return left;				// If value is not found return index to insert value into
	}

	private static int rBinarySearch(int[] arr, int start, int end, int key)
	{
		int left = start, mid, right = end;
		while(left <= right)		// Recur until specified range is invalid
		{
			mid = left + (right-left)/2;

			if(arr[mid] == key) 	// If mid is equal to key
				return mid + 1;
			else if(arr[mid] > key) // If mid value of range is larger than key, recur for right side
				left = mid + 1;
			else if(arr[mid] < key) // If mid value of range is smaller than key, recur for left side
				right = mid - 1;
		}
		return left;				// If value is not found return index to insert value into
	}

	private static void merge(int[] arr, int l, int mid, int r, boolean rev)
    {
        int len1 = mid - l + 1, len2 = r - mid;

		// Initialize temp arrays
		int[] temp1 = new int[len1], temp2 = new int[len2];

		// Create copies of left and right arrays
		System.arraycopy(arr,l,temp1,0,len1);
		System.arraycopy(arr,mid+1,temp2,0,len2);

		int i = 0, j = 0, main = l; // i is index of first arr, j is second, main is the main index
		if(rev)
		{
			while(i < len1 && j < len2)
			{
				// Sort values in reverse order
				if(temp1[i] > temp2[j])		
					arr[main++] = temp1[i++];
				else					
					arr[main++] = temp2[j++];
			}
		}

		while(i < len1 && j < len2)
		{
			// Sort values
			if(temp1[i] < temp2[j]) 	
				arr[main++] = temp1[i++];
			else 					
				arr[main++] = temp2[j++];
		}

		// Copy remaining values over to main array
		if(i < len1) 	
			System.arraycopy(temp1,i,arr,main,len1-i);
		if(j < len2) 	
			System.arraycopy(temp2,j,arr,main,len2-j);
	}
}
