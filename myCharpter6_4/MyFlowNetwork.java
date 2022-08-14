package myCharpter6_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class MyFlowNetwork {
	private final int V;
	private int E;
	private Bag<MyFlowEdge>[] adj;
	
	public MyFlowNetwork(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<MyFlowEdge>[]) new Bag[V];
		for(int v = 0;v < V; v++)
			adj[v] = new Bag<MyFlowEdge>();
	}
	
	public MyFlowNetwork(In in) {
		this(in.readInt());
	}
	
	public int V() { return V;}
	public int E() { return E;}
	
	public void addEdge(MyFlowEdge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public Iterable<MyFlowEdge> adj(int v)
	{ return adj[v];}
	
	public Iterable<MyFlowEdge> edges(){
		Bag<MyFlowEdge> b = new Bag<MyFlowEdge>();
		for(int v = 0;v < V;v++)
			for(MyFlowEdge e : adj[v])
				if(e.other(v)>V) b.add(e);
		return b;
	}
}
