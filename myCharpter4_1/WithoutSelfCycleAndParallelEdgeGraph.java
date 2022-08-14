package myCharpter4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class WithoutSelfCycleAndParallelEdgeGraph {
	private int V;
	private int E;
	private	Bag<Integer>[] adj;
	
	public WithoutSelfCycleAndParallelEdgeGraph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[v];
		for(int i = 0;i<v;i++)
			adj[i] = new Bag<Integer>();
	}
	public WithoutSelfCycleAndParallelEdgeGraph(In in) {
		this(in.readInt());
		this.E = in.readInt();
		for(int i = 0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public int V() { return V;}
	public int E() { return E;}
	public void addEdge(int v,int w) {
		assert !hasSelfCycle(v,w) : "It has self cycle!";
		assert !hasParallelEdge(v,w) : "It has parallelEdge!";
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{ return adj[v];}
	
	private boolean hasSelfCycle(int v,int w) {
		if(v==w) return true;
		return false;
	}
	
	public boolean hasEdge(int v,int w) {
		for(int m : adj[v])
			if(m==w) return true;
		return false;
	}
	
	private boolean hasParallelEdge(int v,int w) {
		return hasEdge(v,w);
	}
}
