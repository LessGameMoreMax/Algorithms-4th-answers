package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class MyBellmanFordSP {
	private double[] distTo;
	private MyDirectedEdge[] edgeTo;
	private boolean[] onQ;
	private Queue<Integer> queue;
	private int cost;
	private Iterable<MyDirectedEdge> cycle;
	
	public MyBellmanFordSP(MyEdgeWeightedDigraph G,int s) {
		distTo = new double[G.V()];
		edgeTo = new MyDirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<Integer>();
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while(!queue.isEmpty()&&!this.hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G,v);
		}
	}
	
	public MyBellmanFordSP(MyEdgeWeightedDigraph G) {
		distTo = new double[G.V()];
		edgeTo = new MyDirectedEdge[G.V()];
		for(int v = 0;v<G.V();v++)
			distTo[v] = 0.0;
		for(int pass = 0;pass < G.V();pass++)
			for(int v = 0;v<G.V();v++)
				for(MyDirectedEdge e : G.adj(v))
					relaxEdge(e);
	}
	
	private void relaxEdge(MyDirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if(distTo[w]>distTo[v]+e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
		if(cost++%distTo.length == 0)
			findNegativeCycle();
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w]) {
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			if(cost++%G.V() == 0)
				findNegativeCycle();
		}
	}
	
	public double distTo(int v)
	{ return distTo[v];}
	
	public boolean hasPathTo(int v) {
		assert !hasNegativeCycle() : "Sorry,it has cycle!";
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		assert !hasNegativeCycle() : "Sorry,it has cycle!";
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	private void findNegativeCycle() {
		int V = edgeTo.length;
		MyEdgeWeightedDigraph spt = new MyEdgeWeightedDigraph(V);
		for(int v = 0;v<V;v++)
			if(edgeTo[v]!=null)
				spt.addEdge(edgeTo[v]);
		EdgeWeightedCycleFinderBellmanFord cf = new EdgeWeightedCycleFinderBellmanFord(spt);
		cycle = cf.cycle();
	}
	
	public boolean hasNegativeCycle()
	{ return cycle!=null;}
	
	public Iterable<MyDirectedEdge> negativeCycle()
	{ return cycle;}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		MyBellmanFordSP B = new MyBellmanFordSP(G);
		if(B.hasNegativeCycle()) 
			for(MyDirectedEdge e : B.negativeCycle())
				System.out.println(e);
		else
			System.out.println("none");
	}
}
