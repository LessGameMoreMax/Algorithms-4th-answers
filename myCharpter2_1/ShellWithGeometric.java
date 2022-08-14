package myCharpter2_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ShellWithGeometric {
	public static void sort(Comparable[] a,int k) {
		int N = a.length;
		int h = 1;
		Stopwatch timer = new Stopwatch();
		for(int t = k; h < N/t; h *= t);
		while(h>=1) {
			for(int i = h;i<N;i++) {
				for(int j =i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h /= k;
		}
		double time  = timer.elapsedTime();
		System.out.printf("time:%f  k:%d\n",time,k);
	}
	
	private static void exch(Comparable[] a,int i,int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static boolean less(Comparable v,Comparable w)
	{ return v.compareTo(w) < 0;}
	
	private static void show(Comparable[] a) {
		for(int i =0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args) {
		for(int k = 2;true;k++) {
			Double[] a = new Double[1000000];
			for(int i = 0;i<a.length;i++)
				a[i] = StdRandom.uniform();
			sort(a,k);	
		}
		
	}
}

