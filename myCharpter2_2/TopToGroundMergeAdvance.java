package myCharpter2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
//ÓÐbug
public class TopToGroundMergeAdvance {
	
	public static void sort(int[] a) {
		int[] aux = new int[a.length];
		a  = sort(a,0,a.length-1,aux,1);
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
//	q w e r t y u i o p a s d f g h j k l z x c v b n m
	private static int[] sort(int[] a,int lo,int hi,int[] aux,int deepth) {
		if((hi-lo)<8) {
			for(int i = lo+1;i<=hi;i++)
				for(int j = i;j>lo&&less(a[j],a[j-1]);j--)
					exch(a,j,j-1);
			return a;
		}
		int mid = lo + (hi-lo)/2;
		sort(a,lo,mid,aux,deepth+1);
		if(deepth%2==0) {
			int[] temp = a;
			a = aux;
			aux = temp;	
		}
		sort(a,mid+1,hi,aux,deepth+1);
//		if(less(aux[mid+1],aux[mid])) 
		int[] temp = a;
		a = aux;
		aux = temp;
		merge(a,lo,mid,aux,hi);
		return a;
	}
	
	private static void exch(int[] a,int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void merge(int[] a,int lo,int mid,int[] aux,int hi) {
		int i = lo;
		int j = mid+1;	
		for(int k = lo;k<=hi;k++)
			if	   (i>mid) 				       a[k]=aux[j++];
			else if(j>hi) 				       a[k]=aux[i++];
			else if(less(aux[j],aux[i])) 	   a[k]=aux[j++];
			else						       a[k]=aux[i++];
	}
	
	private static boolean less(int v,int n) {
		return v<n;
	}
	
	
	public static void main(String[] args) {
		for(int i = 5;i<65;i++) {
			int[] a = new int[i];
			for(int j = 0;j<i;j++) 
			a[j]= StdRandom.uniform(11,50);
			sort(a);	
		}
	}
}

