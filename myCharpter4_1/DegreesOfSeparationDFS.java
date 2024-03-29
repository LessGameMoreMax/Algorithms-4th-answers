package myCharpter4_1;

import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class DegreesOfSeparationDFS {
	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph(args[0],args[1]);
		Graph G = sg.G();
		String source = args[2];
		if(!sg.contains(source))
		{ StdOut.println(source + "not in database."); return;}
		int s = sg.index(source);
		DepthFirstPaths dfs = new DepthFirstPaths(G,s);
		while(!StdIn.isEmpty()) {
			String sink = StdIn.readLine();
			if(sg.contains(sink)) {
				int t = sg.index(sink);
				if(dfs.hasPathTo(t)) 
					for(int v : dfs.pathTo(t))
					StdOut.println("     "+sg.name(v));
				else StdOut.println("Not connected");
			}
			else StdOut.println("Not in database.");
		}
	}
}
