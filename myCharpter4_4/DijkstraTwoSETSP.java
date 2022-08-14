package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class DijkstraTwoSETSP {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private MyDirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ pq;
	private double minDis;
	private int minIndex;
	private Queue<MyDirectedEdge> minPath;
	
	public DijkstraTwoSETSP(MyEdgeWeightedDigraph G,SET<Integer> start,SET<Integer> end) {
		assert !isIntersection(start,end) : "Sorry,it is Intersection";
		boolean flag = false;
		minDis = Double.POSITIVE_INFINITY;
		minIndex = Integer.MAX_VALUE;
		minPath = new Queue<MyDirectedEdge>();
		Dijkstra(G,start,end);
		for(Integer e : end) 
			if(distTo[e]<minDis&&Math.abs(distTo[e]-minDis)>FLOATING_POINT_EPSILON) {
				minIndex = e;
				minDis = distTo[e];
			}
		if(minIndex<Integer.MAX_VALUE)
			for(MyDirectedEdge e : this.pathTo(minIndex))
				minPath.enqueue(e);
		
		Dijkstra(G,end,start);
		for(Integer e : start) 
			if(distTo[e]<minDis&&Math.abs(distTo[e]-minDis)>FLOATING_POINT_EPSILON) {
				minIndex = e;
				minDis = distTo[e];
				flag = true;
			}
		if(minIndex<Integer.MAX_VALUE)
			if(flag) {
				while(!minPath.isEmpty()) minPath.dequeue();
				for(MyDirectedEdge e : this.pathTo(minIndex))
					minPath.enqueue(e);
			}
	}
	
	private void Dijkstra(MyEdgeWeightedDigraph G,SET<Integer> start,SET<Integer> end) {
		edgeTo = new MyDirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ(G.V());
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		for(Integer s : start) {
			distTo[s] = 0.0;
			pq.insert(s, 0.0);
		}
		while(!pq.isEmpty()) {
			int w = pq.delMin();
			if(!end.contains(w))
				relax(G,w);
		}
	}
	
	private boolean isIntersection(SET<Integer> start,SET<Integer> end) {
		for(Integer s : start)
			if(end.contains(s)) return true;
		return false;
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
	
	private Iterable<MyDirectedEdge> pathTo(int v){
		Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	public Iterable<MyDirectedEdge> minPath(){
		return minPath;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
		SET<Integer> start = new SET<Integer>();
		start.add(5);
		start.add(4);
		SET<Integer> end = new SET<Integer>();
		end.add(2);
		end.add(3);
		end.add(6);
		DijkstraTwoSETSP D = new DijkstraTwoSETSP(G,start,end);
		for(MyDirectedEdge e : D.minPath())
			System.out.println(e);
	}

}
