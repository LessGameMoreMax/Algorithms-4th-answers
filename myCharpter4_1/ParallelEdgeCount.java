package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

public class ParallelEdgeCount {
	private boolean[] marked;
	private int[] edgeTo;
	private int number;
	public ParallelEdgeCount(Graph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int i = 0;i<G.V();i++)
		if(!marked[i]) bfs(G,i);
		number /=2;
	}
	private void bfs(Graph G,int s) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(s);
		marked[s] = true;
		while(!queue.isEmpty()) {
			SET<Integer> set = new SET<Integer>();
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
				if(!set.contains(w))
					set.add(w);
				else number++;
			}
				
		}
	}
	public int count() {
		return number;
	}
	
}
