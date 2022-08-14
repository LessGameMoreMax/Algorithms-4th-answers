package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

public class TopologicalBasedWithQueue {
	private int[] indegrees;
	private Queue<Integer> queue;
	private Digraph G;
	
	public TopologicalBasedWithQueue(Digraph G) {
		indegrees = new int[G.V()];
		this.G = G;
		Degrees D = new Degrees(G);
		for(int i = 0;i<G.V();i++) 
			indegrees[i] = D.indegree(i);
	}
	
	public void sort() {
		Degrees D = new Degrees(G);
		for(int s : D.sources())
			sort(s);
	}
	
	private void sort(int s){
		queue = new Queue<Integer>();
		print(s);
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				indegrees[w]--;
				if(indegrees[w]==0) {
					print(w);
					queue.enqueue(w);
				}
			}
				
		}
		
	}
	
	private void print(int v) {
		System.out.print(v+" ");
	}
	
	public static void main(String[] args) {
//		Digraph G = new Digraph(13);
//		G.addEdge(0, 1);
//		G.addEdge(0, 5);
//		G.addEdge(0, 6);
//		G.addEdge(2, 0);
//		G.addEdge(2, 3);
//		G.addEdge(3, 5);
//		G.addEdge(5, 4);
//		G.addEdge(6, 4);
//		G.addEdge(6, 9);
//		G.addEdge(7, 6);
//		G.addEdge(8, 7);
//		G.addEdge(9, 10);
//		G.addEdge(9, 11);
//		G.addEdge(9, 12);
//		G.addEdge(11, 12);
		Digraph G = new Digraph(4);
		G.addEdge(0, 1);
		G.addEdge(0, 3);
		G.addEdge(2, 1);
		G.addEdge(3, 1);
		G.addEdge(2, 3);
		TopologicalBasedWithQueue T = new TopologicalBasedWithQueue(G);
		T.sort();
	}
}
