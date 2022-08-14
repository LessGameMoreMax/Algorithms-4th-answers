package myCharpter4_3;

public class IsCCGraphDelete {
	private boolean[] marked;
	private boolean isCC;
	public IsCCGraphDelete(GraphDelete G) {
		marked = new boolean[G.V()];
		isCC = true;
		dfs(G,0);
		for(int i = 0;i<G.V();i++)
			if(!marked[i]) isCC = false; 
	}
	
	public boolean isCC()
	{ return isCC;}
	
	private void dfs(GraphDelete G,int v) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
}
