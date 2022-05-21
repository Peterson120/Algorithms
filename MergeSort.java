public class MergeSort
{
	// Method overloading for int arrays
	public static void sort(int[] arr)									{mSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr,int end) 							{mSort(arr,0,end,false);}
	public static void sort(int[] arr, int start, int end) 				{mSort(arr,start,end,false);}
	public static void sort(int[] arr, boolean rev)						{mSort(arr,0,arr.length-1,rev);}
	public static void sort(int[] arr, int end, boolean rev)			{mSort(arr,0,end,rev);}
	public static void sort(int[] arr, int start, int end, boolean rev) {mSort(arr,start,end,rev);}

	// Method overloading for String arrays
	public static void sort(String[] arr)									{mSort(arr,0,arr.length-1,false);}
	public static void sort(String[] arr,int end) 							{mSort(arr,0,end,false);}
	public static void sort(String[] arr, int start, int end) 				{mSort(arr,start,end,false);}
	public static void sort(String[] arr, boolean rev)						{mSort(arr,0,arr.length-1,rev);}
	public static void sort(String[] arr, int end, boolean rev)				{mSort(arr,0,end,rev);}
	public static void sort(String[] arr, int start, int end, boolean rev) 	{mSort(arr,start,end,rev);}

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
				if(temp1[i] > temp2[j])		arr[main++] = temp1[i++];
				else						arr[main++] = temp2[j++];
			}
		}

		while(i < len1 && j < len2)
		{
			// Sort values
			if(temp1[i] < temp2[j]) 	arr[main++] = temp1[i++];
			else 						arr[main++] = temp2[j++];
		}

		// Copy remaining values over to main array
		if(i < len1) 	System.arraycopy(temp1,i,arr,main,len1-i);
		if(j < len2) 	System.arraycopy(temp2,j,arr,main,len2-j);
	}

    private static void mSort(int[] arr, int l, int r, boolean rev)
    {
		if(l < r) 						// Recur for each child while left index is smaller than right index
		{
        	int mid = l + (r-l)/2;

			mSort(arr,l,mid, rev); 		// Left array
			mSort(arr,mid+1,r, rev); 	// Right array

			merge(arr,l,mid,r, rev); 	// Merge both arrays
		}
    }
	
	private static void merge(String[] arr, int l, int mid, int r, boolean rev)
    {
        int len1 = mid - l + 1, len2 = r - mid - 1;

		// Initialize temp arrays
		String[] temp1 = new String[len1], temp2 = new String[len2];

		// Create copies of left and right arrays
		System.arraycopy(arr,l,temp1,0,len1);
		System.arraycopy(arr,mid+1,temp2,0,len2);

		int i = 0, j = 0, main = l, comp; // i is index of first arr, j is second, main is the main index
		if(rev)
		{
			while(i < len1 && j < len2)
			{
				// Sort values in reverse order
				comp = CompareStrings.compare(temp1[i],temp2[j]);
				if(comp < 0)	arr[main++] = temp1[i++];
				else			arr[main++] = temp2[j++];
			}
		}

		while(i < len1 && j < len2)
		{
			// Sort values
			comp = temp1[i].compareTo(temp2[j]);
			if(comp < 0) 	arr[main++] = temp1[i++];
			else 			arr[main++] = temp2[j++];
		}

		// Copy remaining values over to main array
		if(i < len1) 	System.arraycopy(temp1,i,arr,main,len1-i);
		if(j < len2) 	System.arraycopy(temp2,j,arr,main,len2-j);
	}

    private static void mSort(String[] arr, int l, int r, boolean rev)
    {
		if(l < r) 						// Recur for each child while left index is smaller than right index
		{
        	int mid = l + (r-l)/2;

			mSort(arr,l,mid, rev); 		// Left array
			mSort(arr,mid+1,r, rev); 	// Right array

			merge(arr,l,mid,r, rev); 	// Merge both arrays
		}
    }
}
