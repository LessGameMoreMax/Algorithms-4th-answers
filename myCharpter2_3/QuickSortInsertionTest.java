package myCharpter2_3;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickSortInsertionTest {
		public static void sort(Comparable[] a,int num) {
			StdRandom.shuffle(a);
			System.out.println("for"+" :"+num);
			for(int i = 0;i<=30;i++) {
				Stopwatch timer = new Stopwatch();
				sort(a,0,a.length-1,i);
				double time = timer.elapsedTime();
				System.out.println(i+" :"+"time:"+time);
			}
		}
		
		private static void sort(Comparable[] a,int lo,int hi,int M) {
			if(lo>=(hi-M)) {
				insertion(a,lo,hi);
				return;
			}
			int j = partition(a,lo,hi);
			sort(a,lo,j-1,M);
			sort(a,j+1,hi,M);
		}
		
		private static void insertion(Comparable[] a,int lo,int hi) {
			for(int i = lo;i<hi;i++) 
				for(int j = i+1;j>lo&&less(a[j],a[j-1]);--j)
					 exch(a,j,j-1);
		}
		
		private static int partition(Comparable[] a,int lo,int hi) {
			int i =lo;
			int j = hi+1;
			Comparable v = a[lo];
			while(true) {
				while(less(a[++i],v)) 
					if(i==hi) break;
				while(less(v,a[--j])) 
					if(j==lo) break;
				if(i>=j) break;
				exch(a,i,j);
			}
			exch(a,lo,j);
			return j;
		}
		
		private static void exch(Comparable[] a,int i,int j) {
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		private static boolean less(Comparable v,Comparable w) {
			return v.compareTo(w)<0;
		}
		
		public static void main(String[] args) {
			for(int i = 1000;i<=1000000;i*=10) {
				Double[] a = new Double[i];
				for(int j = 0;j<a.length;j++)
					a[j] = StdRandom.uniform();
				sort(a,i);
			}
		}
}
