package myCharpter2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class TopToGroundMergeWithoutAux {
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a,0,a.length-1,aux);
	}
	
	private static void sort(Comparable[] a,int lo,int hi,Comparable[] aux) {
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a,lo,mid,aux);
		sort(a,mid+1,hi,aux);
		merge(a,lo,mid,hi,aux);
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi,Comparable[] aux) {
		int i = lo;
		int j = mid+1;
		for(int k = lo;k<=hi;k++)
			aux[k] = a[k];
		for(int k = lo;k<=hi;k++)
			if	   (i>mid) 				 a[k]=aux[j++];
			else if(j>hi) 				 a[k]= aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else						 a[k]=aux[i++];
	}
	
	private static boolean less(Comparable v,Comparable n) {
		return v.compareTo(n)<0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		for(int i = 1;i<50;i++) {
			Integer[] a = new Integer[i];
			for(int j = 0;j<i;j++) 
			a[j]= StdRandom.uniform(20,50);
			sort(a);
			show(a);	
		}
	}
}

