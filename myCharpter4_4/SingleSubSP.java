package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Stack;

public class SingleSubSP {
	private double[] distTo;
	private MyDirectedEdge[] edgeTo;
	private MaxPQ<MyDirectedEdge> pq;
	
	public SingleSubSP(MyEdgeWeightedDigraph G,int s) {
		distTo = new double[G.V()];
		edgeTo = new MyDirectedEdge[G.V()];
		pq = new MaxPQ<MyDirectedEdge>();
		
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		for(MyDirectedEdge e : G.edges())
			pq.insert(e);
		while(!pq.isEmpty())
			relax(pq.delMax());
	}
	
	private void relax(MyDirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if(distTo[w]>distTo[v]+e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
	}

	public boolean hasPathTo(int w)
	{ return distTo[w]<Double.NEGATIVE_INFINITY;}
	
	public Iterable<MyDirectedEdge> pathSub(int w){
		Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[w];e!=null;e = edgeTo[e.from()])
			stack.push(e);
		return stack;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		SingleSubSP S = new SingleSubSP(G,0);
		for(MyDirectedEdge e : S.pathSub(0))
			System.out.println(e);
	}
}
