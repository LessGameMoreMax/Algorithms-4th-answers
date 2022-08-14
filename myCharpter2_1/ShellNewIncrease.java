package myCharpter2_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellNewIncrease {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int[] h = {1,5,19,41,109,209,505,929,2161,3905,8929,16001,36289,64769,146305,260609};
		int k = 0;
		while(h[k]<a.length) k++;
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
