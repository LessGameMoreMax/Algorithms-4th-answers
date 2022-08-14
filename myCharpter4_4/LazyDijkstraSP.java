package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class LazyDijkstraSP {
	private MyDirectedEdge[] edgeTo; 
	private double[] distTo;
	private MinPQ<MyDirectedEdge> pq;
	
	public LazyDijkstraSP(MyEdgeWeightedDigraph G,int s) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new MinPQ<MyDirectedEdge>(G.V());
		
		for(int i = 0;i<G.V();i++) distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		relax(G,s);
		
		while(!pq.isEmpty()) {
			MyDirectedEdge e = pq.delMin();
			relax(G,e.to());
		}
	}
	
	public void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				pq.insert(e);
			}
		}
	}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			stack.push(e);
		return stack;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		LazyDijkstraSP L = new LazyDijkstraSP(G,0);
		for(MyDirectedEdge e : L.pathTo(5))
			System.out.println(e);
	}
	
}
