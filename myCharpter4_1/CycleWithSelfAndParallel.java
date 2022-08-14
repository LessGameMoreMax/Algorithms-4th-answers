package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;

public class CycleWithSelfAndParallel {
	private boolean[] marked;
	private boolean hasCycle;
	public CycleWithSelfAndParallel(Graph G) {
		marked = new boolean[G.V()];
		for(int s = 0;s<G.V();s++)
			if(!marked[s])
				dfs(G,s,s);
	}
	
	private void dfs(Graph G,int v,int u) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w,v);
			else if(w!=u) hasCycle = true;
			else if(w==v) hasCycle = true;
		//ƽ�б߹��ɵ��ǲ��ǻ����˴�δ���ж�
	}
	public boolean hasCycle()
	{ return hasCycle;}
}
