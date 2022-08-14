package myCharpter2_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IndirectSortMerge {
	private static int[] aux;
	private static int[] numAux;
	
	public static int[] sort(int[] a) {
		int N = a.length;
		aux = new int[N];
		numAux = new int[N];
		int[] num = new int[N];
		int[] aTemp = new int[N];
		for(int i = 0;i<N;i++) {
			aTemp[i] = a[i];
			num[i] = i;
		}
		for(int sz = 1;sz<N;sz *= 2)
			for(int lo = 0;lo<N-sz;lo += 2*sz)
				merge(aTemp,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1),num);
		return num;	
	}
	
	private static void merge(int[] a,int lo,int mid,int hi,int[] num) {
		int i = lo;
		int j = mid+1;
		for(int k = lo;k<=hi;k++) {
			aux[k]=a[k];
			numAux[k]=num[k];
		}
			
		for(int k = lo;k<=hi;k++)
			if(i>mid) 			{a[k] = aux[j++]; j--;num[k] = numAux[j++];}
			else if(j>hi) 		{a[k] = aux[i++]; i--;num[k] = numAux[i++];}
			else if(less(aux[j],aux[i])) {a[k] = aux[j++]; j--;num[k] = numAux[j++];}
			else 				{a[k]=aux[i++]; i--;num[k] = numAux[i++];} 
	}
	
	private static boolean less(int v,int w) {
		return v<w;
	}
	
	private static void show(int[] a) {
		for(int i = 0;i<a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static void main(String[] args) {
		int[] test = { 6,4,7,5};
		int[] result = sort(test);
		for(int s :result)
			System.out.print(s);
	}
}
