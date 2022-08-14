package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;

public class SlowSCC {
	private Digraph G;
	private boolean[] ccMarked;
	public SlowSCC(Digraph G) {
		this.G = G;
	}
	
	public Iterable<Integer> vCC(int v){
		Queue<Integer> q = new Queue<Integer>();
		DirectedDFS V = new DirectedDFS(G,v);
		for(int i = 0;i<G.V();i++)
			if(V.marked(i)) {
				DirectedDFS I = new DirectedDFS(G,i);
				if(I.marked(v)) q.enqueue(i);
			}
		return q;
	}
	
	public void printSCC() {
		ccMarked = new boolean[G.V()];
		for(int i = 0;i<G.V();i++) {
			if(ccMarked[i]) continue;
			for(int w : vCC(i)) {
				ccMarked[w] = true;
				System.out.print(w+" ");
			}
			System.out.println();
		}
			
	}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(13);
		G.addEdge(0, 2);
		G.addEdge(0, 6);
		G.addEdge(1, 0);
		G.addEdge(2, 3);
		G.addEdge(2, 4);
		G.addEdge(3, 2);
		G.addEdge(3, 4);
		G.addEdge(4, 5);
		G.addEdge(4, 6);
		G.addEdge(4, 11);
		G.addEdge(5, 3);
		G.addEdge(5, 0);
		G.addEdge(6, 7);
		G.addEdge(7, 8);
		G.addEdge(8, 7);
		G.addEdge(9, 6);
		G.addEdge(9, 8);
		G.addEdge(9, 12);
		G.addEdge(10, 9);
		G.addEdge(11, 9);
		G.addEdge(12, 11);
		G.addEdge(12, 10);
		SlowSCC cc = new SlowSCC(G);
//		for(int i : cc.vCC(3))
//		System.out.print(i+" ");
		cc.printSCC();
	}
	
	
}
