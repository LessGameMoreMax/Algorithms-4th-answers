package myCharpter2_2;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class OneNameThreeLists {
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1;sz<N;sz *= 2)
			for(int lo = 0;lo<N-sz;lo += 2*sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
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
	
	private static boolean same(Comparable v,Comparable w) {
		return v.compareTo(w)==0;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	private static boolean rank(String key,String[] strArray) {
		int lo = 0;
		int hi = strArray.length-1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if(less(key,strArray[mid])) hi = mid - 1;
			else if(less(strArray[mid],key)) lo = mid + 1;
			else if(key.equals(strArray[mid])) return true;
			else{
				for(int i = 1;same(key,strArray[mid])&&(mid-i)>=0;i++)
					if(key.equals(strArray[mid-i])) return true;
				for(int i = 1;same(key,strArray[mid])&&(mid+i)<strArray.length;i++)
					if(key.equals(strArray[mid+i])) return true;
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("How many Strings do you want to input?");
		int N =StdIn.readInt();
		String[] first = new String[N];
		String[] second = new String[N];
		String[] third = new String[N];
		
		System.out.println("Please input the first lists:");
		for(int i = 0;i<N;i++)
		first[i] = StdIn.readString();
		
		System.out.println("Please input the second lists:");
		for(int i = 0;i<N;i++)
		second[i] = StdIn.readString();
		
		System.out.println("Please input the third lists:");
		for(int i = 0;i<N;i++)
		third[i] = StdIn.readString();
		
		sort(first);
		sort(second);
		sort(third);
		
		for(int i = 0;i<first.length;i++) {
			if(rank(first[i],second)&&rank(first[i],third)) {
				System.out.println(first[i]);
				return;
			}
		}
	}
}
