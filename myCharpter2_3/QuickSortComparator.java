package myCharpter2_3;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortComparator {
	public static void sort(Comparable[] a,Comparator c) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1,c);
	}
	
	private static void sort(Comparable[] a,int lo,int hi,Comparator c) {
		if(hi<=lo) return;
		int j = partition(a,lo,hi,c);
		sort(a,lo,j-1,c);
		sort(a,j+1,hi,c);
	}
	
	private static int partition(Comparable[] a,int lo,int hi,Comparator c) {
		int i =lo;
		int j = hi+1;
		Comparable v = a[lo];
		while(true) {
			while(less(c,a[++i],v)) 
				if(i==hi) break;
			while(less(c,v,a[--j])) 
				if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static boolean less(Comparator c,Comparable v,Comparable w) {
		return c.compare(v, w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void show(Comparable[] a) {
		for(int i= 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
