package myCharpter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionVision {
	public static void sort(Comparable[] a) {
		show(a);
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i;j>=1 && less(a[j],a[j-1]);j--)
				exch(a,j,j-1);
		show(a);
		StdDraw.show(120);
		}
	}
	
	private static void exch(Comparable[] a,int i,int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static boolean less(Comparable v,Comparable w)
	{ return v.compareTo(w) < 0;}
	
	private static void show(Comparable[] a) {
		StdDraw.clear(StdDraw.WHITE);
		for(int i = 0;i<a.length;i++) {
			double x = 1.0*i/a.length;
			double y = (double)a[i]/2.0;
			double rw = 0.5/a.length;
			double rh = (double)a[i]/2.0;
			StdDraw.filledRectangle(x,y,rw,rh);
		}
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args) {
		int N = 100;
		Double[] a = new Double[N];
		for(int i = 0;i<N;i++) 
			a[i] = StdRandom.uniform();
		sort(a);
	}
}

