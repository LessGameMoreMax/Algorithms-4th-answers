package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortThreeWaysAnotherMethod {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int p = lo;
		int i = lo;
		int j = hi+1;
		int q = hi+1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i],v)) {
				if(a[i].compareTo(v)==0) exch(a,i,++p);
				if(i>=hi) break;
			}
			while(less(v,a[--j])) {
				if(a[j].compareTo(v)==0) exch(a,j,--q);
			}
			if(i>=j) break;
			exch(a,i,j);
		}
		while(p>=lo) exch(a,j--,p--);
		while(q<=hi) exch(a,i++,q++);
		sort(a,lo,j);
		sort(a,i,hi);
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] a = {9,0,2,3,5,8,4,7,8};
		sort(a);
		show(a);
	}
	
}
