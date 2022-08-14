package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortGuard {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(lo>=hi) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(Comparable[] a,int lo,int hi) {
		int i = lo;
		int j = hi+1;
		if(less(a[hi],a[lo])) exch(a,lo,hi);
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
		Integer[] a = {6,2,3,7,5,4,1,1,6,4,7,8,1};
		sort(a);
		for(int s:a)
			System.out.print(s+" ");
	}
}
