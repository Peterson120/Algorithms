import java.util.Random;
public class BogoSort
{
	public static void sort(int[] arr)
	{
		Random rand = new Random();
		while(!check(arr))
		{
			int loc1 = rand.nextInt(arr.length-1);
			int loc2 = rand.nextInt(arr.length-1);
			int temp1 = arr[loc1];
			int temp2 = arr[loc2];
			arr[loc1] = temp2;
			arr[loc2] = temp1;
		}
	}

	private static boolean check(int[] arr)
	{
		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i] > arr[i+1]) return false;
		}
		return true;
	}
}
