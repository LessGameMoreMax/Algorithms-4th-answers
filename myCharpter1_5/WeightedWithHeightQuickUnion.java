package myCharpter1_5;

public class WeightedWithHeightQuickUnion {
	private int id[];
	private int count;
	private int he[];
	
	public WeightedWithHeightQuickUnion(int N) {
		count =N;
		id = new int[N];
		for(int i =0;i<N;i++)
			id[i] = i;
		he = new int[N];
		for(int i =0;i<N;i++)
			he[i] = 0;
	}
	
	public int count()
	{ return count;}
	
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	
	public int find(int p) {
		while(p!=id[p])	p = id[p];
		return p;
	}
	
	public void printString() {
		for(int i=0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
	public void union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) return;
		
		if(he[pRoot]>he[qRoot]) 	 id[qRoot] = pRoot;
		else{
			id[pRoot] = qRoot; 
			if(he[qRoot]==he[pRoot])
				he[qRoot]++;
		}
	}
}
