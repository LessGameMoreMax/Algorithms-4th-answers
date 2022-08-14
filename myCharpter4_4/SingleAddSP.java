package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class SingleAddSP {
	private double[] distTo;
	private MyDirectedEdge[] edgeTo;
	private MinPQ<MyDirectedEdge> pq;
	
	public SingleAddSP(MyEdgeWeightedDigraph G,int s) {
		distTo = new double[G.V()];
		edgeTo = new MyDirectedEdge[G.V()];
		pq = new MinPQ<MyDirectedEdge>();
		
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		for(MyDirectedEdge e : G.edges())
			pq.insert(e);
		while(!pq.isEmpty())
			relax(pq.delMin());
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
		SingleAddSP S = new SingleAddSP(G,0);
		for(MyDirectedEdge e : S.pathSub(5))
			System.out.println(e);
	}
}
