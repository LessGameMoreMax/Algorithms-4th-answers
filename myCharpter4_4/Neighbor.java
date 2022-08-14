package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Neighbor {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		System.out.println("Please input the start:");
		int s = StdIn.readInt();
		System.out.println("Please input your distance:");
		double distance = StdIn.readDouble();
		System.out.println("Loading......");
		MyDijkstraSP D = new MyDijkstraSP(G,s);
		for(int i = 0;i<G.V();i++)
			if(D.distTo(i)<distance&&Math.abs(D.distTo(i)-distance)>FLOATING_POINT_EPSILON) System.out.println(i);
	}
}
