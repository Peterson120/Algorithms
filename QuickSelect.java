/* 
Binary Search is preferred over QuickSelect because it is faster unless array is unsorted
Time complexity for QuickSelect is O(nlogn) while Binary Search has O(logn)
*/

public class QuickSelect 
{
    private static void swap(int[] arr, int i1, int i2)
    {
      int temp = arr[i1];
      arr[i1] = arr[i2];
      arr[i2] = temp;
    }

    private static int pivot(int[] arr,int low,int high)
    {
      int pivot = arr[high], loc = low;
      for(int i = low; i <= high; i++)
      {
        if(arr[i] < pivot)
        {
          swap(arr,i,loc);
          loc++;
        }
        else if(arr[i] > pivot)
        {
          swap(arr,high,i);
          high--;
        }
      }
      swap(arr,high,loc);
		  return loc;
    }

    /**
     * arr is the array to select a value from
     * low is the starting point of the array (0) on the first run
     * high is the ending point of the array (array.length-1) on the first run
     * n is the nth smallest number to find
     */
    public static int quickSelect(int[] arr,int low,int high, int n)
    {
		  int partition = pivot(arr,low,high);
      if(partition == n-1)
        return arr[partition];
      else if(partition < n-1)
        return quickSelect(arr,partition+1,high,n);
      else 
        return quickSelect(arr,low,partition-1,n);
    }
}
