package myCharpter4_1;

import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;

public class GraphProperties {
	Graph G;
	public GraphProperties(Graph G) {
		CC cc = new CC(G);
		if(cc.count()!=1) throw new RuntimeException("Sorry,it is wrong!");
		this.G = G;
	}
	
	public int eccentricity(int v) {
		if(v<0||v>=G.V()) throw new RuntimeException("Sorry,it is illegal!");
		BreadthFirstPathsPro b = new BreadthFirstPathsPro(G,v);
		return b.maxDis();
	}
	
	public int diameter() {
		int max = 0;
		for(int v = 0;v<G.V();v++) {
			BreadthFirstPathsPro b = new BreadthFirstPathsPro(G,v);
			int maxTemp = b.maxDis();
			max = max>maxTemp?max:maxTemp;
		}
		return max;	
	}
	
	public int radius() {
		BreadthFirstPathsPro b = new BreadthFirstPathsPro(G,0);
		int min = b.maxDis();
		for(int v = 1;v<G.V();v++) {
			b = new BreadthFirstPathsPro(G,v);
			int minTemp = b.maxDis();
			min = min<minTemp?min:minTemp;
		}
		return min;	
	}
	
	public int center() {
		int r = radius();
		for(int v = 0;v<G.V();v++)
			if(r==eccentricity(v)) return v; 
		return G.V();
	}
	
	public int girth() {
		Cycle c = new Cycle(G);
		if(!c.hasCycle()) throw new RuntimeException("Infinite!");
		return countCycle(G);
	}
	
	private int countCycle(Graph G) {
		int min = -1;
		int i = 0;
		while(min==-1) {
			BreadthFirstPathsPro b = new BreadthFirstPathsPro(G,i);
			min = b.cycleLength();
			i++;
		}
		for(int j = i;j<G.V();j++) {
			BreadthFirstPathsPro b = new BreadthFirstPathsPro(G,j);
			int temp = b.cycleLength();
			if(temp!=-1)
			min = min<temp?min:temp;
		}
		return min;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(1, 2);
		g.addEdge(0, 1);
//		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(0, 4);
//		g.addEdge(0, 2);
		g.addEdge(3, 6);
		GraphProperties b = new GraphProperties(g);
		System.out.println(b.girth());
	}
}
