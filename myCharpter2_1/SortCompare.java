package myCharpter2_1;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import myCharpter2_3.QuickSortFiveSample;
import myCharpter2_3.QuickSortThreeSample;

public class SortCompare {
	public static double time(String alg,Double[] a/*Integer[] a*/) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("InsertionNoExch")) InsertionNoExch.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell"))     Shell.sort(a);
		if(alg.equals("ShellNewIncrease"))   ShellNewIncrease.sort(a);
		if(alg.equals("Merge"))     Merge.sort(a);
		if(alg.equals("Quick")) 	Quick.sort(a);
		if(alg.equals("QuickSortFiveSample")) 	QuickSortFiveSample.sort(a);
		if(alg.equals("QuickSortThreeSample")) 	QuickSortThreeSample.sort(a);
//		if(alg.equals("Heap")) 		Heap.sort(a);
		return timer.elapsedTime();
	}
	
//	public static double timeOriginalDouble(double[] a) {
//		Stopwatch timer = new Stopwatch();
//		InsertionOriginalDouble.sort(a);
//		return timer.elapsedTime();
//	}
	
	
//	public static double timeRandomInputDouble(int N,int T) {
//		double total = 0.0;
//		double[] a = new double[N];
//		for(int t = 0;t<T;t++) {
//			for(int i = 0;i<N;i++)
//				a[i] = StdRandom.uniform();
//			total += timeOriginalDouble(a);
//		}
//		return total;
//	}
	
	public static double timeRandomInput(String alg,int N,int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for(int t = 0;t<T;t++) {
			for(int i = 0;i<N;i++)
				a[i] = StdRandom.uniform();
			total += time(alg,a);
		}
		return total;
	}
	
//	public static double timeRandomInput(String alg,int N,int T) {
//		double total = 0.0;
//		Integer[] a = new Integer[N];
//		for(int t = 0;t<T;t++) {
//			for(int i = 0;i<N;i++)
//				a[i] = (int)(StdRandom.uniform()*2);
//			total += time(alg,a);
//		}
//		return total;
//	}
	
	public static void main(String[] args) {
//		print();
		printDoublingRatio();
	}
	
//	public static void print() {
//		System.out.println("Please input a alg:");
//		String alg1 = StdIn.readString();
//		System.out.println("Please input another alg:");
//		String alg2 = StdIn.readString();
//		System.out.println("Please input the length of the array:");
//		int N = StdIn.readInt();
//		System.out.println("Please input the number of the array:");
//		int T = StdIn.readInt();
//		
//		double t1 = timeRandomInput(alg1,N,T);
//		double t2 = timeRandomInput(alg2,N,T);
////		double t2 = timeRandomInputDouble(N,T);
//		
//		StdOut.printf("For %d random Doubles\n     %s is ",N,alg1);
//		StdOut.printf("%.1f times faster than %s\n" ,t2/t1,alg2);
//	}
	
	public static void printDoublingRatio() {
		System.out.println("Please input a alg:");
		String alg1 = StdIn.readString();
		System.out.println("Please input another alg:");
		String alg2 = StdIn.readString();
		System.out.println("Please input the number of the array:");
		int T = StdIn.readInt();
		for(int N = 128;true;  N*=2) {
			double t1 = timeRandomInput(alg1,N,T);
			double t2 = timeRandomInput(alg2,N,T);
//			double t2 = timeRandomInputDouble(N,T);
			
			StdOut.printf("For %d random Doubles\n     %s is ",N,alg1);
			StdOut.printf("%.1f times faster than %s\n" ,t2/t1,alg2);
		}
	}
}
