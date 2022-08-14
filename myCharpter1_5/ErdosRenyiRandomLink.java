package myCharpter1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ErdosRenyiRandomLink {
	
	public static int totalCount1(int N) {
		int number = 0;
//		WeightedQuickUnion simple = new WeightedQuickUnion(N);
//		QuickUnionUF simple = new QuickUnionUF(N);
//		QuickFindUF simple = new QuickFindUF(N);
		WeightedDistanceZIPQuickUnion simple = new WeightedDistanceZIPQuickUnion(N);
		
		while(simple.count()>1) {
			int num1 = StdRandom.uniform(N);
			int num2 = StdRandom.uniform(N);
			number++;
			if(!simple.connected(num1, num2))
				simple.union(num1, num2);
		}
		return number;
	}
	
	public static int totalCount2(int N) {
		int number = 0;
		WeightedQuickUnion simple = new WeightedQuickUnion(N);
//		QuickUnionUF simple = new QuickUnionUF(N);
//		QuickFindUF simple = new QuickFindUF(N);
//		WeightedDistanceZIPQuickUnion simple = new WeightedDistanceZIPQuickUnion(N);
		
		while(simple.count()>1) {
			int num1 = StdRandom.uniform(N);
			int num2 = StdRandom.uniform(N);
			number++;
			if(!simple.connected(num1, num2))
				simple.union(num1, num2);
		}
		return number;
	}
	
	public static void main(String[] args) {
		for(int N = 250;true;N *= 2) {
			Stopwatch timemath1  = new Stopwatch();
			totalCount1(N);
			double time1 = timemath1.elapsedTime();
			
			Stopwatch timemath2  = new Stopwatch();
			System.out.println(totalCount2(N));
			double time2 = timemath2.elapsedTime();
			
			System.out.println(time1/time2);
		}
	}
}
