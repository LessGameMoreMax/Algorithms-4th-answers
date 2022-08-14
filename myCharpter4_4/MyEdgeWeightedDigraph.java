package myCharpter4_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class MyEdgeWeightedDigraph {
	private final int V;
	private int E;
	private Bag<MyDirectedEdge>[] adj;
	
	public MyEdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<MyDirectedEdge>[]) new Bag[V];
		for(int v = 0;v<V;v++)
			adj[v] = new Bag<MyDirectedEdge>();
	}
	
	public MyEdgeWeightedDigraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			MyDirectedEdge e = new MyDirectedEdge(v,w,weight);
			addEdge(e);
		}
	}
	
	public int V() { return V;}
	public int E() { return E;}
	public void addEdge(MyDirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}
	public void addByVertex(int v,int w,double weight) {
		MyDirectedEdge e = new MyDirectedEdge(v,w,weight);
		addEdge(e);
	}
	public MyDirectedEdge edgeFinder(int v,int w) {
		for(MyDirectedEdge e : this.adj(v))
			if(e.to()==w) return e;
		return null;
	}
	public Iterable<MyDirectedEdge> adj(int v){
		return adj[v];
	}
	public Iterable<MyDirectedEdge> edges(){
		Bag<MyDirectedEdge> bag = new Bag<MyDirectedEdge>();
		for(int v = 0;v<V;v++)
			for(MyDirectedEdge e : adj[v])
				bag.add(e);
		return bag;
	}
	public String toString() {
		String s = "";
		for(MyDirectedEdge e : edges())
			s = s + e + "\n";
		return s;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		System.out.println(G);
		System.out.print(G.E());
	}
}
