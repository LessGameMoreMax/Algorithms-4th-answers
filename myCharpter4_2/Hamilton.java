package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Topological;

public class Hamilton {
	private SET<Integer>[] adj;
	private boolean isHamilton;
	public Hamilton(Digraph G) {
		if(G.V()==1) {
			isHamilton = true;
			return;
		}
		adj = (SET<Integer>[])new SET[G.V()];
		for(int i = 0;i<G.V();i++) {
			adj[i] = (SET<Integer>)new SET();
			for(int v : G.adj(i))
				adj[i].add(v);
		}
		Topological T = new Topological(G);
		boolean isFirst = true;
		int pre = 0;
		for(int v : T.order()) {
			if(isFirst) {
				pre = v;
				isFirst = false;
			}
			else {
				if(!adj[pre].contains(v))
					return;
				pre = v;
			}
		}
		isHamilton = true;
	}
	
	public boolean isHamilton() {
		return isHamilton;
	}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(1);
//		G.addEdge(0, 1);
//		G.addEdge(1, 2);
//		G.addEdge(1, 3);
//		G.addEdge(2, 3);
		Hamilton H = new Hamilton(G);
		System.out.println(H.isHamilton);
	}
}
