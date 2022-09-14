import java.util.List;
public class GenericBinarySearch<T extends Comparable<T>> {
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
}

