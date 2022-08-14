package myCharpter2_2;

import edu.princeton.cs.algs4.StdOut;

public class NumberOfReverseOrder {
	public static int count(int[] a) {
		int number =0;
		int N = a.length;
		
		for(int sz = 1;sz < N;sz++)
			for(int lo = 0;lo<N-sz;lo++)
				if(merge(a,lo,lo+sz))
					number++;
		return number;
	}
	
	private static boolean merge(int[] a,int lo,int hi) {
			if(a[lo]<a[hi]) return false;
		return true;
	}
	
	private static void show(int[] a) {
		for(int i = 0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static void main(String[] args) {
		int[] a = { 4,3,6,7,5};
		System.out.print(count(a));
 	}
}

