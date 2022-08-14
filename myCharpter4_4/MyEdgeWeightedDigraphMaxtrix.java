package myCharpter4_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class MyEdgeWeightedDigraphMaxtrix {
	private Double[][] vertex;
	private int V;
	private int E;
	
	public MyEdgeWeightedDigraphMaxtrix(int V) {
		this.V = V;
		this.E = 0;
		vertex = new Double[V][V];
	}
	
	public MyEdgeWeightedDigraphMaxtrix(In in) {
		this(in.readInt());
		this.E = in.readInt();			//注意此处初始化的为成员变量
		for(int i = 0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			vertex[v][w] = in.readDouble();
		}
	}
	
	public int V() { return V;}
	public int E() { return E;}
	
	public void addEdge(int v,int w,double weight) {
		vertex[v][w] = weight;
		E++;
	}
	
	public Iterable<MyDirectedEdge> adj(int v){
		Bag<MyDirectedEdge> bag = new Bag<MyDirectedEdge>();
		for(int i = 0;i<V;i++) {
			Double weight = vertex[v][i];
			if(weight!=null)  bag.add(new MyDirectedEdge(v,i,weight));
		}
		return bag;
	}
	
	public Iterable<MyDirectedEdge> edges(){
		Bag<MyDirectedEdge> bag = new Bag<MyDirectedEdge>();
		for(int i = 0;i<V;i++)
			for(MyDirectedEdge e : adj(i))
				bag.add(e);
		return bag;
	}
	
	public String toString() {
		String s = "";
		for(MyDirectedEdge e : edges())
			s = s + e + "\n";
		return s;
	}
	
	public static void main(String[] args) {
		MyEdgeWeightedDigraphMaxtrix G = new MyEdgeWeightedDigraphMaxtrix(new In(args[0]));
		System.out.print(G);
	}
}
