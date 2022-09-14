import java.util.List;
public class BinarySearch<T extends Comparable<T>> {
	public int binarySearch(List<T> list, T key) {return binarySearch(list, 0, list.size()-1, key);}
	public int binarySearch(List<T> list, int r, T key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(List<T> list, int l, int r, T key) {
		while(l <= r) {
			int m = l+((r-l)>>1), t = list.get(m).compareTo(key);
			if (t == 0) return m;
			else if (t > 0) l = m + 1;
			else r = m - 1;
		}
		return -1;
	}

	public int binarySearch(int[] list, int key) {return binarySearch(list, 0, list.length-1, key);}
	public int binarySearch(int[] list, int r, int key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(int[] list, int l, int r, int key) {
		while(l <= r) {
			int m = l+((r-l)>>1);
			if(list[m] == key) return m; 
			else if(list[m] < key) l = m + 1;
			else if(list[m] > key) r = m - 1;
		}
		return -1;
	}

	public int binarySearch(String[] list, String key) {return binarySearch(list, 0, list.length-1, key);}
	public int binarySearch(String[] list, int r, String key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(String[] list, int l, int r, String key) {
		while(l <= r) {
			int m = l+((r-l)>>1);
			int t = list[m].compareTo(key);
			if(t == 0) return m;
			else if(t < 0) r = m - 1;
			else if(t > 0) l = m + 1;
		}
		return -1;
	}

	public int binarySearch(char[] list, char key) {return binarySearch(list, 0, list.length-1, key);}
	public int binarySearch(char[] list, int r, char key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(char[] list, int l, int r, char key) {
		while(l <= r) {
			int m = l+((r-l)>>1);
			if(list[m] == key) return m;
			else if(list[m] < key) l = m + 1;
			else if(list[m] > key) r = m - 1;
		}
		return -1;
	}

	public int binarySearch(double[] list, double key) {return binarySearch(list, 0, list.length-1, key);}
	public int binarySearch(double[] list, int r, double key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(double[] list, int l, int r, double key) {
		while(l <= r) {
			int m = l+((r-l)>>1);
			if(list[m] == key) return m;
			else if(list[m] > key) r = m - 1;
			else if(list[m] < key) l = m + 1;
		}
		return -1;
	}

	public int binarySearch(long[] list, long key) {return binarySearch(list, 0, list.length-1, key);}
	public int binarySearch(long[] list, int r, long key) {return binarySearch(list, 0, r, key);}
	public int binarySearch(long[] list, int l, int r, long key) {
        while(l <= r) {
            int m = l+((r-l)>>1);
            if (list[m] == key) return m; 
            else if (list[m] < key) l = m + 1;
            else if (list[m] > key) r = m - 1;
        }
        return -1;
    }

	public int binarySearch(short[] list, short key) {return binarySearch(list, 0, list.length-1, key);} 
	public int binarySearch(short[] list, int r, short key) {return binarySearch(list, 0, r, key);} 
    public int binarySearch(short[] list, int l, int r, short key) {
        while(l <= r) {
            int m = l+((r-l)>>1);
            if(list[m] == key) return m; 
            else if(list[m] < key) l = m + 1;
            else if(list[m] > key) r = m - 1;
        }
        return -1;
    }
}
