package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;

public class MyEdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<MyEdge>[] adj;
	
	public MyEdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<MyEdge>[]) new Bag[V];
		for(int v = 0;v<V;v++)
			adj[v] = new Bag<MyEdge>();
	}
	
	public MyEdgeWeightedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++) {
			MyEdge e = new MyEdge(in.readInt(),in.readInt(),in.readDouble());
			addEdge(e);
		}
	}
	
	public int V() { return V;}
	public int E() { return E;}
	
	public void addEdge(MyEdge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public MyEdge twoVertex(int v,int w) {
		for(MyEdge s : adj[v])
			if(s.other(v)==w) return s;
		return null;
	}
	
	public Iterable<MyEdge> adj(int v)
	{ return adj[v];}
	
	public Iterable<MyEdge> edges(){
		Bag<MyEdge> b = new Bag<MyEdge>();
		for(int v = 0;v<V;v++)
			for(MyEdge e : adj[v])
				if(e.other(v)>v) b.add(e);
		return b;
	}
	
	public void addVertex(int v,int w,double weighted) {
		MyEdge e = new MyEdge(v,w,weighted);
		this.addEdge(e);
	}
	
	public String toString() {
		String s = "";
		for(MyEdge e : this.edges())
			s = s+e+"\n";
		return s;
	}
}
