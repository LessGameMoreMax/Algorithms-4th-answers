package myCharpter2_2;

import edu.princeton.cs.algs4.StdOut;

public class ThreeFromTopToGroundMerge {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int loMid = lo + (hi-lo)/3;
		int hiMid = hi - (hi-lo)/3;
		sort(a,lo,loMid);
		sort(a,loMid+1,hiMid);
		sort(a,hiMid+1,hi);
		merge(a,lo,loMid,hiMid,hi);
	}
	
	private static void merge(Comparable[] a,int lo,int loMid,int hiMid,int hi) {
		int i = lo;
		int j = loMid+1;
		int k = hiMid+1;
		for(int m = lo;m<=hi;m++)
			aux[m]=a[m];
		for(int m = lo;m<=hi;m++)
			if	   (i>loMid&&k>hi) a[m] = aux[j++];
			else if(j>hiMid&&k>hi) a[m] = aux[i++];
			else if(i>loMid&&j>hiMid) a[m] = aux[k++];
			else if(i>loMid&&less(aux[j],aux[k])) a[m] = aux[j++];
			else if(i>loMid&&less(aux[k],aux[j])) a[m] = aux[k++];
			else if(j>hiMid&&less(aux[i],aux[k])) a[m] = aux[i++];
			else if(j>hiMid&&less(aux[k],aux[i])) a[m] = aux[k++];
			else if(k>hi&&less(aux[j],aux[i])) 	  a[m] = aux[j++];
			else if(k>hi&&less(aux[i],aux[j]))    a[m] = aux[i++];
			else if(less(aux[i],aux[j],aux[k]))   a[m] = aux[i++];
			else if(less(aux[j],aux[i],aux[k]))   a[m] = aux[j++];
			else 								  a[m] = aux[k++]; 
	}
	
	private static boolean less(Comparable v,Comparable w,Comparable p) {
		return v.compareTo(w)<=0&&v.compareTo(p)<=0;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<=0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static void main(String[] args) {
		Integer[] test = { 7,2,6,5};
		sort(test);
		for(int s :test)
			System.out.print(s);
	}
}
