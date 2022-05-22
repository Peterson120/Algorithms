// DO NOT USE
public class BubbleSort 
{
	public static void sort(int[] arr) {bSort(arr,0,arr.length-1,false);}
	public static void sort(int[] arr, boolean rev) {bSort(arr,0,arr.length-1,rev);}

	private static void bSort(int[] arr, int start, int end, boolean rev)
	{
		if(rev)
		{
			while(!check(arr,start,end,rev))
			{
				for(int i = start; i < end; i++)
				{
					if(arr[i] < arr[i+1])
					{
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
			}
		}

		while(!check(arr,start,end,rev))
		{
			for(int i = start; i < end; i++)
			{
				if(arr[i] > arr[i+1])
				{
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
	}

	private static boolean check(int[] arr, int start, int end, boolean rev)
	{
		if(rev)
		{
			for(int i = start; i < end; i++)
			{
				if(arr[i] < arr[i+1]) return false;
			}
			return true;
		}

		for(int i = start; i < end; i++)
		{
			if(arr[i] > arr[i+1]) return false;
		}
		return true;
	}
}
