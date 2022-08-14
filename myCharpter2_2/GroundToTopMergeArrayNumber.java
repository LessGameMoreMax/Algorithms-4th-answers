package myCharpter2_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class GroundToTopMergeArrayNumber {
	private static Comparable[] aux;
	private static int arrayNumberCount = 0;
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1;sz < N;sz += sz)
			for(int lo = 0;lo<N-sz;lo+=sz+sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
	}
	
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		int i = lo;
		int j = mid+1;
		for(int k = lo;k<=hi;k++) 
			aux[k] = a[k];
		for(int k = lo;k<=hi;k++)
			if	   (i>mid) 				 a[k] = aux[j++];
			else if(j>hi) 				 a[k] = aux[i++];
			else if(less(aux[i],aux[j])) {
				a[k] = aux[i++];
				arrayNumberCount += 2;
			}
			else 						 {
				a[k] = aux[j++];
				arrayNumberCount += 2;
			}
		arrayNumberCount += (hi-lo+1)*4;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(-1,513);
		StdDraw.setYscale(-1,6*10*512);
		StdDraw.setPenRadius(.01);
		for(int N = 1;N<=512;N++) {
			Double[] a = new Double[N];
			for(int i =0;i<N;i++)
			a[i] = StdRandom.random();
			sort(a);
			StdDraw.setPenColor();
			StdDraw.point(N,arrayNumberCount);
			arrayNumberCount = 0;
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(N,N*6*Math.log(N)/Math.log(2));
		}
 	}
}
