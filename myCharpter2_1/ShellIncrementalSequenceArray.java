package myCharpter2_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellIncrementalSequenceArray {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int k = (int)Math.pow(N*2+1,1.0/3.0);
		int[] h = new int[k];
		for(int m = 0;m < k;m++)
			h[m] = (int) ((Math.pow(3, m+1)-1)/2);
		for(int n = k-1;n>=0;n--) 
			for(int i = h[n];i<N;i++) 
				for(int j =i;j>=h[n]&&less(a[j],a[j-h[n]]);j-=h[n])
					exch(a,j,j-h[n]);
	}
	
	private static void exch(Comparable[] a,int i,int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
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
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
