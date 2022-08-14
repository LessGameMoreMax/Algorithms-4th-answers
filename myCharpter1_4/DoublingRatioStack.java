package myCharpter1_4;

import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSumFast;

public class DoublingRatioStack {
	public static double timeTrialStackNode(int N) {
		Stack<Integer> test = new Stack<Integer>();
		Stopwatch timer = new Stopwatch();
		for(int i =0;i<N/2;i++) 
			test.push(i);
		for(int i = N/2;i<N;i++)
			test.pop();
		return timer.elapsedTime();
	}
	
	public static double timeTrialStackArray(int N) {
		ResizingArrayStack<Integer> test = new ResizingArrayStack<Integer>();
		Stopwatch timer = new Stopwatch();
		for(int i =0;i<N/2;i++) 
			test.push(i);
		for(int i = N/2;i<N;i++)
			test.pop();
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		for(int N = 250;true;N+=N) {
			double timeNode = timeTrialStackNode(N);
			double timeArray = timeTrialStackArray(N);
			StdOut.printf("%10.1f\n",timeArray);
			StdOut.printf("%10.1f\n",timeNode);
			StdOut.println();
		}
	}
}

