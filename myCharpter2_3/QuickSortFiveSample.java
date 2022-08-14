package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortFiveSample {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(lo>(hi-5)) {
			insertion(a,lo,hi);
			return;
		}
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static void insertion(Comparable[] a,int lo,int hi) {
		for(int i = lo;i<hi;i++) 
			for(int j = i+1;j>lo&&less(a[j],a[j-1]);--j)
				 exch(a,j,j-1);
	}
	
	private static int partition(Comparable[] a,int lo,int hi) {
		int i = lo;
		int j = hi + 1;
		for(int k = 0;k<5;k++)
			exch(a,lo+k,StdRandom.uniform(lo+k,hi));
		insertion(a,lo,lo+4);
		exch(a,lo,lo+2);
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j]));
			
			if(j<=i) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	public static void main(String[] args) {
		Integer[] a = {5,2,4,1,7,6,2,1,5};
		sort(a);
		for(Integer s:a)
			System.out.print(s+" ");
	}
}
