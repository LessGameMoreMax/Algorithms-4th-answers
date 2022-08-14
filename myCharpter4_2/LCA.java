package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

public class LCA {
	private ST<Integer,Integer>[]  ancestorAndHeight;
	private ST<Integer,Integer> result;
	private boolean[] marked;
	private boolean[] reverseMarked;
	private boolean[] checkMarked;
	private int[] edgeTo;
	private Digraph G;
	
	public LCA(Digraph G) {
		this.G = G;
		ancestorAndHeight = (ST<Integer,Integer>[]) new ST[G.V()];
		for(int i = 0;i<G.V();i++)
			ancestorAndHeight[i] = new ST<Integer,Integer>();
		Degrees D = new Degrees(G);
		for(int ancestor : D.sources()) {
			marked = new boolean[G.V()];
			edgeTo = new int[G.V()];
			bfs(G,ancestor);
		}
	}
	private void bfs(Digraph G,int ancestor) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[ancestor] = true;
		ancestorAndHeight[ancestor].put(ancestor, 0);
		queue.enqueue(ancestor);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				edgeTo[w] = v;
				marked[w] = true;
				int height = ancestorAndHeight[edgeTo[w]].get(ancestor)+1;
				if(!ancestorAndHeight[w].contains(ancestor)||ancestorAndHeight[w].get(ancestor)<height)
					ancestorAndHeight[w].put(ancestor, height);
				queue.enqueue(w);
			}
		}
	}
	public ST<Integer,Integer> totalAncestor(int v,int w) {
		Queue<Integer> q = new Queue<Integer>();
		SET<Integer> V = (SET<Integer>) new SET();
		result = (ST<Integer,Integer>) new ST();
		for(int s : ancestorAndHeight[v].keys()) 
			V.add(s);
		for(int s : ancestorAndHeight[w].keys()) 
			if(V.contains(s)) q.enqueue(s);
		Digraph reverseG = G.reverse();
		reverseMarked = new boolean[G.V()];
		checkMarked = new boolean[G.V()];
		reverseBfs(reverseG,v);
		checkBfs(reverseG,w);
		while(!q.isEmpty()) {
			int ancestor = q.dequeue();
			for(int i = 0;i<G.V();i++)
				if(reverseMarked[i]&&checkMarked[i]&&ancestorAndHeight[i].contains(ancestor))
					if(!result.contains(ancestor))
						result.put(ancestor, i);
					else if(ancestorAndHeight[i].get(ancestor)>ancestorAndHeight[result.get(ancestor)].get(ancestor))
						result.put(ancestor, i);
		}
		return result;
	}
	private void reverseBfs(Digraph G,int s) {
		Queue<Integer> queue = new Queue<Integer>();
		reverseMarked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!reverseMarked[w]) {
					reverseMarked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	private void checkBfs(Digraph G,int s) {
		Queue<Integer> queue = new Queue<Integer>();
		checkMarked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!checkMarked[w]) {
					checkMarked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	public static void main(String[] args) {
		ST<Integer,Integer> st = (ST<Integer,Integer>)new ST();
		Digraph G = new Digraph(11);
		G.addEdge(1, 0);
		G.addEdge(0, 2);
		G.addEdge(1, 2);
		G.addEdge(0, 4);
		G.addEdge(0, 5);
		G.addEdge(5, 3);
		G.addEdge(4, 7);
		G.addEdge(5, 6);
		G.addEdge(6, 7);
		G.addEdge(2, 3);
		G.addEdge(3, 8);
		G.addEdge(9, 0);
		G.addEdge(10, 9);
		G.addEdge(4, 5);
		G.addEdge(4, 6);
		LCA L = new LCA(G);
		st = L.totalAncestor(7, 5);
		for(int ancestor : st.keys())
			System.out.println(ancestor+" : "+st.get(ancestor));
	}

}
