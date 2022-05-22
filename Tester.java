import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Tester
{
	private static int length;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter an array length: ");
		length = Integer.valueOf(br.readLine());
		br.close();
		int[] iArr;
		long start, end;
		
		/*iArr = putVal();
		start = System.nanoTime();
		//PogoSort.sort(iArr);
		end = System.nanoTime();
		//System.out.println(Arrays.toString(iArr));
		//System.out.println("Pogosort took " + (end-start)/1000 + " microseconds");
		*/

		InsertionSort.sort(new int[]{0});

		iArr = putVal();
		start = System.nanoTime();
		InsertionSort.sort(iArr);
		end = System.nanoTime();
		long in = end-start;
		// System.out.println(Arrays.toString(iArr));
		System.out.println("InsertionSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		MergeSort.sort(new int[]{0});

		iArr = putVal();
		start = System.nanoTime();
		MergeSort.sort(iArr);
		end = System.nanoTime();
		long m = end-start;
		// System.out.println(Arrays.toString(iArr));
		System.out.println("MergeSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		/*
		SelectionSort.sort(iArr);

		iArr = putVal();
		start = System.nanoTime();
		SelectionSort.sort(iArr);
		end = System.nanoTime();
		// System.out.println(Arrays.toString(iArr));
		System.out.println("SelectionSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		BubbleSort.sort(iArr);

		iArr = putVal();
		start = System.nanoTime();
		BubbleSort.sort(iArr);
		end = System.nanoTime();
		// System.out.println(Arrays.toString(iArr));
		System.out.println("BubbleSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		iArr = putVal();
		start = System.nanoTime();
		BubbleSort.sort(iArr,true);
		end = System.nanoTime();
		// System.out.println(Arrays.toString(iArr));
		System.out.println("Reverse BubbleSort took " + (end-start) + " nanoseconds" + rSorted(iArr) + "\n");
		*/

		ImprovedQSort.sort(new int[]{0});

		iArr = putVal();
		start = System.nanoTime();
		ImprovedQSort.sort(iArr);
		end = System.nanoTime();
		long q = end-start;
		// System.out.println(Arrays.toString(iArr));
		System.out.println("QuickSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		ImprovedTSort.sort(new int[]{0});

		iArr = putVal();
		start = System.nanoTime();
		ImprovedTSort.sort(iArr);
		end = System.nanoTime();
		long i = end-start;
		// System.out.println(Arrays.toString(iArr));
		System.out.println("TimSort took " + (end-start) + " nanoseconds" + sorted(iArr) + "\n");

		System.out.print("Slowest: ");
		if(i > m && i > in && i > q) 		System.out.println("TimSort");
		else if(in > m && in > q && in > i) System.out.println("InsertionSort");
		else if(q > m && q > in && q > i) 	System.out.println("QuickSort");
		else								System.out.println("MergeSort");

		System.out.print("Fastest: ");
		if(i < m && i < in && i < q) 		System.out.println("TimSort");
		else if(in < m && in < q && in < i)	System.out.println("InsertionSort");
		else if(q < m && q < in && q < i) 	System.out.println("QuickSort");
		else 								System.out.println("MergeSort");
	}

	private static int[] putVal()
	{
		Random rand = new Random();
		int[] result = new int[length];
		for(int i = 0; i < length; i++)
			result[i] = rand.nextInt(20)-20/2;
		return result;
	}

	private static String sorted(int[] arr)
	{
		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i] > arr[i+1]) 
				return "\nTest passed: false";
		}
		return "\nTest passed: true";
	}

	private static String rSorted(int[] arr)
	{
		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i] < arr[i+1]) return "\nTest passed: false";
		}
		return "\nTest passed: true";
	}
}
