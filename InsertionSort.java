// Finished
public class InsertionSort 
{
	// Method Overloading for int arrays
	public static void sort(int[] arr) 											{inSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(int[] arr, int start, int end) 						{inSort(arr,start,end,false);}
	public static void sort(int[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(int[] arr, int end, boolean reverse) 				{inSort(arr,0,end,reverse);}
	public static void sort(int[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Method Overloading for String arrays
	public static void sort(String[] arr) 										{inSort(arr,0,arr.length-1,false);}
	public static void sort(String[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(String[] arr, int start, int end) 					{inSort(arr,start,end,false);}
	public static void sort(String[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(String[] arr, int end, boolean reverse) 			{inSort(arr,0,end,reverse);}
	public static void sort(String[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Method Overloading for char arrays
	public static void sort(char[] arr) 										{inSort(arr,0,arr.length-1,false);}
	public static void sort(char[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(char[] arr, int start, int end) 					{inSort(arr,start,end,false);}
	public static void sort(char[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(char[] arr, int end, boolean reverse) 				{inSort(arr,0,end,reverse);}
	public static void sort(char[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Method Overloading for double arrays
	public static void sort(double[] arr) 										{inSort(arr,0,arr.length-1,false);}
	public static void sort(double[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(double[] arr, int start, int end) 					{inSort(arr,start,end,false);}
	public static void sort(double[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(double[] arr, int end, boolean reverse) 			{inSort(arr,0,end,reverse);}
	public static void sort(double[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Method Overloading for long integer arrays
	public static void sort(long[] arr) 										{inSort(arr,0,arr.length-1,false);}
	public static void sort(long[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(long[] arr, int start, int end) 					{inSort(arr,start,end,false);}
	public static void sort(long[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(long[] arr, int end, boolean reverse) 				{inSort(arr,0,end,reverse);}
	public static void sort(long[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Method Overloading for short integer arrays
	public static void sort(short[] arr) 										{inSort(arr,0,arr.length-1,false);}
	public static void sort(short[] arr, int end) 								{inSort(arr,0,end,false);}
	public static void sort(short[] arr, int start, int end) 					{inSort(arr,start,end,false);}
	public static void sort(short[] arr, boolean reverse) 						{inSort(arr,0,arr.length-1,reverse);}
	public static void sort(short[] arr, int end, boolean reverse) 				{inSort(arr,0,end,reverse);}
	public static void sort(short[] arr, int start, int end, boolean reverse) 	{inSort(arr,start,end,reverse);}

	// Insertion sort with int
	private static void inSort(int[] arr, int start, int end, boolean reverse)
    {
		if(reverse)
		{
			for(int i = start+1; i <= end; i++)
			{
				int temp = arr[i]; // Get number at i in array

				int location = rBinarySearch(arr,start,i-1,temp); // Find insert sort location using binary search

				System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
				arr[location] = temp; // Set value at indexed location to selected value
			}
			return;
		}

		for(int i = start+1; i <= end; i++)
		{
			int temp = arr[i]; // Get number at i in array
			int location = binarySearch(arr,start,i-1,temp); // Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected value
		}
    }

	private static int binarySearch(int[] arr, int start, int end, int key)
	{
		int left = start, right = end, mid;
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] < key) left = mid + 1;
			else if(arr[mid] > key) right = mid - 1;
		}
		return left;
	}

	private static int rBinarySearch(int[] arr, int start, int end, int key)
	{
		int left = start,mid,right = end;
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] > key) left = mid + 1;
			else if(arr[mid] < key) right = mid - 1;
		}
		return left;
	}

	// Insertion Sort with Strings
	private static void inSort(String[] arr, int start, int end, boolean reverse)
    {
		for(int i = start+1; i <= end; i++)
		{
			String temp = arr[i]; // Get temp at i in array
			int location = binarySearch(arr, start, i - 1, temp, reverse); // Find insert sort location using binary search
			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected temp
		}
    }

	private static int binarySearch(String[] arr, int start, int end, String key, boolean reverse)
	{
		int left = start, right = end, mid, temp;
		if(reverse)
		{
			while(left <= right)
			{
				mid = left + (right-left)/2;
				temp = CompareStrings.compare(arr[mid],key);
				if(temp == 0) return mid + 1;
				else if(temp > 0) left = mid + 1;
				else if(temp < 0) right = mid - 1;
			}
			return left;
		}

		while(left <= right)
		{
			mid = left + (right-left)/2;
			temp = CompareStrings.compare(arr[mid],key); // Return an int value of the two strings compared
			if(temp == 0) return mid + 1; // Strings are equal
			else if(temp < 0) left = mid + 1; // If the key is larger than the array value at mid
			else if(temp > 0) right = mid - 1; // If the key is smaller than the array value at mid
		}
		return left;
	}

	// Insertion sort with chars
	private static void inSort(char[] arr, int start, int end, boolean reverse)
    {
		for(int i = start+1; i <= end; i++)
		{
			char temp = arr[i]; // Get temp at i in array

			int location = binarySearch(arr,start,i-1,temp,reverse); // Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected temp
		}
    }

	private static int binarySearch(char[] arr, int start, int end, char key, boolean reverse)
	{
		int left = start, right = end, mid;
		if(reverse)
		{
			while(left <= right)
			{
				mid = left + (right-left)/2;

				if(arr[mid] == key) return mid + 1;
				else if(arr[mid] > key) left = mid + 1;
				else if(arr[mid] < key) right = mid - 1;
				
			}
			return left;
		}
		
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] < key) left = mid + 1;
			else if(arr[mid] > key) right = mid - 1;
		}
		return left;
	}

	// Insertion sort with double
	private static void inSort(double[] arr, int start, int end, boolean reverse)
    {
		for(int i = start+1; i <= end; i++)
		{
			double temp = arr[i]; // Get value at i in array

			int location = binarySearch(arr,start,i-1,temp,reverse); // Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected temp
		}
    }

	private static int binarySearch(double[] arr, int start, int end, double key, boolean reverse)
	{
		int left = start, right = end, mid;
		if(reverse)
		{
			while(left <= right)
			{
				mid = left + (right-left)/2;

				if(arr[mid] == key) return mid + 1;
				else if(arr[mid] > key) left = mid + 1;
				else if(arr[mid] < key) right = mid - 1;
				
			}
			return left;
		}
		
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] < key) left = mid + 1;
			else if(arr[mid] > key) right = mid - 1;
		}
		return left;
	}

	// Insertion sort with long integers
	private static void inSort(long[] arr, int start, int end, boolean reverse)
	{
		for(int i = start+1; i <= end; i++)
		{
			long temp = arr[i]; // Get value at i in array

			int location = binarySearch(arr,start,i-1,temp,reverse); // Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected temp
		}
	}

	private static int binarySearch(long[] arr, int start, int end, long key, boolean reverse)
	{
		int left = start, right = end, mid;
		if(reverse)
		{
			while(left <= right)
			{
				mid = left + (right-left)/2;

				if(arr[mid] == key) return mid + 1;
				else if(arr[mid] > key) left = mid + 1;
				else if(arr[mid] < key) right = mid - 1;
				
			}
			return left;
		}
		
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] < key) left = mid + 1;
			else if(arr[mid] > key) right = mid - 1;
		}
		return left;
	}

	// Insertion sort with short integers
	private static void inSort(short[] arr, int start, int end, boolean reverse)
	{
		for(int i = start+1; i <= end; i++)
		{
			short temp = arr[i]; // Get value at i in array

			int location = binarySearch(arr,start,i-1,temp,reverse); // Find insert sort location using binary search

			System.arraycopy(arr,location,arr,location+1,i-location); // Move array after indexed location back one space
			arr[location] = temp; // Set value at indexed location to selected temp
		}
	}

	private static int binarySearch(short[] arr, int start, int end, long key, boolean reverse)
	{
		int left = start, right = end, mid;
		if(reverse)
		{
			while(left <= right)
			{
				mid = left + (right-left)/2;

				if(arr[mid] == key) return mid + 1;
				else if(arr[mid] > key) left = mid + 1;
				else if(arr[mid] < key) right = mid - 1;
				
			}
			return left;
		}
		
		while(left <= right)
		{
			mid = left + (right-left)/2;
			if(arr[mid] == key) return mid + 1;
			else if(arr[mid] < key) left = mid + 1;
			else if(arr[mid] > key) right = mid - 1;
		}
		return left;
	}
}
