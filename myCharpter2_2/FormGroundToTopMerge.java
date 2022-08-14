package myCharpter2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FormGroundToTopMerge {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1;sz<N;sz *= 2)
			for(int lo = 0;lo<N-sz;lo += 2*sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
	}
	
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		int i = lo;
		int j = mid+1;
		for(int k = lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k = lo;k<=hi;k++)
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else 				a[k]=aux[i++]; 
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static void main(String[] args) {
		Integer[] test = { 4,3,7};
		sort(test);
		for(int s :test)
			System.out.print(s);
	}
}
