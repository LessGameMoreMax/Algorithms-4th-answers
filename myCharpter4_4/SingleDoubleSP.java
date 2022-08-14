package myCharpter4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class SingleDoubleSP {
	private double[] distToMin;
	private double[] distToMax;
	private MyDirectedEdge[] edgeToMin;
	private MyDirectedEdge[] edgeToMax;
	private MinPQ<MyDirectedEdge> pqMin;
	private MaxPQ<MyDirectedEdge> pqMax;
	Queue<MyDirectedEdge> queue;
	Integer vertex;
	
	public SingleDoubleSP(MyEdgeWeightedDigraph G,int s,int t) {
		distToMin = new double[G.V()];
		edgeToMin = new MyDirectedEdge[G.V()];
		pqMin = new MinPQ<MyDirectedEdge>();

		for(int v = 0;v<G.V();v++)
			distToMin[v] = Double.POSITIVE_INFINITY;
		distToMin[s] = 0.0;
		
		for(MyDirectedEdge e : G.edges()) {
			if(e.from()==s&&e.to()==t) continue; 
			pqMin.insert(e);
		}
		
		while(!pqMin.isEmpty())
			relax(pqMin.delMin(),distToMin,edgeToMin);
		
		double resultDis = Double.POSITIVE_INFINITY;
		queue = new Queue<MyDirectedEdge>();
		
		for(int i = 0;i<edgeToMin.length;i++) {
			if(i==s||i==t||edgeToMin[i]==null) continue;
			
			edgeToMax = new MyDirectedEdge[G.V()];
			pqMax = new MaxPQ<MyDirectedEdge>();
			distToMax = new double[G.V()];
			
			for(int v = 0;v<G.V();v++)
				distToMax[v] = Double.POSITIVE_INFINITY;
			distToMax[i] = 0.0;

			for(MyDirectedEdge e : G.edges()) {
				if(e.from()==i&&e.to()==t&&e.weight()>=edgeToMin[i].weight()) continue; 
				pqMax.insert(e);
			}
				
			
			while(!pqMax.isEmpty())
				relax(pqMax.delMax(),distToMax,edgeToMax);
			
			if(distToMax[t]<Double.POSITIVE_INFINITY&&distToMin[i]+distToMax[t]<resultDis) {
				vertex = i;
				resultDis = distToMin[i] + distToMax[t];
				while(!queue.isEmpty()) queue.dequeue();
				for(MyDirectedEdge e = edgeToMax[t];e!=null;e = edgeToMax[e.from()])
					queue.enqueue(e);
			}
		}
		
		
	}
	
	private void relax(MyDirectedEdge e,double[] distTo,MyDirectedEdge[] edgeTo) {
		int v = e.from();
		int w = e.to();
		if(distTo[w]>distTo[v]+e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
	}
	
	public Iterable<MyDirectedEdge> path(){
		if(vertex==null) return null;
		Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
		for(MyDirectedEdge e : queue) stack.push(e);
		for(MyDirectedEdge e = edgeToMin[vertex];e!=null;e = edgeToMin[e.from()])
			stack.push(e);
		return stack;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(5);
		G.addByVertex(0, 2, 0.2);
		G.addByVertex(0, 4, 0.8);
		G.addByVertex(0, 1, 0.1);
		G.addByVertex(1, 2, 0.2);
		G.addByVertex(2, 3, 0.15);
		G.addByVertex(3, 4, 0.1);
		SingleDoubleSP S = new SingleDoubleSP(G,0,1);
		for(MyDirectedEdge e : S.path())
			System.out.println(e);
	}
}
