package myCharpter4_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DijkstraAnotherVersion {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	
	public DijkstraAnotherVersion(MyEdgeWeightedDigraphMaxtrix G,int s) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		for(int i = 0;i<G.V();i++)
			relax(G,min());
	}
	
	private int min() {
		int v = 0;
		double dis = Double.POSITIVE_INFINITY;
		for(int i = 1;i<distTo.length;i++) {
			if(marked[i]) continue;
			if(dis>distTo[i]&&Math.abs(dis-distTo[i])>FLOATING_POINT_EPSILON) {
				v = i;
				dis = distTo[i];
			}
		}
		return v;
	}
	
	private void relax(MyEdgeWeightedDigraphMaxtrix G,int v) {
		marked[v] = true;
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w] = e;
			}
		}
	}
	
	public double distTo(int v)
	{ return distTo[v];}
	
	public boolean hasPathTo(int v)
	{ return distTo[v] < Double.POSITIVE_INFINITY;}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraphMaxtrix G = new MyEdgeWeightedDigraphMaxtrix(new In(args[0]));
		DijkstraAnotherVersion D = new DijkstraAnotherVersion(G,0);
		for(MyDirectedEdge e : D.pathTo(5))
			System.out.println(e);
	}
}
