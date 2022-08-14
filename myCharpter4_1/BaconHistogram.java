package myCharpter4_1;

import java.util.Iterator;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.SymbolGraph;

public class BaconHistogram {//wrong!
//	public static void main(String[] args) {
//		SymbolGraph sg = new SymbolGraph(args[0],args[1]);
//		
//		Graph G = sg.G();
//		
//		String source = args[2];
//		if(!sg.contains(source)) {
//			System.out.println(source + " not in database.");
//			return;
//		}
//		
//		int s = sg.index(source);
//		BreadthFirstPaths bfs = new BreadthFirstPaths(G,s);
//		ST<Integer,Integer> st = new ST<Integer,Integer>();
//		
//		In in = new In(args[0]);
//		SET<String> name = new SET<String>();
//		while(in.hasNextLine()) {
//			String[] a = in.readLine().split(args[1]);
//			for(int i = 1;i<a.length;i++) 
//				name.add(a[i]);
//		}
//		Iterator<String> t = name.iterator();
//		while(t.hasNext()) {
//			String str = t.next();
//			int index = sg.index(str);
//			int dis = bfs.distTo(index);
//			if(dis==2.0/0.0) dis=-1;
//			else dis /=2;
//			if(st.get(dis)==null)
//				st.put(dis, 1);
//			else
//				st.put(dis, st.get(dis)+1);
//		}
////		for(int i = 0;i<10;i++){
////			double x = 1.0*i/10;
////			double y = st.get(i)/2;
////			double rw = 0.5/10;
////			double rh = y;
////			StdDraw.filledRectangle(x, y, rw, rh);
////		}
//	}
}
