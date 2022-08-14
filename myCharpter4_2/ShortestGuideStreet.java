package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class ShortestGuideStreet {
	private Digraph reverseG;
	private Digraph G;
	private boolean[] markedV;
	private boolean[] markedW;
	private int[] disV;
	private int[] disW;

	public ShortestGuideStreet(Digraph G) {
		this.G = G;
		this.reverseG = G.reverse();
	}
	
	public void shortestStreetPrint(int v,int w) {
		Queue<Integer> x = new Queue<Integer>();
		markedV = new boolean[reverseG.V()];
		markedW = new boolean[reverseG.V()];
		disV = new int[reverseG.V()];
		disW = new int[reverseG.V()];
		bfs(reverseG,v,markedV,disV);
		bfs(reverseG,w,markedW,disW);
		boolean isFirst = true;
		for(int i = 0;i<reverseG.V();i++) {
			if(markedV[i]&&markedW[i])
				if(isFirst) {
					x.enqueue(i);;
					isFirst = false;
				}
				else {
					int m = x.dequeue();
					if(disV[i]+disW[i]<disV[m]+disW[m]) {
						while(!x.isEmpty()) x.dequeue();
						x.enqueue(i);
					}
					else if(disV[i]+disW[i]==disV[m]+disW[m]) {
						x.enqueue(i);
						x.enqueue(m);
					}
					else
						x.enqueue(m);
				}
		}
		while(!x.isEmpty()) {
			int m = x.dequeue();
			BreadthFirstPathsDigraph M = new BreadthFirstPathsDigraph(G,m);
			M.pathPrint(v);
			System.out.print("  ");
			M.pathPrint(w);
			System.out.println();	
		}
		
	}
	
	
	private void bfs(Digraph reverseG,int s,boolean[] markedS,int[] disS) {
		Queue<Integer> queue = new Queue<Integer>();
		markedS[s] = true;
		disS[s] = 0;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : reverseG.adj(v))
				if(!markedS[w]) {
					markedS[w] = true;
					disS[w] = disS[v]+1;
					queue.enqueue(w);
				}
		}
	}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(7);
		G.addEdge(0, 1);
		G.addEdge(0, 5);
		G.addEdge(1, 5);
		G.addEdge(1, 2);
		G.addEdge(1, 3);
		G.addEdge(3, 5);
		G.addEdge(3, 2);
		G.addEdge(2, 6);
		ShortestGuideStreet S = new ShortestGuideStreet(G);
		S.shortestStreetPrint(5, 6);
	}
}
