package myCharpter2_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSortNoRecursion {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		Stack<Integer> low = new Stack<Integer>();
		Stack<Integer> high = new Stack<Integer>();
		while(!isSorted(a)) {
			if(lo<hi) {
				int j = partition(a,lo,hi);
				if(Math.abs(hi-j)>Math.abs(lo-j)) {
					low.push(j+1);
					high.push(hi);
					hi = j - 1;
				}else {
					low.push(lo);
					high.push(j-1);
					lo = j + 1;
				}
			}else {
				lo = low.pop();
				hi = high.pop();
			}
		}
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i = 0;i<a.length-1;i++)
			if(less(a[i+1],a[i])) return false;
		return true;
	}
	
	private static int partition(Comparable[] a,int lo,int hi) {
		int i = lo;
		int j = hi+1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i],v)) if(i==lo) break;
			while(less(v,a[--j]));
			
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,j,lo);
		return j;
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
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] a = {8,5,6,4,7,8,7,6,2,8};
		sort(a);
		show(a);
	}
}
