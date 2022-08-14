package myCharpter4_4;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class MyDijkstraSP {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public MyDijkstraSP(MyEdgeWeightedDigraph G,int s) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0;v<G.V();v++) distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()) relax(G,pq.delMin());
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else			   pq.insert(w, distTo[w]);
			}
		}
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public boolean hasPathTo(int v)
	{ return distTo[v]<Double.POSITIVE_INFINITY;}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
//	*********************************************************************************************************
	public double diam() {
		double max = 0;
		for(int i = 0;i<distTo.length;i++)
			max = Math.max(max, distTo(i));
		return max;
	}
}
