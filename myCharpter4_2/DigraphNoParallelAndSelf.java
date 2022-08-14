package myCharpter4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DigraphNoParallelAndSelf {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public DigraphNoParallelAndSelf(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	public DigraphNoParallelAndSelf(In in) {
		this(in.readInt());
		this.E = in.readInt();
		for(int i = 0;i<this.E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w) {
		if(isSelf(v,w)||isParallel(v,w)) throw new RuntimeException("Sorry,three is no self or parallel!");
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public DigraphNoParallelAndSelf reverse() {
		DigraphNoParallelAndSelf R = new DigraphNoParallelAndSelf(this.V);
		for(int v = 0;v<this.V;v++)
			for(int w : adj[v])
				addEdge(w,v);
		return R;
	}
	private boolean isSelf(int v,int w) {
		return v==w;
	}
	private boolean isParallel(int v,int w) {
		for(int s : adj[v])
			if(w==s) return true;
		return false;
	}
}

