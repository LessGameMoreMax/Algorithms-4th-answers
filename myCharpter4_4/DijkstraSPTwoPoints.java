package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraSPTwoPoints {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	MyEdgeWeightedDigraph G;
	
	public DijkstraSPTwoPoints(MyEdgeWeightedDigraph G) {
		this.G = G;
	}
	
	public Iterable<MyDirectedEdge> path(int s,int v){
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int i = 0;i<G.V();i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		
		while(!pq.isEmpty()) {
			int w = pq.delMin();
			if(w==v) break;
			relax(G,w);
		}
		
		if(!hasPathTo(v)) return null;
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	public boolean hasPathTo(int v) {
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else			   pq.insert(w, distTo[w]);
			}
		}
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		DijkstraSPTwoPoints D = new DijkstraSPTwoPoints(G);
		for(MyDirectedEdge e : D.path(0, 6))
			System.out.println(e);
	}
}
