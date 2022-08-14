package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class Degrees {
	private int[] in;
	private int[] out;
	public Degrees(Digraph G) {
		in = new int[G.V()];
		out = new int[G.V()];
		for(int v = 0;v<G.V();v++)
			for(int w : G.adj(v)) {
				out[v]++;
				in[w]++;
			}
	}
	public int indegree(int v) {
		return in[v];
	}
	public int outdegree(int v) {
		return out[v];
	}
	public Iterable<Integer> sources(){
		Queue<Integer> q = new Queue<Integer>();
		for(int v = 0; v<in.length; v++)
			if(in[v]==0) q.enqueue(v);
		return q;
	}
	public Iterable<Integer> sinks(){
		Queue<Integer> q = new Queue<Integer>();
		for(int v = 0; v<out.length; v++)
			if(out[v]==0) q.enqueue(v);
		return q;
	}
	public boolean isMap() {
		for(int v = 0;v<out.length;v++)
			if(out[v]!=1) return false;
		return true;
	}
}
