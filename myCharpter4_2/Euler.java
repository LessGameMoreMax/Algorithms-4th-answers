package myCharpter4_2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;

public class Euler {
	private int[] in;
	private int[] out;
	private ST<Integer,Queue<Integer>> union;
	public Euler(Digraph G) {
		in = new int[G.V()];
		out = new int[G.V()];
		for(int v = 0;v<G.V();v++)
			for(int w : G.adj(v)) {
				out[v]++;
				in[w]++;
			}
		DirectedDFSButUnion D = new DirectedDFSButUnion(G);
		union = D.CC();
	}
	public void eulerCycle(){
		for(int i = 0;i<union.size();i++) {
			boolean flag = true;
			Queue<Integer> q = union.get(i);
			if(q.size()==1) continue;
			for(int j = 0;j<q.size();j++) {
				int v = q.dequeue();
				if(in[v]!=out[v]) {
					flag = false;
					break;
				}
				q.enqueue(v);
			}
			if(flag) {
				while(!q.isEmpty())
					System.out.print(q.dequeue()+" ");
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Digraph G = new Digraph(7);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 1);
		G.addEdge(1, 3);
		G.addEdge(3, 2);
//		G.addEdge(2, 0);

		G.addEdge(4, 6);
		G.addEdge(6, 5);
		
		Euler E = new Euler(G);
		E.eulerCycle();
	}
}
