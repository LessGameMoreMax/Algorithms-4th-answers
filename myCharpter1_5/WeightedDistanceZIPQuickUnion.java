package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;

public class WeightedDistanceZIPQuickUnion {
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedDistanceZIPQuickUnion(int N) {
		count = N;
		id = new int[N];
		for(int i =0;i<N;i++)
			id[i] = i;
		sz =new int[N];
		for(int i=0;i<N;i++)
			sz[i] = 1;
	}
	
	public int count()
	{return count;}
	
	public boolean connected(int q,int p)
	{return find(q)==find(p);}
	
	public int find(int p) {
		if(id[p]!=p) id[p] =find(id[p]);
		return id[p];
	}
	
	public void union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) return;
		
		if(sz[pRoot]>sz[qRoot]) {id[qRoot] = pRoot; sz[pRoot]+=sz[qRoot];}
		else					{id[pRoot] = qRoot; sz[qRoot]+=sz[pRoot];}
		count--;
	}
	
	public void printString() {
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		WeightedDistanceZIPQuickUnion test = new WeightedDistanceZIPQuickUnion(10);
		while(!StdIn.isEmpty()) {
			int q = StdIn.readInt();
			int p = StdIn.readInt();
			test.union(p, q);
			test.printString();
		}
	}
}
