package myCharpter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ProcessTimeVision {
	public static void drawAverage() {
		System.out.println("Process in the series of one thousand.");
		for(int i = 1000;i<100000;i +=1000) {
			Double[] a = new Double[i];
			for(int j = 0;j<a.length;j++)
				a[j] = StdRandom.uniform();
			StdDraw.setPenRadius(.01);
			StdDraw.setXscale(0,100);
			StdDraw.setYscale(-3,3);
			Stopwatch timer = new Stopwatch();
			Insertion.sort(a);
			double time = timer.elapsedTime();
			StdDraw.point(i/1000, time/i*1000);
		}
	}
	
	public static void main(String[] args) {
		drawAverage();
	}
}
