package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortComparableAndArrayCount {
	private static int comparableCount = 0; 
	private static int arrayCount = 0;
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(Math.abs(hi-lo)<2) arrayCount++;
		if(hi<=lo) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(Comparable[] a,int lo,int hi) {
		int i =lo;
		int j = hi+1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i],v)) 
				if(i==hi) break;
			while(less(v,a[--j])) 
				if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		comparableCount++;
		return v.compareTo(w)<0;
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
	
	private static void showComparableCount() {
		System.out.println(comparableCount);
	}
	
	private static void showArrayCount() {
		System.out.println(arrayCount);
	}
	
	public static void main(String[] args) {
		int N =1000;
		Integer[] a = new Integer[N];
		for(int i= 0;i<a.length;i++)
//			a[i] = StdRandom.uniform(N);
			a[i] = 1;
		sort(a);
		showComparableCount();
	}
}
