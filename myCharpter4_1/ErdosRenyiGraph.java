package myCharpter4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyiGraph {
	public static GraphPro conductorGraph() {
		System.out.println("Please input the V:");
		int V = StdIn.readInt();
		System.out.println("Please input the E:");
		int E = StdIn.readInt();
		GraphPro G = new GraphPro(V);
		if(E<0||E>(V*V-1)/2) throw new RuntimeException("Sorry,wrong!");
		while(G.E()<E) {
			int v = StdRandom.uniform(V);
			int w = StdRandom.uniform(V);
			if(v==w||G.connected(v, w)) continue;
			G.addEdge(v, w);
		}
		return G;
	}
}
