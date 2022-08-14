package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class PrimBSTAnotherVersion {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	
	public PrimBSTAnotherVersion(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		for(int i = 0;i<G.V();i++)
			visit(G,min());
	}
	
	private int min() {
		int v = 0;
		double dis = Double.POSITIVE_INFINITY;
		for(int i = 1;i<distTo.length;i++) {
			if(marked[i]) continue;
			if(dis>distTo[i]) {
				v = i;
				dis = distTo[i];
			}
		}
			
		return v;
	}
	
	private void visit(EdgeWeightedGraph G,int v) {
		marked[v] = true;
		for(Edge e : G.adj(v)) {
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.weight()<distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = e.weight();
			}
		}
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> mst = new Bag<Edge>();
		for(int v = 1;v<edgeTo.length;v++)
			mst.add(edgeTo[v]);
		return mst;
	}
	
	 public static void main(String[] args) {
		 In in = new In(args[0]);
	     EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	     PrimBSTAnotherVersion mst = new PrimBSTAnotherVersion(G);
	     for (Edge e : mst.edges()) 
	          StdOut.println(e);
	     
	  }
}
