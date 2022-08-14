package myCharpter4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Topological;

public class DigraphPro {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public DigraphPro(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	public DigraphPro(In in) {
		this(in.readInt());
		this.E = in.readInt();
		for(int i = 0;i<this.E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w) {
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public DigraphPro reverse() {
		DigraphPro R = new DigraphPro(this.V);
		for(int v = 0;v<this.V;v++)
			for(int w : adj[v])
				addEdge(w,v);
		return R;
	}
	public boolean hasEdge(int v,int w) {
		for(int s : adj[v])
			if(s==w) return true;
		return false;
	}

}
