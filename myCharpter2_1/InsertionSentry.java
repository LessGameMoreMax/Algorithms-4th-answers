package myCharpter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSentry {
	public static void sort(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			if(less(a[i],a[0])) exch(a,i,0);
		for(int i = 2; i < a.length; i++) 
			for(int j = i;less(a[j],a[j-1]);j--)
				exch(a,j,j-1);
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
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}

