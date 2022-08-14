package myCharpter1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingTest {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for(int i =0;i<N;i++)
			a[i] = StdRandom.uniform(-MAX,MAX);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
//	public static void main(String[] args) {
//		StdDraw.setXscale(0,5);
//		StdDraw.setYscale(0,15);
//		StdDraw.setPenRadius(.03);
//		for(int N=250;true;N+=N) {
//			double time = timeTrial(N);
//			StdDraw.point((double)N/1000.0,time);
//			StdOut.printf("%7d %5.1f\n",N,time);
//		}
//	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(-2,5);
		StdDraw.setYscale(-2,4);
		StdDraw.setPenRadius(.03);
		for(int N=250;true;N+=N) {
			double time = timeTrial(N);
			StdDraw.point(Math.log((double)N/1000.0),Math.log(time));
			StdOut.printf("%7d %5.1f\n",N,time);
		}
	}
}
