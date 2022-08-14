package myCharpter4_4;

import edu.princeton.cs.algs4.Stack;

public class AcyclicLP {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicLP(MyEdgeWeightedDigraph G,int s) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.NEGATIVE_INFINITY;
		distTo[s] = 0.0;
		
		EdgeWeightedTopological top = new EdgeWeightedTopological(G);
		for(int v : top.order())
			relax(G,v);
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]<distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w] = e;
			}
		}
	}
	
	public double distTo(int v)
	{ return distTo[v];}
	
	public boolean hasPathTo(int v)
	{ return distTo[v]>Double.NEGATIVE_INFINITY;}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			stack.push(e);
		return stack;
	}
}
