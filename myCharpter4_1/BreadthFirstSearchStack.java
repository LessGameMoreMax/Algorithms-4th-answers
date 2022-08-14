package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstSearchStack {	//WRONG!
//	private boolean[] marked;
//	private int[] edgeTo;
//	private final int s;
//	private int[] distance;
//	
//	public BreadthFirstSearchStack(Graph G,int s) {
//		marked = new boolean[G.V()];
//		edgeTo = new int[G.V()];
//		distance = new int[G.V()];
//		this.s = s;
//		bfs(G,s);
//	}
//	
//	private void bfs(Graph G,int s) {
//		Stack<Integer> stack = new Stack<Integer>();
//		marked[s] = true;
//		distance[s] = 0;
//		stack.push(s);
//		while(!stack.isEmpty()) {
//			int v = stack.pop();
//			for(int w : G.adj(v))
//				if(!marked[w]) {
//					edgeTo[w] = v;
//					marked[w] = true;
//					distance[w] = distance[v]+1;
//					stack.push(w);
//				}
//		}
//	}
//	
//	public boolean hasPathTo(int v)
//	{ return marked[v];}
//	public Iterable<Integer> pathTo(int v){
//		if(!hasPathTo(v)) return null;
//		Stack<Integer> path = new Stack<Integer>();
//		for(int x = v;x!=s;x=edgeTo[x])
//			path.push(x);
//		path.push(s);
//		return path;
//	}
//	public int distTo(int x) {
//		if(x>=marked.length) throw new RuntimeException("Sorry,it is worry!");
//		return distance[x];
//	}
//	
//	public static void main(String[] args) {
//		Graph g = new Graph(7);
//		g.addEdge(0, 5);
//		g.addEdge(2, 4);
//		g.addEdge(2, 3);
//		g.addEdge(1, 2);
//		g.addEdge(0, 1);
//		g.addEdge(3, 4);
//		g.addEdge(3, 5);
//		g.addEdge(0, 2);
//		g.addEdge(3, 6);
//		BreadthFirstSearchStack b = new BreadthFirstSearchStack(g,1);
//		System.out.println(b.distTo(0));
//		System.out.println(b.distTo(2));
//		System.out.println(b.distTo(3));
//		System.out.println(b.distTo(4));
//		System.out.println(b.distTo(5));
//		System.out.println(b.distTo(6));
//	}
}