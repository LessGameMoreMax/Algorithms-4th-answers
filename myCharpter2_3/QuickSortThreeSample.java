package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortThreeSample {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(lo>=hi) return;
		if(lo==hi-1) {
			if(less(a[lo+1],a[lo])) exch(a,lo,lo+1);
			return;
		}
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	
	private static int partition(Comparable[] a,int lo,int hi) {
		int i = lo;
		int j = hi + 1;
        if (less(a[lo + 1], a[lo]))
            exch(a, lo + 1, lo);
        if (less(a[lo + 2], a[lo]))
            exch(a, lo + 2, lo);
        if (less(a[lo + 2], a[lo + 1]))
            exch(a, lo + 1, lo + 2);
        exch(a, lo, lo + 1);
        exch(a, hi, lo + 2);
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i],v));
			while(less(v,a[--j]));
			
			if(j<=i) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] a = {5,2,4,1,7,6,2,1,5};
		sort(a);
		for(int s:a)
			System.out.print(s+" ");
	}
	
	
}
