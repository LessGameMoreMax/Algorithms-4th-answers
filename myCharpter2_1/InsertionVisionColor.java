package myCharpter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionVisionColor {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			int j = 0;
			for( j = i;j>=1 && less(a[j],a[j-1]);j--) {
				exch(a,j,j-1);
			}
			StdDraw.clear(StdDraw.WHITE);
			for(int k = 0;k<j;k++) {
				double x = 1.0*k/a.length;
				double y = (double)a[k]/2.0;
				double rw = 0.5/a.length;
				double rh = (double)a[k]/2.0;
				StdDraw.setPenColor(StdDraw.GRAY);
				StdDraw.filledRectangle(x,y,rw,rh);
			}
			for(int k = j;k<=i;k++) {
				double x = 1.0*k/a.length;
				double y = (double)a[k]/2.0;
				double rw = 0.5/a.length;
				double rh = (double)a[k]/2.0;
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.filledRectangle(x,y,rw,rh);
			}
			for(int k = i+1;k<a.length;k++) {
				double x = 1.0*k/a.length;
				double y = (double)a[k]/2.0;
				double rw = 0.5/a.length;
				double rh = (double)a[k]/2.0;
				StdDraw.setPenColor(StdDraw.GRAY);
				StdDraw.filledRectangle(x,y,rw,rh);
			}
		StdDraw.show(120);
		}
	}
	
	private static void exch(Comparable[] a,int i,int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static boolean less(Comparable v,Comparable w)
	{ return v.compareTo(w) < 0;}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Double[] a = new Double[100];
		for(int i = 0;i<100;i++)
			a[i] = StdRandom.random();
		sort(a);
	}
}
