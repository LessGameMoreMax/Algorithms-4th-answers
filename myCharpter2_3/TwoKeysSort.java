package myCharpter2_3;

public class TwoKeysSort {
	public static void sort(Comparable[] a) {
		int count = 0;
		Comparable key1 = a[0];
		Comparable key2 = null;
		for(int i = 0;i<a.length;i++)
			if(a[i]==key1) count++;
			else key2 = a[i];
		for(int i = 0;i<count;i++)
			a[i] = min(key1, key2);
		for(int i = count;i<a.length;i++)
			a[i] = max(key1,key2);
		
	}
	
	public static Comparable min(Comparable a,Comparable b) {
		return a.compareTo(b)<0 ? a : b;
	}
	public static Comparable max(Comparable a,Comparable b) {
		return a.compareTo(b)<0 ? b : a;
	}
	
	public static void main(String[] args) {
		Integer[] a = { 1,2,1,2,1,2,2,2,2,2};
		sort(a);
		for(Integer s:a)
			System.out.print(s+" ");
	}
}
