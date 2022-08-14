package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPathsPro {
	private boolean[] marked;
	private boolean[] cycleMarked;
	private int[] edgeTo;
	private final int s;
	private int[] distance;
	private Graph G;
	public BreadthFirstPathsPro(Graph G,int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distance = new int[G.V()];
		this.s = s;
		this.G = G;
		bfs(G,s);
	}
	
	private void bfs(Graph G,int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		distance[s] = 0;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v))
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					distance[w] = distance[v]+1;
					queue.enqueue(w);
				}
		}
	}
	
	public boolean hasPathTo(int v)
	{ return marked[v];}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x!=s;x=edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	public int distTo(int x) {
		if(x>=marked.length) throw new RuntimeException("Sorry,it is worry!");
		return distance[x];
	}
	public int maxDis() {
		int max = 0;
		for(int i = 0;i<distance.length;i++)
			max = max>distance[i] ? max : distance[i];
		return max;
	}
	public int minDis() {
		int min = 0;
		for(int i = 0;i<distance.length;i++)
			min = min>distance[i] ? min : distance[i];
		return min;
	}

	public int cycleLength() {
		cycleMarked = new boolean[this.G.V()];
		return cycleCheck(s);
	}
	private int cycleCheck(int v) {
		Queue<Integer> queue = new Queue<Integer>();
		cycleMarked[v] = true;
		queue.enqueue(v);
		while(!queue.isEmpty()) {
			int t = queue.dequeue();
			for(int w : G.adj(t))
				if(!cycleMarked[w]) {
					cycleMarked[w] = true;
					queue.enqueue(w);
				}else if(w!=edgeTo[t]) 
					return distTo(w)+distTo(t)+1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(1, 2);
		g.addEdge(0, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(0, 2);
		g.addEdge(3, 6);
		BreadthFirstPathsPro b = new BreadthFirstPathsPro(g,0);
		System.out.println(b.distTo(1));
		System.out.println(b.distTo(2));
		System.out.println(b.distTo(3));
		System.out.println(b.distTo(4));
		System.out.println(b.distTo(5));
		System.out.println(b.distTo(6));
	}
}
