package myCharpter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionNoExch {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			 int j = i;
			while(j>=1) {
				Comparable t1 = a[j];
				Comparable t2 = a[j-1];
				if(t1.compareTo(t2) < 0) {
					a[j] = t2;
					a[j-1] = t1;
				}
				j--;
			}
		}
	}
	
	private static boolean less(Comparable v,Comparable w)
	{ return v.compareTo(w) < 0;}
	
	private static void show(Comparable[] a) {
		for(int i =0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
