package myCharpter1_5;

public class WeightedQuickFindBeta {
	private int count;
	private int[] sz;
	private int[] id;
	
	public WeightedQuickFindBeta(int N) {
		count = N;
		sz = new int[N];
		id = new int[N];
		for(int i = 0;i<N;i++)
			sz[i] = 1;
		for(int i = 0;i<N;i++)
			id[i] = i;
	}
	
	public int count()
	{ return count;}
	
	public boolean connected(int p,int q)
	{ return find(p)==find(q);}
	
	public int find(int p)
	{return id[p];}
	
	public void union(int p,int q) {
		int pId = find(p);
		int qId = find(q);
		
		if(pId==qId) return;
		
		if(sz[pId]>sz[qId]) {
			for(int i =0;i<id.length;i++)
				if(id[i]==qId) id[i] = pId;
			sz[pId] += sz[qId];
		}
		else {
			for(int j =0;j<id.length;j++)
				if(id[j]==pId) id[j] = qId;
			sz[qId] += sz[pId];
		}
		count--;
	}
}
