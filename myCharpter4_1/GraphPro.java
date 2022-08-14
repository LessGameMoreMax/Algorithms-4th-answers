package myCharpter4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class GraphPro {
		private int V;
		private int E;
		private	Bag<Integer>[] adj;
		
		public GraphPro(int v) {
			this.V = v;
			this.E = 0;
			adj = (Bag<Integer>[])new Bag[v];
			for(int i = 0;i<v;i++)
				adj[i] = new Bag<Integer>();
		}
		public GraphPro(In in) {
			this(in.readInt());
			this.E = in.readInt();
			for(int i = 0;i<E;i++) {
				int v = in.readInt();
				int w = in.readInt();
				addEdge(v,w);
			}
		}
		public int V() { return V;}
		public int E() { return E;}
		public void addEdge(int v,int w) {
			adj[v].add(w);
			adj[w].add(v);
			E++;
		}
		public Iterable<Integer> adj(int v)
		{ return adj[v];}
		
		public String toString() {
			String s = "";
			for(int v = 0;v<V;v++) {
				s=s+v+" : ";
				for(int w:adj[v])
					s = s+" "+w+" ";
				s += '\n';
			}
			return s;
		}
		public boolean connected(int v,int w) {
			for(int i : adj(v))
				if(i==w) return true;
			return false;
		}
		
		public static void main(String[] args) {
			GraphPro g = new GraphPro(13);
			g.addEdge(0, 5);
			g.addEdge(4, 3);
			g.addEdge(0, 1);
			g.addEdge(9, 12);
			g.addEdge(6, 4);
			g.addEdge(5, 4);
			g.addEdge(0, 2);
			g.addEdge(11, 12);
			g.addEdge(9, 10);
			g.addEdge(0, 6);
			g.addEdge(7, 8);
			g.addEdge(9, 11);
			g.addEdge(5, 3);
			System.out.print(g);
		}
}
