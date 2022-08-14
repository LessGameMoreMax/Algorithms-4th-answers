package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SET;

public class DijkstraMoreStart {
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ pq;
	private SET<Integer> s;
	
	public DijkstraMoreStart(MyEdgeWeightedDigraph G,Queue<Integer> start) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ(G.V());
		s = new SET<Integer>();
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		while(!start.isEmpty()) {
			int s = start.dequeue();
			distTo[s] = 0.0;
			pq.insert(s, 0.0);
			this.s.add(s);;
		}
		while(!pq.isEmpty())
			relax(G,pq.delMin());
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]>distTo[v]+e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else			   pq.insert(w, distTo[w]);
			}
		}
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<MyDirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	public Queue<Queue<MyDirectedEdge>> allPath(){
		Queue<Queue<MyDirectedEdge>> result = new Queue<Queue<MyDirectedEdge>>();
		for(int i = 0;i<edgeTo.length;i++) {
			if(s.contains(i)) continue;
			Queue<MyDirectedEdge> q = new Queue<MyDirectedEdge>();
			for(MyDirectedEdge e : pathTo(i))
				q.enqueue(e);
			result.enqueue(q);
		}
		return result;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		Queue<Integer> start = new Queue<Integer>();
		start.enqueue(1);
		start.enqueue(7);
		start.enqueue(0);
		start.enqueue(6);
		DijkstraMoreStart D = new DijkstraMoreStart(G,start);
		for(Queue<MyDirectedEdge> q : D.allPath()) {
			for(MyDirectedEdge e : q)
				System.out.println(e);
			System.out.println("*****************************");
		}
			
				
	}
}
