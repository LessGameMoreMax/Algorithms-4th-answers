package myCharpter1_5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyiVision {
	public static void totalCount1(int N) {
		WeightedQuickUnionVision simple = new WeightedQuickUnionVision(N);
//		QuickUnionUF simple = new QuickUnionUF(N);
//		QuickFindUF simple = new QuickFindUF(N);
//		WeightedDistanceZIPQuickUnion simple = new WeightedDistanceZIPQuickUnion(N);
		
//		WeightedQuickUnion simple = RandomGrid.generate(N);
		int i = 1;
		while(simple.count()>1) {
			int num1 = StdRandom.uniform(N);
			int num2 = StdRandom.uniform(N);
			if(!simple.connected(num1, num2)) {
				StdDraw.setYscale(0,100);
				StdDraw.setXscale(0,100);
				StdDraw.setPenRadius(.02);
				StdDraw.setPenColor(StdDraw.GRAY);
				int num = simple.union(num1,num2);
				StdDraw.point(i, num);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(i, simple.total()/i);	
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		totalCount1(100);
	}
}
