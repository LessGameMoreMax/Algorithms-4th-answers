package myCharpter1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ErdosRenyiRandomResh {
	public static int totalCount1(int N) {
		int number = 0;
//		WeightedQuickUnion simple = new WeightedQuickUnion(N);
//		QuickUnionUF simple = new QuickUnionUF(N);
//		QuickFindUF simple = new QuickFindUF(N);
//		WeightedDistanceZIPQuickUnion simple = new WeightedDistanceZIPQuickUnion(N);
		
		WeightedQuickUnion simple = RandomGrid.generate(N);
		
		while(simple.count()>1) {
			int num1 = StdRandom.uniform(N*N);
			int num2 = StdRandom.uniform(N*N);
			number++;
			if(!simple.connected(num1, num2))
				simple.union(num1, num2);
		}
		return number;
	}
	
	public static void main(String[] args) {
		Stopwatch timer  = new Stopwatch();
		totalCount1(125);
		double prev = timer.elapsedTime();
		for(int N = 250;true;N *= 2) {
			Stopwatch timemath1  = new Stopwatch();
			totalCount1(N);
			double time1 = timemath1.elapsedTime();
			System.out.println(time1/prev);
			prev = time1;
		}
	}
}
