package myCharpter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class MyDoublingRatio {
	public static double timeTrial(int N) {
		int MAX = 100000;
		int[] a = new int[N];
		for(int i =0;i<N;i++)
			a[i] = StdRandom.uniform(-MAX,MAX);
		Stopwatch timer = new Stopwatch();
		int cut = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		for(int N=10;N<=1000;N*=10) {
			double time = 0;
			for(int i = 0;i<N;i++) {
				time += timeTrial(Integer.parseInt(args[0]));	
			}
			StdOut.printf("%6d %7.1f ",N,time);
			StdOut.printf("%5.1f\n",time/(double)N);
		}
	}
}
