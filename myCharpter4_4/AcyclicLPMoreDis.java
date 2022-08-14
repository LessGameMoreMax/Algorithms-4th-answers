package myCharpter4_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class AcyclicLPMoreDis {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private Queue<MyDirectedEdge>[] edgeTo; 
	private double[] distTo;
	
	public AcyclicLPMoreDis(MyEdgeWeightedDigraph G,int s) {
		edgeTo = (Queue<MyDirectedEdge>[])new Queue[G.V()];
		distTo = new double[G.V()];
		for(int i = 0;i<G.V();i++) {
			if(i!=s) edgeTo[i] = new Queue<MyDirectedEdge>();
			distTo[i] = Double.NEGATIVE_INFINITY;
		}
		distTo[s] = 0.0;
		EdgeWeightedTopological top = new EdgeWeightedTopological(G);
		for(int v : top.order()) relax(G,v);
	}
	
	private void relax(MyEdgeWeightedDigraph G,int v) {
		for(MyDirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w]<distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
				distTo[w] = distTo[v] + e.weight();						//注意此处小数
				while(!edgeTo[w].isEmpty()) edgeTo[w].dequeue();
				edgeTo[w].enqueue(e);
			}else if(Math.abs(distTo[w]-distTo[v]-e.weight())<FLOATING_POINT_EPSILON) {
				edgeTo[w].enqueue(e);
			}
		}
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		return distTo[v]>Double.NEGATIVE_INFINITY;
	}
	
	public Queue<Stack<MyDirectedEdge>> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Queue<Stack<MyDirectedEdge>> queue = (Queue<Stack<MyDirectedEdge>>) new Queue();
		for(MyDirectedEdge e : edgeTo[v]) {
			Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
			stack.push(e);
			pathTo(queue,stack,edgeTo[e.from()]);
		}
		return queue;
	}
	
	private void pathTo(Queue<Stack<MyDirectedEdge>> queue,Stack<MyDirectedEdge> stack,Queue<MyDirectedEdge> edges) {
		if(edges==null) { queue.enqueue(stack); return;}
		for(MyDirectedEdge e : edges) {
			Stack<MyDirectedEdge> s = new Stack<MyDirectedEdge>();
			Stack<MyDirectedEdge> q = new Stack<MyDirectedEdge>();
			for(MyDirectedEdge edge : stack) q.push(edge);
			for(MyDirectedEdge edge : q) s.push(edge);
			s.push(e);
			pathTo(queue,s,edgeTo[e.from()]);
		}
	}
}
