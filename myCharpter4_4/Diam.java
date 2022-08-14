package myCharpter4_4;

import edu.princeton.cs.algs4.In;

public class Diam {
	public static void main(String[] args) {
		double diam = 0.0;
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		for(int i = 0;i<G.V();i++) {
			MyDijkstraSP D = new MyDijkstraSP(G,i);
			diam = Math.max(diam, D.diam());
		}
		System.out.print("The diam of G is :" + String.format("%.2f", diam));
	}
}
