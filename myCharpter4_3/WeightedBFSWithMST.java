package myCharpter4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;

public class WeightedBFSWithMST {
	private Bag<Integer>[] adj;
	private boolean marked[];
	private int V;
	private int edgeTo[];
	private int s;
	private MyEdgeWeightedGraph G;
	
	 WeightedBFSWithMST(MyEdgeWeightedGraph G,int s) {
		MyLazyPrimMST mst = new MyLazyPrimMST(G);
		this.s = s;
		this.G = mst.getGraph();
		for(MyEdge e : mst.edges()) 
			V++;
		V++;
		adj = (Bag<Integer>[])new Bag[V];
		marked = new boolean[V];
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Integer>();
		edgeTo = new int[V];
		for(MyEdge e : mst.edges()) {
			int v = e.either();
			int w = e.other(v);
			adj[v].add(w);
			adj[w].add(v);
		}
		bfs(s);
	}
	
	private void bfs(int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : adj[v])
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
		}
	}
	
	public void printWeighted(int v) {
		if(connected(v)) {
			System.out.println("Connected!");
			return;
		}
		double maxWeighted = 0;
		int preWay = v;
		for(int x = edgeTo[v];x!=s;x=edgeTo[x]) {
			maxWeighted = Math.max(G.twoVertex(x, preWay).weight(),maxWeighted);
			preWay = x;
		}
		maxWeighted = Math.max(G.twoVertex(s, preWay).weight(),maxWeighted);
		System.out.print("Weighted must smaller than :"+maxWeighted);
	}
	
	private boolean connected(int v) {
		for(int i : adj[s])
			if(v==i) return true;
		return false;
	}
}
