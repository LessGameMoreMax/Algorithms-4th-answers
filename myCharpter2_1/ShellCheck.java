package myCharpter2_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellCheck {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h<N/3) h = 3*h+1;
		while(h>=1) {
			for(int i = h;i<N;i++) {
				for(int j =i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h = h/3;
		}
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
	
	public static boolean check(Comparable[] a) {
		Comparable[] temp = new Comparable[a.length];
		for(int i = 0;i<a.length;i++)
			temp[i] = a[i];
		sort(a);
		if(isSorted(a)) {
			for(int i = 0;i<a.length;i++)
				if(a[i]!=temp[i])
					return false;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
	
}