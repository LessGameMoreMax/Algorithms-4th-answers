package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

public class MyCC {
	private boolean[] marked;
	private int[] id;
	private int[] idCount;
	private int count;
	private Graph G;
	private Integer max;
	
	public MyCC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		idCount = new int[G.V()];
		this.G = G;
		for(int s = 0;s<G.V();s++)
			if(!marked[s]) {
				dfs(G,s);
				count++;
			}
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		id[v] = count;
		idCount[count]++;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	
	public boolean connected(int v,int w)
	{ return id[v] == id[w];}
	public int id(int v)
	{ return id[v];}
	public int count()
	{ return count;}
	public boolean isInMax(int v) {
		max();
		return max==id[v];
	}
	private void max() {
		if(max!=null) return;
		for(int i = 1;idCount[i]!=0;i++)
			max = idCount[max]>idCount[i]?max:i;
	}
	public int countCCNumberBelowTen() {
		int count = 0;
		for(int i = 0;idCount[i]!=0;i++)
			if(idCount[i]<10) count++;
		return count;
	}
	public Graph maxCCGraph() {
		int count = 0;
		RedBlackBST<Integer,Integer> st = new RedBlackBST<Integer,Integer>();
		for(int i = 0;i<id.length;i++)
			if(id[i]==max) st.put(i, count++);
		Graph g = new Graph(count);
		for(int indexV : st.keys())
			for(int indexW : G.adj(indexV))
				g.addEdge(st.get(indexV), st.get(indexW));
		return g;
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
		MyCC c = new MyCC(g);
		
	}
	
}
