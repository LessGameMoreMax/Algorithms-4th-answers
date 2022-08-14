package myCharpter2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GroundToTopMergeNature {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		int first = 0;
		while(first<a.length) {
			if(first==a.length-1)
				return;
			while(a[first].compareTo(a[first+1])<=0) {
				first++;
				if(first==a.length-1)
					return;
			}
			int second = first+1;
			while(second<a.length-1&&a[second].compareTo(a[second+1])<=0) {
				second++;
			}
			merge(a,0,first,second);
			first = second;
		}
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
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}
}

