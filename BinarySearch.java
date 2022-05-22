import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
* Must be sorted prior to calling BinarySearch
*/

public class BinarySearch
{
    private static BufferedReader br;
    public static int binarySearch(int[] list, int key)
    {
        int left = 0, right = list.length-1, mid, numComp = 0;
        while(left <= right)
        {
			numComp ++;
            mid = left+(right-left)/2;

            if(list[mid] == key) 
			{
				System.out.println(numComp);
				return mid; 
			}
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
		System.out.println(numComp);
        return -1;
    }

    public static int binarySearch(String[] list, String key)
    {
        int left = 0, right = list.length-1, mid;
        while(left <= right)
        {
            mid = left+(right - left)/2;
            int temp = list[mid].compareTo(key);
            if(temp == 0) return mid;
            else if(temp < 0) right = mid - 1;
            else if(temp > 0) left = mid + 1;
        }
        return -1;
    }

    public static int binarySearch(char[] list, char key)
    {
        int left = 0, right = list.length-1,mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            if(list[mid] == key) return mid;
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(double[] list, double key)
    {
        int left = 0, right = list.length-1, mid;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(list[mid] == key) return mid;
            else if(list[mid] > key) right = mid - 1;
            else if(list[mid] < key) left = mid + 1;
        }
        return -1;
    }

    public static int binarySearch(long[] list, long key)
    {
        int left = 0, right = list.length-1, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list[mid] == key) return mid; 
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(short[] list, short key)
    {
        int left = 0, right = list.length-1, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list[mid] == key) return mid; 
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(List<Integer> list, int key)
    {
        int left = 0, right = list.size()-1, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list.get(mid) == key) return mid; 
            else if(list.get(mid) < key) left = mid + 1;
            else if(list.get(mid) > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(List<String> list, String key)
    {
        int left = 0, right = list.size()-1, mid;
        while(left <= right)
        {
            mid = left+(right - left)/2;
            int temp = list.get(mid).compareTo(key);
            if(temp == 0) return mid;
            else if(temp < 0) right = mid - 1;
            else if(temp > 0) left = mid + 1;
        }
        return -1;
    }

    public static int binarySearch(List<Character> list, char key)
    {
        int left = 0, right = list.size()-1,mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            if(list.get(mid) == key) return mid;
            else if(list.get(mid) < key) left = mid + 1;
            else if(list.get(mid) > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(List<Double> list, double key)
    {
        int left = 0, right = list.size(),mid;
        while(left <= right)
        {
            mid = left+ (right - left)/2;
            if(list.get(mid) == key) return mid;
            else if(list.get(mid) > key) right = mid - 1;
            else if(list.get(mid) < key) left = mid + 1;
        }
        return -1;
    }

    public static int binarySearch(List<Long> list, long key)
    {
        int left = 0, right = list.size()-1, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list.get(mid) == key) return mid; 
            else if(list.get(mid) < key) left = mid + 1;
            else if(list.get(mid) > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(List<Short> list, short key)
    {
        int left = 0, right = list.size()-1, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list.get(mid) == key) return mid; 
            else if(list.get(mid) < key) left = mid + 1;
            else if(list.get(mid) > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearchStringFile(String file, String key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        br = new BufferedReader(new FileReader(file));
        while(left <= right)
        {
            mid = left + (right-left)/2;
            int compare = getLine(file,mid).compareTo(key);
            if(compare == 0) return mid;
            else if(compare > 0) left = mid + 1;
            else if(compare < 0) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearchIntFile(String file, int key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            int temp = Integer.valueOf(getLine(file,mid));
            if(temp == key) return mid;
            else if(temp < key) left = mid + 1;
            else if(temp > key) right = mid -1;
        }
        return -1;
    }

    public static int binarySearchCharFile(String file, char key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            char temp = getLine(file,mid).charAt(0);
            if(temp == key) return mid;
            else if(temp < key) left = mid + 1;
            else if(temp > key) right = mid -1;
        }
        return -1;
    }
    
    public static int binarySearchDoubleFile(String file, double key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        while(left < right)
        {
            mid = left + (right-left)/2;
            double temp = Double.parseDouble(getLine(file,mid));
            if(temp == key) return mid;
            else if(temp < key) left = mid + 1;
            else if(temp > key) right = mid -1;
        }
        return -1;
    }

    public static int binarySearchIntFile(String file, long key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            long temp = Long.parseLong(getLine(file,mid));
            if(temp == key) return mid;
            else if(temp < key) left = mid + 1;
            else if(temp > key) right = mid -1;
        }
        return -1;
    }

    public static int binarySearchIntFile(String file, short key) throws IOException
    {
        int left = 0, right = fileLength(file), mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            short temp = Short.parseShort(getLine(file,mid));
            if(temp == key) return mid;
            else if(temp < key) left = mid + 1;
            else if(temp > key) right = mid -1;
        }
        return -1;
    }
    
   	public static int binarySearch(int[] list, int start, int end, int key)
    {
        int left = start, right = end, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list[mid] == key) return mid; 
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

	public static int binarySearch(String[] list, int start, int end, String key)
    {
        int left = start, right = end, mid;
        while(left <= right)
        {
            mid = left+(right - left)/2;
            int temp = list[mid].compareTo(key);
            if(temp == 0) return mid;
            else if(temp < 0) right = mid - 1;
            else if(temp > 0) left = mid + 1;
        }
        return -1;
    }

	public static int binarySearch(char[] list, int start, int end, char key)
    {
        int left = start, right = end,mid;
        while(left <= right)
        {
            mid = left + (right-left)/2;
            if(list[mid] == key) return mid;
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(double[] list, int start, int end, double key)
    {
        int left = start, right = end, mid;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(list[mid] == key) return mid;
            else if(list[mid] > key) right = mid - 1;
            else if(list[mid] < key) left = mid + 1;
        }
        return -1;
    }

    public static int binarySearch(long[] list, int start, int end, long key)
    {
        int left = start, right = end, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list[mid] == key) return mid; 
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(short[] list, int start, int end, short key)
    {
        int left = start, right = end, mid;
        while(left <= right)
        {
            mid = left+(right-left)/2;

            if(list[mid] == key) return mid; 
            else if(list[mid] < key) left = mid + 1;
            else if(list[mid] > key) right = mid - 1;
        }
        return -1;
    }

	private static int fileLength(String file) throws IOException
    {
        br = new BufferedReader(new FileReader(file));
        int length = 0;
        while(br.readLine() != null) length++;
        return length;
    }

    private static String getLine(String file, int line) throws IOException {return Files.readAllLines(Paths.get(file)).get(line);}
}
